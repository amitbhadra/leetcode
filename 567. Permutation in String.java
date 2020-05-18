/*
 * 567. Permutation in String Medium
 * 
 * Given two strings s1 and s2, write a function to return true if s2 contains
 * the permutation of s1. In other words, one of the first string's permutations
 * is the substring of the second string.
 * 
 * 
 * 
 * Example 1:
 * 
 * Input: s1 = "ab" s2 = "eidbaooo" Output: True Explanation: s2 contains one
 * permutation of s1 ("ba").
 * 
 * Example 2:
 * 
 * Input:s1= "ab" s2 = "eidboaoo" Output: False
 * 
 * 
 * 
 * Note:
 * 
 * The input strings only contain lower case letters. The length of both given
 * strings is in range [1, 10,000].
 * 
 */

class Solution {
    public boolean checkInclusion(String s1, String s2) {
        HashMap<Character, Integer> map = new HashMap<>();
        for(char c:s1.toCharArray()) {
            map.put(c, map.getOrDefault(c,0)+1);
        }
        int start = 0, end = 0, key;
        char c;
        while(end<s2.length()) {
            c = s2.charAt(end);
            if(map.containsKey(c)) {
                //System.out.println(end);
                key = map.get(c);
                if(key==1) {
                    map.remove(c);
                }
                else map.put(c, key-1);
                if(end-start==s1.length()-1)
                    return true;
                end++;
            }
            else if(start==end) {
                start++;
                end++;
            }
            else {
                map.put(s2.charAt(start), map.getOrDefault(s2.charAt(start),0)+1);
                start++;
            }
        }
        return false;
    }
}