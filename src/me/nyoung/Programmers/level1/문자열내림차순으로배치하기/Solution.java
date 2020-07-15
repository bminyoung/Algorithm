package me.nyoung.Programmers.level1.문자열내림차순으로배치하기;

import java.util.Arrays;

public class Solution {
    public String solution(String s) {
        char[] tmp = s.toCharArray();
        Arrays.sort(tmp);
        return new StringBuilder(new String(tmp)).reverse().toString();
    }
}
