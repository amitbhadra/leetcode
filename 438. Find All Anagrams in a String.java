/*
 * 438. Find All Anagrams in a String Medium
 * 
 * Given a string s and a non-empty string p, find all the start indices of p's
 * anagrams in s.
 * 
 * Strings consists of lowercase English letters only and the length of both
 * strings s and p will not be larger than 20,100.
 * 
 * The order of output does not matter.
 * 
 * Example 1:
 * 
 * Input: s: "cbaebabacd" p: "abc"
 * 
 * Output: [0, 6]
 * 
 * Explanation: The substring with start index = 0 is "cba", which is an anagram
 * of "abc". The substring with start index = 6 is "bac", which is an anagram of
 * "abc".
 * 
 * Example 2:
 * 
 * Input: s: "abab" p: "ab"
 * 
 * Output: [0, 1, 2]
 * 
 * Explanation: The substring with start index = 0 is "ab", which is an anagram
 * of "ab". The substring with start index = 1 is "ba", which is an anagram of
 * "ab". The substring with start index = 2 is "ab", which is an anagram of
 * "ab".
 */

class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> result = new ArrayList<>();
        if(s.length()==0) return result;
        HashMap<Character, Integer> map = new HashMap<>();
        for(char c:p.toCharArray()) {
            map.put(c, map.getOrDefault(c,0)+1);
        }
        int start = 0, end = 0, key;
        char c;
        while(end<s.length()) {
            c = s.charAt(end);
            if(map.containsKey(c)) {
                key = map.get(c);
                if(key==1)
                    map.remove(c);
                else
                    map.put(c, key-1);
                if(end-start==p.length()-1) {
                    result.add(start);
                }
                end++;
            }
            else if(start==end) {
                start++;
                end++;
            }
            else {
                map.put(s.charAt(start), map.getOrDefault(s.charAt(start),0)+1);
                start++;
            }
        }
        return result;
    }
}