package DSA.B_Sorting.A_Basics;

public class InsertionSortProblem3 {
    public static void insertionSort(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            int temp = arr[i];
            int j = i - 1;
            while (j >= 0 && arr[j] > temp) {
                arr[j + 1] = arr[j];
                j--;
            }

            arr[j + 1] = temp;
        }
    }

    public static void insertionSortRec(int[] arr, int n) {
        if (n <= 0) {
            return;
        }
        insertionSortRec(arr, n - 1);

        int temp = arr[n - 1];
        int j = n - 2;
        while (j >= 0 && arr[j] > temp) {
            arr[j+1] = arr[j];
            j--;
        }
        arr[j + 1] = temp;
    }

    public static void main(String[] args) {


    }
}
