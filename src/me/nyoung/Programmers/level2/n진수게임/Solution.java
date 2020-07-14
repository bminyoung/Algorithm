package me.nyoung.Programmers.level2.n진수게임;

class Solution {
    public String solution(int n, int t, int m, int p) {
        StringBuilder sb = new StringBuilder();
        StringBuilder nums = new StringBuilder("0");
        int end = (t-1)*m + p+1;
        int num = 1;
        while(nums.toString().length() < end) {
            nums.append(numConv(num++, n));
        }

        String list = nums.toString();
        for(int i = 0; i < t; i++) {
            sb.append(list.charAt(p-1 + i*m));
        }

        return sb.toString();
    }
    public String numConv(int n, int base) {
        StringBuilder sb = new StringBuilder();
        while(n > 0) {
            int rem = n%base;
            if(rem < 10) sb.append(rem);
            else sb.append(Character.toChars('A'+rem-10));
            n /= base;
        }

        return sb.reverse().toString();
    }
}