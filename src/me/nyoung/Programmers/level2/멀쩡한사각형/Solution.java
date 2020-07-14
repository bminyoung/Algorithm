package me.nyoung.Programmers.level2.멀쩡한사각형;

class Solution {
    public long solution(int w,int h) {
        int gcd = gcd(w, h);
        long whole = (long)w*(long)h;

        return whole - (w+h-gcd);
    }

    int gcd(int a, int b){
        return b == 0 ? a : gcd(b, a%b);
    }
}