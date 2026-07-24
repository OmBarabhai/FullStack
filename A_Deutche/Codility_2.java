
import java.util.HashMap;
import java.util.HashSet;

import javax.crypto.Mac;

class Codility_2 {

    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int need = target - nums[i];
            if (map.containsKey(need)) {
                return new int[]{map.get(need), i};
            }
            map.put(nums[i], i);
        }
        return new int[]{};
    }

    public boolean containsDuplicate(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        for (int num : nums) {
            if (set.contains(num)) {
                return true;
            }
            set.add(num);
        }
        return false;
    }

    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        int[] freq = new int[26];
        for (int i = 0; i < s.length(); i++) {
            freq[s.charAt(i) - 'a']++;
            freq[t.charAt(i) - 'a']--;
        }
        for (int ans : freq) {
            if (ans != 0) {
                return false;
            }
        }
        return true;
    }

    public int missingNumber(int[] nums) {
        int xor = 0;
        for (int i = 0; i < nums.length; i++) {
            xor ^= i;
            xor ^= nums[i];
        }
        return xor;
    }

    public int singleNumber(int[] nums) {
        int ans = 0;
        for (int num : nums) {
            ans ^= num;
        }
        return ans;
    }

    public int majorityElement(int[] nums) {
        int candidate = 0;
        int count = 0;
        for (int num : nums) {
            if (count == 0) {
                candidate = num;
            }
            if (num == candidate) {
                count++;
            } else {
                count--;
            }
        }
        int freq = 0;
        for (int num : nums) {
            if (num == candidate) {
                freq++;
            }
        }
        if (freq > nums.length / 2) {
            return candidate;
        }
        return -1;
    }

    public int[] intersection(int[] nums1, int[] nums2) {
        HashSet<Integer> set = new HashSet<>();
        HashSet<Integer> ans = new HashSet<>();

        for (int num : nums2) {

            set.add(num);
        }
        for (int num : nums1) {
            if (set.contains(num)) {
                ans.add(num);
            }
        }
        int[] res = new int[ans.size()];
        int idx = 0;
        for (int num : ans) {
            res[idx++] = num;
        }
        return res;
    }

    public int maxProfit(int[] prices){
      int minPrice = Integer.MAX_VALUE;
      int maxProfit = 0;
      for(int price : prices){
        if(price<minPrice){
          minPrice = price;
        }
        else{
          maxProfit = Math.max(maxProfit, price - minPrice);
        }
      }
      return maxProfit;
    }
    public int maxSubArray(int[] nums){
      int currentSum = nums[0];
      int maxSum = nums[0];
      for(int i =0;i<nums.length;i++){
        currentSum = Math.max(nums[i], currentSum + nums[i]);
        maxSum = Math.max(maxSum, currentSum);
      }
    }
}
