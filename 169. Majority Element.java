/*
Given an array of size n, find the majority element. The majority element is the element that appears more than ⌊ n/2 ⌋ times.

You may assume that the array is non-empty and the majority element always exist in the array.

Example 1:

Input: [3,2,3]
Output: 3

Example 2:

Input: [2,2,1,1,1,2,2]
Output: 2
*/

public class Solution {
    public int majorityElement(int[] num) {

        int major=num[0], count = 1;
        for(int i=1; i<num.length;i++) {
            if(count==0) {
                count++;
                major=num[i];
            } 
            else if(major==num[i]) {
                count++;
            } 
            else count--;
            
        }
        return major;
    }
}


/*
Using hashmap
*/

class Solution {
    public int majorityElement(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int max=0, max_num = 0;
        for(int i : nums) {
            map.put(i, map.getOrDefault(i,0)+1);
            if(max<map.get(i)) {
                max = map.get(i);
                max_num = i;
            }
        }
        return max_num;
    }
}