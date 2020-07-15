package me.nyoung.Programmers.level2.소수만들기;

public class Solution {
    public int solution(int[] nums) {
        int answer = 0;
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                for (int k = j + 1; k < nums.length; k++) {
                    if (isPrime(nums[i] + nums[j] + nums[k])) answer++;
                }
            }
        }
        return answer;
    }

    boolean isPrime(int num) {

        double lim = Math.sqrt(num);
        for (int i = 2; i <= lim; i++) {
            if (num % i == 0) return false;
        }
        return true;
    }
}
