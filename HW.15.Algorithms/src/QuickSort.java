import java.util.Arrays;
import java.util.Random;

public class QuickSort {

    public static int divideValues(int[] arr, int left, int right){
        Random rnd = new Random();
        int pivot = right;
        int down = left;
        int up = right;
        while (down < up) {
            while (arr[down] < arr[pivot] && down < right)
                down++;
            while (arr[up] >= arr[pivot] && left < up)
                up--;
            if(down < up)
                swap(arr, down, up);
        }
        swap(arr, down, pivot);

        return down;
    }

    public static void quicksort(int[] arr, int left, int right){
        if(left < right){
            int partition = divideValues(arr, left, right);
            quicksort(arr, left, partition-1);
            quicksort(arr, partition+1, right);
        }

    }

    private static void swap(int[] arr, int i, int j){
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }


    public static void main(String[] args) {
        int[] arr = new int[]{1, 5, 3, 8, 6, 15, 23, 9, 17, 36, 78, 52, 14, 52, -2, 45, 63, 71};
        System.out.println(Arrays.toString(arr)+" original array");
        QuickSort.quicksort(arr,0,arr.length-1);

        System.out.println(Arrays.toString(arr)+" sorted array");

    }


}
