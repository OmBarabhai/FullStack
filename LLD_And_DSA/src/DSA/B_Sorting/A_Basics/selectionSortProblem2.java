package DSA.B_Sorting.A_Basics;

public class selectionSortProblem2 {
    public static void selectionSort(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            int mini = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] < arr[mini]) {
                    mini = j;
                }
            }
            int temp = arr[i];
            arr[i] = arr[mini];
            arr[mini] = temp;
        }
    }

    public static void selectionSortRec(int[] arr, int n) {
        if (n >= arr.length-1) {
            return;
        }
        int mini = n;
        for (int i = n+1; i < arr.length; i++) {
            if (arr[i] < arr[mini]) {
                mini = i;
            }
        }
        int temp = arr[n];
        arr[n] = arr[mini];
        arr[mini] = temp;
        selectionSortRec(arr, n - 1);

    }
    public static void main(String[] args) {

    }
}
