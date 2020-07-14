package me.nyoung.Programmers.level2.폰켓몬;

import java.util.List;
import java.util.ArrayList;
import java.lang.Math;

class Solution {
    public int solution(int[] nums) {
        List list = new ArrayList<Integer>();

        for (int num : nums){
            if(!list.contains(num)){
                list.add(num);
            }
        }

        return Math.min(nums.length / 2, list.size());
    }
}