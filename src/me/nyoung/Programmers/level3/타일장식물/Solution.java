package me.nyoung.Programmers.level3.타일장식물;

class Solution {

    long[] fib;

    public long solution(int N) {
        fib = new long[N];
        fib[0] = 4;
        fib[1] = 6;

        if(N == 1 || N == 2) return fib[N-1];

        for(int i = 2; i < N; i++){
            fib[i] = fib[i-1] + fib[i-2];
        }

        return fib[N-1];
    }
}