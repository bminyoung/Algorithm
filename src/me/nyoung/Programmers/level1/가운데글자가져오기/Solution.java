package me.nyoung.Programmers.level1.가운데글자가져오기;

public class Solution {
    public String solution(String s) {
        return s.length() % 2 != 0 ? s.charAt(s.length()/2)+"" : s.substring(s.length()/2-1, s.length()/2+1);
    }
}
