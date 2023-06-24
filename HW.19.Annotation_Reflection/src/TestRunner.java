import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.*;
import java.util.stream.Collectors;

public class TestRunner {

    private static final String[] MUST_HAVE_ANNOTATIONS = {"Test", "BeforeSuite","AfterSuite"};

    public static  void start(Class<?> cls) throws InvocationTargetException, IllegalAccessException,
            NoSuchMethodException, InstantiationException, WrongAnnotationQty {

        // get methods from the class
        Constructor<?> constructor = cls.getConstructor();
        Object obj = constructor.newInstance();
        Method[] meths = obj.getClass().getDeclaredMethods();
        if(!checkAnnotationsValidity(meths)) throw new WrongAnnotationQty();


        // check, whether all annotations are present in the class under test
        // if so, we run methods with annotations in the sequence
        if(checkIfAllAnnotationsPresent(meths)){
            runMethodExceptTest(obj, meths, "BeforeSuite");
            runTestMethods(obj, meths);
            runMethodExceptTest(obj, meths, "AfterSuite");
        }
    }

    private static void runMethodExceptTest(Object obj, Method[] meths, String anno) throws InvocationTargetException, IllegalAccessException {
        for (Method meth : meths){
            for (Annotation ann: meth.getDeclaredAnnotations()){
                if(ann.annotationType().getName().contains(anno) && !anno.equals("Test")) {
                    System.out.println("Exec method with annotation: " + anno);
                    meth.invoke(obj);
                }
            }
        }
    }

    private static void runTestMethods(Object obj, Method[] meths) throws InvocationTargetException, IllegalAccessException {

        for (Method meth : getSortedTestMethodsByPriority(meths)) {
            System.out.println("Exec method with priority: " + meth.getDeclaredAnnotation(Test.class).value());
            meth.invoke(obj);
        }

    }

    private static boolean checkIfAllAnnotationsPresent(Method[] meths){

        Set<String> setOfMustHaveAnnotations = Set.of(TestRunner.MUST_HAVE_ANNOTATIONS);
        Set<String> setOfMethodAnnotations = new HashSet<>();
        for (Method meth : meths){
            for (Annotation anno : meth.getDeclaredAnnotations()){
                setOfMethodAnnotations.add(anno.annotationType().getName());
            }
        }

        return setOfMustHaveAnnotations.containsAll(setOfMethodAnnotations);
    }

    public static boolean checkAnnotationsValidity(Method[] meths){

        boolean flag = true;
        List<List<String>> annotationList=  new ArrayList<>();
        for(Method meth : meths){
            annotationList.add(Arrays.stream(meth.getDeclaredAnnotations())
                    .filter(annotation -> !annotation.annotationType().getName()
                            .equals("Test"))
                    .map(annotation -> annotation.annotationType().getName())
                    .collect(Collectors.toList()));
        }
       Set<String> uniqueAnnotations = new HashSet<>();
       uniqueAnnotations.addAll(flattenList(annotationList));
       return uniqueAnnotations.size() == 2 && flattenList(annotationList).size() == 2;


    }

    private  static List<String> flattenList(List<List<String>> annotationList){
        List<String> res = new ArrayList<>();
        annotationList.stream().flatMap(Collection::stream).forEach(res::add);
        return res;
    }

    public static List<Method> getSortedTestMethodsByPriority(Method[] meths){
        return  Arrays.stream(meths).filter(method ->
                        Arrays.stream(method.getDeclaredAnnotations())
                                .allMatch(anno ->anno.annotationType().getName().equals("Test")))
                .sorted((m1, m2) -> m2.getDeclaredAnnotation(Test.class).value() -
                        m1.getDeclaredAnnotation(Test.class).value()).toList();
    }

    public static void main(String[] args) {
        Document doc = new Document();
        try {
            start(Document.class);
        }catch (InvocationTargetException | IllegalAccessException | NoSuchMethodException | InstantiationException |
                WrongAnnotationQty e) {
            System.out.println(e);
        }

    }
}
