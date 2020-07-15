package me.nyoung.Programmers.level2.Jadencase문자열만들기;

public class Solution {
    public String solution(String s) {
        String answer = "";
        s = s.toLowerCase();
        answer += Character.toUpperCase(s.charAt(0));

        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i-1) == ' ' && s.charAt(i) != ' ') {
                answer += (char) ((int) s.charAt(i) - 32);
            } else {
                answer += s.charAt(i);
            }
        }
        return answer;
    }
}
