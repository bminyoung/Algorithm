package me.nyoung.Programmers.level3.멀리뛰기;

public class Solution {

    long[] nums;
    public long solution(int num){
        if(num == 1) return 1;
        nums = new long[num];
        nums[0] = 1;
        nums[1] = 2;

        for(int i = 2; i < num; i++){
            nums[i] = nums[i-1] + nums[i-2];
            if(nums[i] > 1234567) nums[i] -= 1234567;
        }

        return nums[num-1];
    }
}