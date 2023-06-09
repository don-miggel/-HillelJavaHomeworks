
import java.util.Arrays;

public class ShakerSort {

    private final int[] arr;

    public ShakerSort(int[] arr) {
        this.arr = arr.clone();
    }

    public void shake(boolean asc) {
        int left = 0;
        int right = arr.length - 1;


        while (!isSorted(arr, asc)) {
            if (asc) {
                shakerAsc(arr, left, right, true);
                shakerDesc(arr, left, right, true);
            } else {
                shakerAsc(arr, left, right, false);
                shakerDesc(arr, left, right, false);
            }
            left++;
            right--;
        }

    }

    private static void shakerAsc(int[] arr, int left, int right, boolean direction) {
        if (direction) {
            for (int i = left; i < right; i++) {
                if (arr[i] > arr[i + 1]) {
                    swap(arr, i, i + 1);
                }
            }
        } else {
            for (int i = left; i < right; i++) {
                if (arr[i] < arr[i + 1]) {
                    swap(arr, i, i + 1);
                }
            }
        }
    }

    private static void shakerDesc(int[] arr, int left, int right, boolean direction) {
        if (direction) {
            for (int i = right; i > left; i--) {
                if (arr[i] < arr[i - 1]) {
                    swap(arr, i, i - 1);
                }
            }
        } else {
            for (int i = right; i > left; i--) {
                if (arr[i] > arr[i - 1]) {
                    swap(arr, i, i - 1);
                }
            }
        }
    }

    private static void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    public static boolean isSorted(int[] arr, boolean asc) {

        if (asc) {
            for (int i = 0; i < arr.length - 1; i++) {
                if (arr[i] > arr[i + 1])
                    return false;
            }
        } else {
            for (int i = 0; i < arr.length - 1; i++) {
                if (arr[i] < arr[i + 1])
                    return false;
            }
        }
        return true;
    }

    public String getArr() {
        return Arrays.toString(arr);
    }

    public static void main(String[] args) {
        int[] arr =  new int[]{7, 5, 4, 1, 8, 6, 15, 2, 8, 9, 16};
        System.out.println("Before asc or desc sorting: "+ Arrays.toString(arr));
        ShakerSort shakerSort = new ShakerSort(arr);
        shakerSort.shake(true);
        System.out.println("After asc sorting: "+ shakerSort.getArr());
        ShakerSort shakerSortDesc = new ShakerSort(arr);
        shakerSortDesc.shake(false);
        System.out.println("After desc sorting: "+ shakerSortDesc.getArr());

    }
}
