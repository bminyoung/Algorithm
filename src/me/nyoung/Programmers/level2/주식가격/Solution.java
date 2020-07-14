package me.nyoung.Programmers.level2.주식가격;

class Solution {
    public int[] solution(int[] prices) {
        int[] ret = new int[prices.length];

        for(int i = 0; i < prices.length; i++) {
            for(int j = i+1; j < prices.length; j++) {
                ret[i]++;
                if(prices[i] > prices[j]) break;
            }
        }

        return ret;
    }
}