/*
 * 49. Group Anagrams Medium
 * 
 * Given an array of strings, group anagrams together.
 * 
 * Example:
 * 
 * Input: ["eat", "tea", "tan", "ate", "nat", "bat"], Output: [
 * ["ate","eat","tea"], ["nat","tan"], ["bat"] ]
 * 
 * Note:
 * 
 * All inputs will be in lowercase. The order of your output does not matter.
 * 
 */

class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        
        HashMap<String, ArrayList<String>> map = new HashMap<>();
        String code;
        ArrayList<String> temp;
        for(String str:strs) {
            code = findEncoding(str);
            if(!map.containsKey(code)) {
                map.put(code, new ArrayList<String>(Arrays.asList(str)));
            }
            else {
                temp = map.get(code);
                temp.add(str);
                map.put(code, temp);
            }
        }
        return new ArrayList<>(map.values());
        /*
        List<List<String>> result = new ArrayList<>();
        for(String str:map.keySet()) {
            temp = map.get(str);
            result.add(temp);
        }
        return result;
        */
    }
    public String findEncoding(String s) {
        int[] res = new int[26];
        for(char c:s.toCharArray()) {
            res[c-'a']++;
        }
        String encoded="";
        for(int i=0; i<res.length; i++) {
            if(res[i]!=0) {
                encoded+= (char)(i+'a') + Integer.toString(res[i]);
            }
        }
        return encoded;
    }
}