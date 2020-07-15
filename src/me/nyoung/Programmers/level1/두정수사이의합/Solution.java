package me.nyoung.Programmers.level1.두정수사이의합;

public class Solution {
    public long solution(int a, int b) {
        return a > b ? (long)(a+b)*(long)(a-b+1)/2 : (long)(a+b)*(long)(b-a+1)/2;
    }
}
