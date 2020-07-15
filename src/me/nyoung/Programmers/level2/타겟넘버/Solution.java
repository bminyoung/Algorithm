package me.nyoung.Programmers.level2.타겟넘버;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public int solution(int[] numbers, int target) {
        int answer;
        List<Integer> list = new ArrayList<>();
        list.add(0);
        for(int i = 0; i < numbers.length; i++) {
            for(int j = 0; j < Math.pow(2,i); j++) {
                list.add(numbers[i]);
                list.add(-numbers[i]);
            }
        }
        answer = searchingTree(list, 0, 0, (int)(Math.pow(2, numbers.length) - 1), target);

        return answer;
    }

    int searchingTree(List<Integer> list, int sum, int index, int limit, int target) {
        int answer = 0;
        sum += list.get(index);

        if(index < limit) {
            answer += searchingTree(list, sum, 2 * index + 1, limit, target);
            answer += searchingTree(list, sum, 2 * index + 2, limit, target);
        }
        else {
            if(sum == target) answer++;
        }

        return answer;
    }
}
