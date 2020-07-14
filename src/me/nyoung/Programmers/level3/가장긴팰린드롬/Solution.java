package me.nyoung.Programmers.level3.가장긴팰린드롬;

class Solution {
    public int solution(String s) {
        int answer = 1;
        if (s.length() <= 1) return s.length();
        int max = 1;

        for (int i = 1; i < s.length() - 1; i++) {
            max = 1;
            for (int j = 1; i - j >= 0 && i + j < s.length(); j++) {
                if (s.charAt(i - j) == s.charAt(i + j)) max += 2;
                else break;
            }
            answer = Math.max(answer, max);
        }

        for (int i = 1; i < s.length() - 1; i++) {
            max = 0;
            for (int j = 1; i - j + 1 >= 0 && i + j < s.length(); j++) {
                if (s.charAt(i - j + 1) == s.charAt(i + j)) max += 2;
                else break;
            }
            answer = Math.max(answer, max);
        }

        return answer;
    }
}