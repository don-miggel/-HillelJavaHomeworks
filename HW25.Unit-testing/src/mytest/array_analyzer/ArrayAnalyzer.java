package mytest.array_analyzer;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ArrayAnalyzer {


    public int[] analyzeArray(int[] inputNumbers){

        int[] output;
        if(inputNumbers == null || inputNumbers.length == 0){
            System.out.println("You have passed either null or an empty array!");
            return new int[]{};
        }
        int idx = -1;
        for(int i = inputNumbers.length-1; i >= 0; i--){
            if(inputNumbers[i] == 4){
                idx = i;
                break;
            }
        }

        if(idx == -1){
            throw new RuntimeException();
        }

        output = new int[inputNumbers.length - idx-1];

        System.out.println(inputNumbers.length - idx);
        if (inputNumbers.length - 1 - idx >= 0)
            System.arraycopy(inputNumbers, idx + 1, output, 0,
                                            inputNumbers.length - 1 - idx);
        return output;
    }

    public boolean analyzeFoursOnesArray(int[] arr){

        List<Integer> inputArr = Stream.of(arr)
                            .filter(l->l!= null && l.length >0)
                            .flatMap(a -> Arrays.stream(a).boxed()).toList();

        Set<Integer> setOutput = new HashSet<>(new ArrayList<>(inputArr));

        boolean containsOneAndFour = setOutput.containsAll(Set.of(1,4));
        setOutput.removeAll(Set.of(1,4));
        return containsOneAndFour && setOutput.size() == 0;
    }

    public static void main(String[] args) {
        ArrayAnalyzer ar = new ArrayAnalyzer();
//        ar.analyzeFoursOnesArray(new int[]{ 4, 4, 1, 1, 4, 1 });
        System.out.println(ar.analyzeFoursOnesArray(new int[]{ }));
    }

}
