package DSA.B_Sorting.A_Basics;

import java.util.Arrays;

public class ImplementBubbleSort {
    public static void bubbleSort(int[] arr){
        for(int i = 0;i<arr.length;i++){
            for(int j = 0;j<arr.length-1;j++){
                if(arr[j] > arr[j+1]){
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
            }

        }
    }
    public static void bubbleSortRec(int[] arr,int n){
        if(n <= 0){
            return;
        }
        for (int i = 0; i < n; i++) {
            if(arr[i] > arr[i+1]){
                int temp = arr[i];
                arr[i] = arr[i+1];
                arr[i+1] = temp;
            }
        }
        bubbleSortRec(arr,n-1);
    }
    public static void main(String[] args) {
        int[] arr = {5, 1, 4, 2, 8};

        bubbleSort(arr);
        bubbleSortRec(arr,4);

        System.out.println(Arrays.toString(arr));
    }
}
