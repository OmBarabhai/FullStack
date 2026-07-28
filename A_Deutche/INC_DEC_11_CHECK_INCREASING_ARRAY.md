# DB_INC_DEC_01_CHECK_INCREASING_ARRAY

## Recognition Keywords

- Increasing Array
- Ascending Order
- Sorted Array
- Strictly Increasing

👉 Think: Compare Adjacent Elements

---

## Short Problem Statement

Given an integer array.

Return `true` if the array is in strictly increasing order, otherwise return `false`.

---

## Function Signature

```java
public boolean isIncreasing(int[] nums)
```

---

## Optimal Java Solution

```java
class Solution {

    public boolean isIncreasing(int[] nums) {

        for (int i = 1; i < nums.length; i++) {

            if (nums[i] <= nums[i - 1]) {
                return false;
            }
        }

        return true;
    }
}
```

---

## Complexity

Time : O(n)

Space : O(1)

---

## Memory Trick

Compare
      ↓
Previous
      ↓
Increasing?
```