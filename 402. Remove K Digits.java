/*
 * Given a non-negative integer num represented as a string, remove k digits
 * from the number so that the new number is the smallest possible.
 * 
 * Note:
 * 
 * The length of num is less than 10002 and will be ≥ k. The given num does not
 * contain any leading zero.
 * 
 * Example 1:
 * 
 * Input: num = "1432219", k = 3 Output: "1219" Explanation: Remove the three
 * digits 4, 3, and 2 to form the new number 1219 which is the smallest.
 * 
 * Example 2:
 * 
 * Input: num = "10200", k = 1 Output: "200" Explanation: Remove the leading 1
 * and the number is 200. Note that the output must not contain leading zeroes.
 */

class Solution {
    public String removeKdigits(String num, int k) {
        Stack<Character> stack = new Stack<>();
        char c;
        String res="", temp="";
        int i;
        for(i=0; i<num.length(); i++) {
            c = num.charAt(i);
            while(stack.size()>0&&c<stack.peek()) {
                k--;
                stack.pop();
                if(k==0) break;
            }
            if(k==0) break;
            stack.push(c);
        }

        temp = "";
        while(!stack.isEmpty()) {
            temp = stack.pop() + temp;
        }
        res = res+temp+num.substring(i);
        while(k!=0&&res.length()>0) {
            res = res.substring(0, res.length()-1);
            k--;
        }
        while(res.length()>0&&res.charAt(0)=='0') {
            res = res.substring(1);
        }
        if(res.length()==0) res = "0";
        return res;
    }
}