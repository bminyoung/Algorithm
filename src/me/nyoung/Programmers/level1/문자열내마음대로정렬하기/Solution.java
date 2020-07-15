package me.nyoung.Programmers.level1.문자열내마음대로정렬하기;

import java.util.Arrays;
import java.util.Comparator;

public class Solution {
    public String[] solution(String[] strings, int n) {
        Arrays.sort(strings, (str1, str2) -> {
            if(str1.charAt(n) == str2.charAt(n)) return str1.compareTo(str2);
            return str1.charAt(n)-str2.charAt(n);
        });
        return strings;
    }
}
