package me.nyoung.Programmers.level3.거스름돈;

import java.util.Arrays;

class Solution {
    public int solution(int n, int[] money) {
        long[] ways = new long[n+1];
        Arrays.sort(money);

        for(int i = 0; i <= n; i += money[0]) {
            ways[i] = 1;
        }

        for(int i = 1; i < money.length; i++) {

            for(int j = money[i]; j <= n; j++) {
                ways[j] += ways[j-money[i]];
            }
        }

        return (int)(ways[n] % 1000000007);
    }
}