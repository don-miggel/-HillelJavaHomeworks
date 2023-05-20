import java.util.ArrayList;
import java.util.List;

public class ListTasks {

    public static void main(String[] args) {
        // 1-st task

        System.out.println("Number of word 'Java' in the list: "+
                countOccurance(List.of("Java", "C#", "Java Script","Java", "Python", "Go", "Kotlin", "C#", "Java"),
                "Java"));

        // task 2
        List<String> lstStr = toList(new String[]{"Java", "C#", "Go", "Ruby"});
        System.out.println("String List: "+lstStr);
        List<Float> lstFloat = toList(new Float[]{0.1f, 0.3f, 0.7f, 0.9f});
        System.out.println("Float List: "+lstFloat);
        // task 3
        System.out.println("Unique elements: "+ findUnique(List.of(0.1, 0.2, 3, 0,1, 0,3, 0, 3, 0.1, 5, 7)));
        // task 4**
        calcOccurance(List.of("Java", "C#", "Java Script","Java", "Python", "Go", "C#", "Kotlin", "Java",
                "Ruby", "C++", "Java", "C#"));
        // task 4***
        System.out.println(findOccurance(List.of("Java", "C#", "Java Script","Java", "Python", "Go", "C#",
                "Kotlin", "Java", "Ruby", "C++", "Java", "C#")));

    }

    private static int countOccurance(List<String> wordList, String wordToCount){
        int count = 0;
        for (String word : wordList){
            if(word.equalsIgnoreCase(wordToCount))
                count++;
        }
        return count;
    }

    private static <T> List<T> toList(T[] args){

        return new ArrayList<T>(List.of(args));
    }

    private static List<Number> findUnique(List<Number> lstNum){
        List<Number> lstUnique = new ArrayList<>();
        for (Number num: lstNum){
            if(!lstUnique.contains(num))
                lstUnique.add(num);
        }
        return lstUnique;
    }

    private static void calcOccurance(List<String> lstStr){
        int countOccurance;
        StringBuilder outputStr = new StringBuilder();
        for (String str : lstStr){
            countOccurance = 0;
            for(int i = 0; i < lstStr.size(); i++){
                if (str.equalsIgnoreCase(lstStr.get(i)))
                    countOccurance++;
            }
            String strToInsert = str+": "+countOccurance+'\n';
            if (outputStr.indexOf(strToInsert) < 0)
                outputStr.append(strToInsert);
        }
        System.out.println(outputStr);
    }

    private static List<Occurance> findOccurance(List<String> lstStr){
        int countOccurance;
        List<Occurance> lstOccur = new ArrayList<>();
        for (String str : lstStr){
            countOccurance = 0;
            for(int i = 0; i < lstStr.size(); i++){
                if (str.equalsIgnoreCase(lstStr.get(i)))
                    countOccurance++;
            }

            Occurance occur = new Occurance(countOccurance, str);
            if (!lstOccur.contains(occur))
                lstOccur.add(occur);
        }
        return lstOccur;
    }

}
