package me.nyoung.Programmers.level1.이상한문자만들기;

public class Solution {
    public String solution(String s) {
        String ret = "";
        int i = 0;
        int count = 0;
        while (count < s.length()) {
            count++;
            if(s.charAt(count-1) == ' ') {
                i = 0;
                ret += " ";
                continue;
            }
            if(i % 2 == 0) {
                ret += Character.toUpperCase(s.charAt(count-1));
                i++;
            }
            else {
                ret += Character.toLowerCase(s.charAt(count-1));
                i++;
            }
        }
        return ret;
    }
}
