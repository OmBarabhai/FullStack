package DSA.A_Recursion.A_Part_01;

import java.util.ArrayList;

public class Solution {

    public static void generateCombinations(ArrayList<String> result, int currentIndex, String digits, StringBuilder current, String[] keypad) {

        // ===========================
        // BREAKPOINT 1 (Base Case)
        // ===========================
        if (currentIndex == digits.length()) {
            result.add(current.toString());
            return;
        }

        // Current digit
        int digit = digits.charAt(currentIndex) - '0';

        // Letters for current digit
        String letters = keypad[digit];

        // Loop through all possible letters
        for (int i = 0; i < letters.length(); i++) {

            // ===========================
            // BREAKPOINT 2 (Choose)
            // ===========================
            current.append(letters.charAt(i));

            // ===========================
            // BREAKPOINT 3 (Recursive Call)
            // ===========================
            generateCombinations(result, currentIndex + 1, digits, current, keypad);

            // ===========================
            // BREAKPOINT 4 (Backtracking)
            // ===========================
            current.deleteCharAt(current.length() - 1);
        }
    }

    public static ArrayList<String> combinations(String digits) {

        ArrayList<String> result = new ArrayList<>();

        String[] keypad = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};

        generateCombinations(result, 0, digits, new StringBuilder(), keypad);

        return result;
    }

    public static void main(String[] args) {

        String digits = "23";

        ArrayList<String> ans = combinations(digits);

        System.out.println(ans);
    }


//
//import java.util.Arrays;
//
//
//    public static int merge(int[] arr, int s, int e, int mid) {
//
//        int leftArrLen = mid - s + 1;
//        int rightArrLen = e - mid;
//
//        int[] leftArr = new int[leftArrLen];
//        int[] rightArr = new int[rightArrLen];
//
//        // Copy left array
//        int k = s;
//        for (int i = 0; i < leftArrLen; i++) {
//            leftArr[i] = arr[k++];
//        }
//
//        // Copy right array
//        k = mid + 1;
//        for (int j = 0; j < rightArrLen; j++) {
//            rightArr[j] = arr[k++];
//        }
//
//        System.out.println("\n==================================");
//        System.out.println("Merging from index " + s + " to " + e);
//        System.out.println("Left Array  : " + Arrays.toString(leftArr));
//        System.out.println("Right Array : " + Arrays.toString(rightArr));
//
//        int i = 0;
//        int j = 0;
//        k = s;
//        int invCount = 0;
//
//        while (i < leftArrLen && j < rightArrLen) {
//
//            System.out.println("\nComparing " + leftArr[i] + " and " + rightArr[j]);
//
//            if (leftArr[i] <= rightArr[j]) {
//                System.out.println(leftArr[i] + " <= " + rightArr[j] + " -> Take " + leftArr[i]);
//                arr[k++] = leftArr[i++];
//            } else {
//
//                System.out.println(leftArr[i] + " > " + rightArr[j]);
//
//                System.out.println("Remaining elements in left array = " + (leftArrLen - i));
//                System.out.println("Adding " + (leftArrLen - i) + " inversions");
//
//                invCount += (leftArrLen - i);
//
//                arr[k++] = rightArr[j++];
//            }
//        }
//
//        while (i < leftArrLen) {
//            arr[k++] = leftArr[i++];
//        }
//
//        while (j < rightArrLen) {
//            arr[k++] = rightArr[j++];
//        }
//
//        System.out.println("Merged Array : " +
//                Arrays.toString(Arrays.copyOfRange(arr, s, e + 1)));
//
//        System.out.println("Merge inversion count = " + invCount);
//
//        return invCount;
//    }
//
//    public static int mergeSort(int[] arr, int s, int e) {
//
//        if (s >= e) {
//            return 0;
//        }
//
//        int mid = (s + e) / 2;
//
//        System.out.println("\nmergeSort(" + s + ", " + e + ")");
//        System.out.println("Mid = " + mid);
//
//        int leftInv = mergeSort(arr, s, mid);
//        int rightInv = mergeSort(arr, mid + 1, e);
//        int mergeInv = merge(arr, s, e, mid);
//
//        int total = leftInv + rightInv + mergeInv;
//
//        System.out.println("Total inversions from " + s + " to " + e + " = " + total);
//
//        return total;
//    }
//
//    public static int inversionCount(int[] arr) {
//        return mergeSort(arr, 0, arr.length - 1);
//    }
//
//    public static void main(String[] args) {
//
//        // Best example for debugging
//        int[] arr = {2, 4, 1, 3, 5};
//
//        System.out.println("Original Array : " + Arrays.toString(arr));
//
//        int ans = inversionCount(arr);
//
//        System.out.println("\n==================================");
//        System.out.println("Sorted Array : " + Arrays.toString(arr));
//        System.out.println("Total Inversions = " + ans);
//    }
}
