package DSA.A_Recursion;

public class basics {
    public static void print1toN(int n){
        /*
        * n = 4
        * n == 0 No
        * if(n == 0){
        *   return;  // No
        * }
        *
        * print1toN(n-1); // n
        * print1toN(4-1); // 1
        * print1toN(3-1); // 2
        * print1toN(2-1); // 3
        * print1toN(1-1); // 0
        *  if(n == 0){
        *   return;  // Yes
        * }
        * print1toN(n-1); // n System.out.println(n);
        * print1toN(1-1); // 1 System.out.println(1);
        * print1toN(2-1); // 2 System.out.println(2);
        * print1toN(3-1); // 3 System.out.println(3);
        * print1toN(4-1); // 4 System.out.println(4);
        *
        * */
        if(n == 0){
            return;
        }
        print1toN(n-1);
        System.out.print(n);
        System.out.println();

    }
    public static void printNto1(int n){
        if(n == 0){
            return;
        }

        System.out.print(n);
        System.out.println();

        printNto1(n-1);

        /*
         * n = 4
         * n == 0 No
         * if(n == 0){
         *   return;  // No
         * }
         *
         * print1toN(n-1); // n System.out.println(n);
         * print1toN(4-1); // 4 System.out.println(4);
         * print1toN(3-1); // 3 System.out.println(3);
         * print1toN(2-1); // 2 System.out.println(2);
         * print1toN(1-1); // 1 System.out.println(1);
         *  if(n == 0){
         *   return;  // Yes
         * }
         * System.out.println(n);
         * print1toN(2-1); // 1
         * print1toN(3-1); // 2
         * print1toN(4-1); // 3
         * print1toN(1-1); // 0
         *
         * */
    }
    public static int sumOfN(int n){
        /*
        * sumOfN(n-1)  n = 5
        * sumOfN(5-1)  n = 5
        * sumOfN(4-1)  n = 4
        * sumOfN(3-1)  n = 3
        * sumOfN(2-1)  n = 2
        * sumOfN(1-1)  n = 1
        *
        *  if(n == 0){
        *   return 0;  // Yes
        * }
        *
        * sumOfN(0) returns 0
        *
        * n = 1  1 + sumOfN(0(0));
        * n = 2  2 + sumOfN(1(1));
        * n = 3  3 + sumOfN(2(3));
        * n = 4  4 + sumOfN(3(6));
        * n = 5  5 + sumOfN(4(10));
        *
        * */
        if(n == 0){
            return 0;
        }
        return n + sumOfN(n-1);
    }
    public static int fact(int n){
        if(n <= 0){
            return 1;
        }
        return n * fact(n-1);
    }
    public static String rev(String str){
        /*
        * rev("CAT")
            │
            ├── waits
            │
            ▼
            rev("AT")
            │
            ├── waits
            │
            ▼
            rev("T")
            │
            ├── waits
            │
            ▼
            rev("")
            │
            └── returns ""
            ▲
            │
            returns "T"
            ▲
            │
            returns "TA"
            ▲
            │
            returns "TAC"
            *
            *
            * */
        if(str.isEmpty()){
            return str;
        }
        return  rev(str.substring(1)) + str.charAt(0) ;
    }

    public static boolean palindrome(String str1){
        /*
        * Str1 = CAT
        * palindrome(str1.substring(1, str1.length() - 1))
        * palindrome(str1.substring(C, T))
        *   if(str1.charAt(C) != (str1.charAt(T))){
        *     return false; ?? False
        *   }
        *
        * Str1 = madam
        * palindrome(str1.substring(1, str1.length() - 1))
        * Check palindrome(str1.substring(M, M));
        * palindrome(str1.substring("ADA"));
        *
        *   if(str1.charAt(M) == (str1.charAt(M))){
        *     return true; ?? true
        *   }
        * Check palindrome(str1.substring(A, A));
        * palindrome(str1.substring("D"));
        *   if(str1.charAt(A) == (str1.charAt(A))){
        *     return true; ?? true
        *   }
        *   if(str1.length() <= 1){
        *           return true; Str1 = D ?? 1 Yes true
        *   }
        *  return palindrome(str1.substring("D")); // true
        *
        * */
        if(str1.length()<=1){
            return true;
        }
        if(str1.charAt(0) != (str1.charAt(str1.length()-1))){
            return false;
        }
       return palindrome(str1.substring(1, str1.length() - 1));
    }
    public static  int sumOfDigit(int n){

        /*
        * (n%10) + sumOfDigit(n/10)
        * 1234 % 10 = 4
        * 1234 / 10 = 123
        * (4) + sumOfDigit(123)
        *
        * 123 % 10 = 3
        * 123 / 10 = 12
        * (4 + (3)) + sumOfDigit(12)
        *
        * 12 % 10 = 2
        * 12 / 10 = 1
        * (4+(3+(2))) + sumOfDigit(1)
        *
        * 1 % 10 = 1
        * 1 / 10 = 0
        * ((4+(3+(2+(1)))) + (sumOfDigit(0) return(0))
        *
        * return 0;
        *
        * 2 + 0 = 2
        * 2 + 1 = 3
        * 3 + 3 = 6
        * 6 + 4 = 10
        *
        *
        * */
        if(n == 0){
            return 0;
        }
        return (n%10) + sumOfDigit(n/10);

    }
    public static int countDigits(int n){
        /*
        countDigits(123483758)
            ↓
        1 + countDigits(12348375)
            ↓
        1 + (1 + countDigits(1234837))
            ↓
        1 + (1 + (1 + countDigits(123483)))
            ↓
        1 + (1 + (1 + (1 + countDigits(12348))))
            ↓
        1 + (1 + (1 + (1 + (1 + countDigits(1234)))))
            ↓
        1 + (1 + (1 + (1 + (1 + (1 + countDigits(123)))))))
            ↓
        1 + (1 + (1 + (1 + (1 + (1 + (1 + countDigits(12))))))))
            ↓
        1 + (1 + (1 + (1 + (1 + (1 + (1 + (1 + countDigits(1)))))))))
            ↓
        1 + (1 + (1 + (1 + (1 + (1 + (1 + (1 + (1 + countDigits(0))))))))))
    */
        if(n == 0){
            return 0;
        }
        return 1 + countDigits(n/10);
    }
    public static  int pow(int x,int n){

        /*
            Problem:
            Find x^n

            Current Work:
            Multiply by x

            Smaller Problem:
            Find x^(n-1)

            Base Case:
            n == 0 → return 1

            Dry Run:
            power(2,3)
            2 * power(2,2)
            2 * power(2,1)
            = 8

            Time: O(n)
            Space: O(n)
*/

        if(n == 0){
            return 1;
        }
        return x * pow(x,n-1);
    }
    public static int fib(int n){
        if(n <= 1){
            return  n;
        }
        return fib(n-2) + fib(n-1);
    }

    public static boolean sorted(int[] arr,int idx){
        /*
        *
        * int[] sortedArr = {1,2,3,6,7};
        * idx = 0
        * if(idx == sortedArr.length-1){
        * idx = 0 , n = 4
        * idx = 1 , n = 4
        * idx = 2 , n = 4
        * idx = 3 , n = 4
        * idx = 4 , n = 4
        *
        * 4 == 4
        *  return true;
        *
        * }
        * if(sortedArr[idx] > sortedArr[idx+1]){
        *
        *  sortedArr[0] > sortedArr[0+1]
        *       1       >     2 ? NO else
        *
        *  sortedArr[1] > sortedArr[1+1]
        *       2       >     3 ? NO else
        *
        *  sortedArr[2] > sortedArr[2+1]
        *       3       >     6 ? NO else
        *
        *  sortedArr[3] > sortedArr[3+1]
        *       6       >     7 ? NO else
        *
        * }else{
        *
        *       return sorted(sortedArr,idx+1); // 0 + 1 = 1, 1 + 1 = 2, 2 + 1 = 3, 3 + 1 = 4 (sorted(sortedArr,idx+1) == true);
        *
        * }
        *
        * */
        if(idx == arr.length-1){
            return true;
        }
        if(arr[idx] > arr[idx + 1]){
            return false;
        }
        else{
            return sorted(arr,idx+1);
        }
    }
    public static int firstOccurrence(int[] arr,int target,int idx){
        if(idx == arr.length){
            return -1;
        }
        if(arr[idx] == target){
            return idx;
        }
        return firstOccurrence(arr, target, idx+1);
    }
    public static int lastOccurrence(int[] arr,int target,int idx){
        if(idx < 0){
            return -1;
        }
        if(arr[idx] == target){
            return idx;
        }
        return lastOccurrence(arr, target, idx-1);
    }
    public static int countOccurrences(int[] arr, int target,int idx){
        if(idx == arr.length){
            return 0;
        }
        if(arr[idx] == target){
            return 1 + countOccurrences(arr,target,idx+1);
        }
        return countOccurrences(arr,target,idx+1);
    }
    public static boolean contains(int[] arr,int target,int idx){
        if(idx >= arr.length){
            return false;
        }
        if(arr[idx] == target){
            return true;
        }
        return contains(arr,target,idx+1);
    }

    public static int maxEle(int[] arr, int idx){
        if(idx==arr.length-1){
                return arr[idx];
        }
        int max = maxEle(arr,idx+1);

        return Math.max(max,arr[idx]);

    }
    public static int minEle(int[] arr,int idx){
        if(idx == arr.length-1){
            return arr[idx];
        }
        int min = minEle(arr,idx+1);
        return Math.min(min,arr[idx]);
    }
    public static int sumOfArr(int[] arr,int idx){
        if(idx==arr.length-1){
            return arr[idx];
        }
        return arr[idx]  + sumOfArr(arr,idx+1) ;

    }
    public static int productArr(int[] arr,int idx){
        if(idx == arr.length-1){
            return arr[idx];
        }
        return arr[idx] * productArr(arr,idx+1);
    }
    public static int evenCount(int[] arr,int idx){
        if(idx == arr.length){
            return 0;
        }
        if((arr[idx] & 1) != 1){
            return 1 + evenCount(arr,idx+1);
        }
        return evenCount(arr,idx+1);
    }
    public static int oddCount(int[] arr,int idx){
        if(idx == arr.length){
            return 0;
        }
        if((arr[idx] & 1) == 1){
            return 1 + oddCount(arr,idx+1);
        }
        return  oddCount(arr,idx+1);

    }
    public static int posCount(int[] arr,int idx){
        if(idx == arr.length){
            return 0;
        }
        if(arr[idx] > 0){
            return 1 + posCount(arr,idx+1);
        }
        return posCount(arr,idx+1);
    }
    public static int negCount(int[] arr,int idx){
        if(idx == arr.length){
            return 0;
        }
        if(arr[idx] < 0){
            return 1 + negCount(arr,idx+1);
        }
        return negCount(arr,idx+1);
    }
    public static void main(String[] args) {
        /*
        * if(baseCase){
        * return;
        * }
        *       printNto1(4);
        * // Before recursion (Pre-order work)
        *   recursiveCall();
        *
        *       print1toN(4);
        * // After recursion (Post-order work)
        */
        print1toN(4); // 1
        printNto1(4); // 2
        System.out.println(sumOfN(5));   // 3
        System.out.println(fact(5));     // 4
        System.out.println(rev("CAT")); // 5
        System.out.println(palindrome("CAT")+"\n"+palindrome("MADAM")); // 6
        System.out.println(sumOfDigit(1234)); // 7
        System.out.println(countDigits(123483758)); // 8
        System.out.println(pow(2,8)); // 9
        System.out.println(fib(8)); // 10
        int[] sortedArr = {1,2,3,6,6,99,777};
        int[] unSortedArr = {1,2,2,4,9,5,5};
        System.out.println(sorted(sortedArr,0)+"\n"+sorted(unSortedArr,0)); // 11
        System.out.println(firstOccurrence(sortedArr,6,0)+"\n"+firstOccurrence(unSortedArr,5,0)); // 12
        System.out.println(lastOccurrence(sortedArr,6,sortedArr.length-1)+"\n"+lastOccurrence(unSortedArr,5,unSortedArr.length-1)); // 13
        System.out.println(countOccurrences(sortedArr,6,0)+"\n"+countOccurrences(unSortedArr,5,0)); // 14
        int[] arrTrue = {2,4,6,8,10};
        int  targetTrue = 6;
        int[] arrFalse ={2,4,6,8,10};
        int targetFalse = 5;
        System.out.println(contains(arrTrue,targetTrue,0)+"\n"+contains(arrFalse,targetFalse,0));//15
        System.out.println(maxEle(unSortedArr,0));//16
        System.out.println(minEle(sortedArr,0));//17
        System.out.println("{1,2,3,6,6,99,777} = "+sumOfArr(sortedArr,0)+"\n{1,2,2,4,9,5,5} = "+sumOfArr(unSortedArr,0));//18
        System.out.println("{1,2,3,6,6,99,777} = "+productArr(sortedArr,0)+"\n{1,2,2,4,9,5,5} = "+productArr(unSortedArr,0));//19
        System.out.println("{1,2,3,6,6,99,777} = " + evenCount(sortedArr,0) + "\n{1,2,2,4,9,5,5} = " + evenCount(unSortedArr,0));//20
        System.out.println("{1,2,3,6,6,99,777} = " + oddCount(sortedArr,0) + "\n{1,2,2,4,9,5,5} = " + oddCount(unSortedArr,0));//20
        int[] pos = {-2, 5, 0, -1, 8, 4};
        System.out.println("{-2, 5, 0, -1, 8, 4} = " + posCount(pos,0));//20
        System.out.println("{-2, 5, 0, -1, 8, 4} = " + negCount(pos,0));//21

    }
}
