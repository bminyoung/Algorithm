package me.nyoung.Programmers.level1.시저암호;

public class Solution {
    public String solution(String s, int n) {
        StringBuilder answer = new StringBuilder();
        char[] arrChar = s.toCharArray();

        for (int i = 0; i < arrChar.length; i++) {
            if (arrChar[i] == ' ') {
                answer.append(' ');
                continue;
            }
            int limit = Character.isUpperCase(arrChar[i]) ? 90 : 122;
            char result = (char)(arrChar[i] + n);
            if (result > limit) result -= (char)26;
            answer.append(result);
        }

        return answer.toString();
    }
}
