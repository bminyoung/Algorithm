package me.nyoung.Programmers.level1._2016년;

public class Solution {
    public String solution(int a, int b) {
        int[] month = new int[] { 31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };
        String[] day = new String[]{"SUN", "MON", "TUE", "WED", "THU", "FRI", "SAT"};
        int diff = 0;
        for (int i = 0; i < a - 1; i++) {
            diff += month[i];
        }
        diff += b + 4; // FRI=5
        diff %= 7;
        return day[diff];
    }
}
