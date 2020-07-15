package me.nyoung.Programmers.level1.문자열다루기기본;

public class Solution {
    public boolean solution(String s) {
        for (int i = 0; i < s.length(); i++) {
            if(!Character.isDigit(s.charAt(i))) return false;
        }
        return s.length() == 4 || s.length() == 6;
    }
}
