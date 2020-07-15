package me.nyoung.Programmers.level1.문자열내p와y의개수;

public class Solution {
    boolean solution(String s) {
        int numP = 0, numY = 0;
        for(int i = 0; i < s.length();i++){
            if(s.charAt(i) == 'p' || s.charAt(i) == 'P')
                numP++;
            if(s.charAt(i) == 'y' || s.charAt(i) == 'Y')
                numY++;
        }
        return numP == numY;
    }
}
