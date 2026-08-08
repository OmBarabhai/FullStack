package DSA.A_Recursion.Part_01.B_Current_Contribution;

/*
=========================================================
          PATTERN 02 : CURRENT CONTRIBUTION
=========================================================

Definition
----------
The current function contributes something to the final
answer while recursion solves the remaining smaller problem.

Unlike Pre- / Post-Order, here recursion RETURNS a value.

---------------------------------------------------------

Execution Flow

GOING DOWN

↓

Smaller Problem

↓

Base Case

↓

COMING BACK

↓

Combine Current Contribution

↓

Return Final Answer

---------------------------------------------------------

Core Formula

Answer

=

Current Contribution

Operator

Recursive Answer

---------------------------------------------------------

Operators

+

Example

n + sum(n-1)

----------------------------

*

Example

n * factorial(n-1)

----------------------------

String Concatenation

Example

reverse(rest) + currentCharacter

----------------------------

Place Value

Example

(lastDigit × placeValue)

+

reverse(remaining)

----------------------------

Math.max()

Math.min()

Custom Combination

---------------------------------------------------------

Recursive Faith

Believe that recursion correctly solves the
smaller problem.

Your responsibility is ONLY to combine
the current contribution.

---------------------------------------------------------

How To Think

Step 1

Find the smaller problem.

↓

Step 2

Trust recursion.

↓

Step 3

Find current contribution.

↓

Step 4

Combine.

↓

Return answer.

---------------------------------------------------------

Recognition

If the question contains

✓ Sum

✓ Total

✓ Product

✓ Reverse

✓ Count

✓ Factorial

✓ Power

✓ Digits

✓ Array Sum

↓

Think

CURRENT CONTRIBUTION

---------------------------------------------------------

Used In

✓ Basic Recursion

✓ Dynamic Programming

✓ Divide & Conquer

✓ Trees

✓ Graph DFS

✓ Backtracking

=========================================================
*/

public class B00CurrentContribution {

    /*
    =========================================================
    Problem 1 : Sum Of N

    Formula

    n + sumOfN(n-1)

    Current Contribution

    n

    Smaller Problem

    sumOfN(n-1)

    Base Case

    n==0

    Dry Run

    sum(4)

    ↓

    sum(3)

    ↓

    sum(2)

    ↓

    sum(1)

    ↓

    sum(0)

    ↓

    0

    ↑

    1

    ↑

    3

    ↑

    6

    ↑

    10

    Time  : O(n)

    Space : O(n)

    =========================================================
    */

    public static int sumOfN(int n){

        if(n==0){
            return 0;
        }

        return n + sumOfN(n-1);

    }

    /*
    =========================================================
    Problem 2 : Factorial

    Formula

    n * factorial(n-1)

    Current Contribution

    n

    Smaller Problem

    factorial(n-1)

    Base Case

    n==0

    Dry Run

    factorial(5)

    ↓

    factorial(4)

    ↓

    factorial(3)

    ↓

    factorial(2)

    ↓

    factorial(1)

    ↓

    factorial(0)

    ↓

    1

    ↑

    1

    ↑

    2

    ↑

    6

    ↑

    24

    ↑

    120

    Time  : O(n)

    Space : O(n)

    =========================================================
    */

    public static int factorial(int n){

        if(n==0){
            return 1;
        }

        return n * factorial(n-1);

    }

    /*
    =========================================================
    Problem 3 : Power

    Formula

    x * power(x,n-1)

    Current Contribution

    x

    Smaller Problem

    power(x,n-1)

    Base Case

    n==0

    Example

    power(2,4)

    ↓

    power(2,3)

    ↓

    power(2,2)

    ↓

    power(2,1)

    ↓

    power(2,0)

    ↓

    1

    ↑

    2

    ↑

    4

    ↑

    8

    ↑

    16

    Time : O(n)

    Space : O(n)

    =========================================================
    */

    public static int power(int x,int n){

        if(n==0){
            return 1;
        }

        return x * power(x,n-1);

    }

    /*
    =========================================================
    Problem 4 : Sum Of Digits

    Formula

    (n%10) + sumOfDigits(n/10)

    Current Contribution

    Last Digit

    Smaller Problem

    Remaining Digits

    Example

    1234

    ↓

    123

    ↓

    12

    ↓

    1

    ↓

    0

    ↓

    0

    ↑

    1

    ↑

    3

    ↑

    6

    ↑

    10

    Time : O(d)

    Space : O(d)

    =========================================================
    */

    public static int sumOfDigits(int n){

        if(n==0){
            return 0;
        }

        return (n%10)+sumOfDigits(n/10);

    }

    /*
    =========================================================
    Problem 5 : Count Digits

    Formula

    1 + countDigits(n/10)

    Current Contribution

    1

    Smaller Problem

    Remaining Digits

    Example

    12345

    ↓

    1234

    ↓

    123

    ↓

    12

    ↓

    1

    ↓

    0

    ↑

    1

    ↑

    2

    ↑

    3

    ↑

    4

    ↑

    5

    Time : O(d)

    Space : O(d)

    =========================================================
    */

    public static int countDigits(int n){

        if(n==0){
            return 0;
        }

        return 1 + countDigits(n/10);

    }
        /*
    =========================================================
    Problem 6 : Reverse String

    Formula

    reverse(rest) + currentCharacter

    Current Contribution

    Current Character

    Smaller Problem

    Reverse Remaining String

    Example

    "JAVA"

    ↓

    "AVA"

    ↓

    "VA"

    ↓

    "A"

    ↓

    ""

    ↑

    "A"

    ↑

    "AV"

    ↑

    "AVA"

    ↑

    "AVAJ"

    Time  : O(n²)
    Space : O(n)

    Note

    String concatenation creates new strings.
    StringBuilder is more efficient.

    =========================================================
    */

    public static String reverse(String str){

        if(str.isEmpty()){
            return "";
        }

        return reverse(str.substring(1)) + str.charAt(0);

    }

    /*
    =========================================================
    Problem 7 : Product Of Array

    Formula

    arr[idx] * productArray(idx+1)

    Current Contribution

    arr[idx]

    Smaller Problem

    Product of remaining array

    Dry Run

    {2,3,4}

    ↓

    2 × product(3,4)

    ↓

    3 × product(4)

    ↓

    4

    ↑

    12

    ↑

    24

    Time  : O(n)

    Space : O(n)

    =========================================================
    */

    public static int productArray(int[] arr,int idx){

        if(idx == arr.length-1){
            return arr[idx];
        }

        return arr[idx] * productArray(arr,idx+1);

    }

    /*
    =========================================================
    Problem 8 : Sum Of Array

    Formula

    arr[idx] + sumArray(idx+1)

    Current Contribution

    arr[idx]

    Smaller Problem

    Sum of remaining array

    Example

    {2,3,4}

    ↓

    2 + sum(3,4)

    ↓

    3 + sum(4)

    ↓

    4

    ↑

    7

    ↑

    9

    Time  : O(n)

    Space : O(n)

    =========================================================
    */

    public static int sumArray(int[] arr,int idx){

        if(idx == arr.length-1){
            return arr[idx];
        }

        return arr[idx] + sumArray(arr,idx+1);

    }

    /*
    =========================================================
    Problem 9 : Product Of Digits

    Formula

    (n % 10) * productOfDigits(n/10)

    Current Contribution

    Last Digit

    Smaller Problem

    Remaining Digits

    Example

    234

    ↓

    23

    ↓

    2

    ↓

    0

    ↑

    1

    ↑

    2

    ↑

    6

    ↑

    24

    Base Case

    return 1

    because 1 is the identity of multiplication.

    Time  : O(d)

    Space : O(d)

    =========================================================
    */

    public static int productOfDigits(int n){

        if(n==0){
            return 1;
        }

        return (n%10) * productOfDigits(n/10);

    }

    /*
    =========================================================
    Problem 10 : Reverse Number

    Formula

    (Last Digit × Place Value)

    +

    Reverse(Remaining)

    Current Contribution

    Last Digit × Place Value

    Smaller Problem

    Reverse Remaining Number

    Example

    78327

    ↓

    7 × 10000

    +

    reverse(7832)

    ↓

    2 × 1000

    +

    reverse(783)

    ↓

    3 × 100

    +

    reverse(78)

    ↓

    8 × 10

    +

    reverse(7)

    ↓

    7

    ↑

    87

    ↑

    387

    ↑

    2387

    ↑

    72387

    Time

    O(d²)

    because countDigits() is called in every recursion.

    Space

    O(d)

    Interview Optimization

    Use Helper Recursion

    ans = ans * 10 + digit

    which runs in

    Time : O(d)

    =========================================================
    */

    public static int reverseNumber(int n){

        if(n==0){
            return 0;
        }

        int lastDigit = n % 10;

        int remaining = n / 10;

        int digits = countDigits(remaining);

        int placeValue = (int)Math.pow(10,digits);

        return lastDigit * placeValue + reverseNumber(remaining);

    }
        /*
    =========================================================

                    PATTERN SUMMARY

    =========================================================

    Current Contribution Pattern

    Solve the smaller problem first.

            ↓

    Trust recursion.

            ↓

    Add your contribution.

            ↓

    Return the final answer.

    ---------------------------------------------------------

    Universal Formula

    Answer

    =

    Current Contribution

    Operator

    Recursive Answer

    ---------------------------------------------------------

    Contribution Types

    1.

    Addition

    Example

    n + sum(n-1)

    ----------------------------

    2.

    Multiplication

    Example

    n * factorial(n-1)

    ----------------------------

    3.

    String Concatenation

    Example

    reverse(rest)

    +

    currentCharacter

    ----------------------------

    4.

    Place Value Contribution

    Example

    lastDigit × placeValue

    +

    reverse(remaining)

    ---------------------------------------------------------

    Recognition

    Whenever you see

    ✓ Sum

    ✓ Product

    ✓ Factorial

    ✓ Power

    ✓ Reverse

    ✓ Count

    ✓ Total

    ✓ Array Sum

    ✓ Array Product

    ✓ Digits

    Think

    CURRENT CONTRIBUTION

    ---------------------------------------------------------

    Questions To Ask Yourself

    1.

    What is my current contribution?

    ↓

    2.

    What is the smaller problem?

    ↓

    3.

    How do I combine them?

    +

    *

    String

    Place Value

    ↓

    4.

    What is the base case?

    ---------------------------------------------------------

    Common Mistakes

    ❌ Forgetting current contribution.

    Example

    return recursion(...);

    instead of

    return current + recursion(...);

    ----------------------------

    ❌ Wrong base case.

    ----------------------------

    ❌ Wrong operator.

    +

    instead of

    *

    ----------------------------

    ❌ Returning before combining.

    ----------------------------

    ❌ Forgetting place value in Reverse Number.

    ---------------------------------------------------------

    Complexity Summary

    Sum Of N

    Time  : O(n)

    Space : O(n)

    ----------------------------

    Factorial

    Time  : O(n)

    Space : O(n)

    ----------------------------

    Power

    Time  : O(n)

    Space : O(n)

    ----------------------------

    Sum Of Digits

    Time  : O(d)

    Space : O(d)

    ----------------------------

    Count Digits

    Time  : O(d)

    Space : O(d)

    ----------------------------

    Reverse String

    Time  : O(n²)

    Space : O(n)

    ----------------------------

    Product Of Array

    Time  : O(n)

    Space : O(n)

    ----------------------------

    Sum Of Array

    Time  : O(n)

    Space : O(n)

    ----------------------------

    Product Of Digits

    Time  : O(d)

    Space : O(d)

    ----------------------------

    Reverse Number

    Time  : O(d²)

    Space : O(d)

    Optimized Helper Version

    Time  : O(d)

    ---------------------------------------------------------

    Interview Frequency

    ⭐⭐⭐⭐⭐

    Foundation For

    ✓ Dynamic Programming

    ✓ Divide & Conquer

    ✓ Trees

    ✓ Graph DFS

    ✓ Backtracking

    ✓ Memoization

    ✓ Tabulation

    ---------------------------------------------------------

    Golden Rule

    Faith

    +

    Current Contribution

    =

    Final Answer

    =========================================================
    */

    public static void main(String[] args){

        int[] arr = {1,2,3,4,5};

        System.out.println("========== Pattern 02 : Current Contribution ==========\n");

        System.out.println("Sum Of N");
        System.out.println(sumOfN(5));

        System.out.println();

        System.out.println("Factorial");
        System.out.println(factorial(5));

        System.out.println();

        System.out.println("Power");
        System.out.println(power(2,5));

        System.out.println();

        System.out.println("Sum Of Digits");
        System.out.println(sumOfDigits(12345));

        System.out.println();

        System.out.println("Count Digits");
        System.out.println(countDigits(12345));

        System.out.println();

        System.out.println("Reverse String");
        System.out.println(reverse("CHATGPT"));

        System.out.println();

        System.out.println("Product Of Array");
        System.out.println(productArray(arr,0));

        System.out.println();

        System.out.println("Sum Of Array");
        System.out.println(sumArray(arr,0));

        System.out.println();

        System.out.println("Product Of Digits");
        System.out.println(productOfDigits(234));

        System.out.println();

        System.out.println("Reverse Number");
        System.out.println(reverseNumber(78327));

    }
}