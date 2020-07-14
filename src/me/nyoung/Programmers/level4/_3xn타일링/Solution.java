package me.nyoung.Programmers.level4._3xn타일링;

class Solution {
    static final int div = 1000000007;

    public int solution(int n) {
        if(n % 2 == 1) return 0;

        long[] d = new long[n+1];
        d[0] = 1;
        d[1] = 3;

        for(int i = 2; i < n/2+1; i ++) {
            d[i] = (4*d[i-1] - d[i-2]) % div;
            if(d[i] < 0) d[i] += div;
        }

        return (int)d[n/2];
    }
}