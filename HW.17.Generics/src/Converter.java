import java.util.ArrayList;
import java.util.List;

public class Converter {

    public static void main(String[] args) {

        List<String> strList = toList(new String[]{"Java", "is", "the", "best"});
        System.out.println(strList);
        List<Float> fList = toList(new Float[]{0.1f, 0.3f, 0.5f, 0.9f});
        System.out.println(fList);
        List<Boolean> booleanList = toList(new Boolean[]{true, false, true});
        System.out.println(booleanList);

    }

    public static <T> List<T> toList(T[] arr){
        return new ArrayList<>(List.of(arr));
    }

}
