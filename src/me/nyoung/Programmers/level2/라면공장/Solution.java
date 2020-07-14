package me.nyoung.Programmers.level2.라면공장;

import java.util.*;

class Solution {
    public int solution(int stock, int[] dates, int[] supplies, int k) {
        int answer = 0;
        PriorityQueue<Integer> supp = new PriorityQueue<>(Collections.reverseOrder());
        int day = 0;

        for(int i = 0; i < k; i++) {
            if(day < dates.length && dates[day] == i) {
                supp.add(supplies[day++]);
            }

            if(stock == 0) {
                stock += supp.poll();
                answer++;
            }
            stock--;
        }

        return answer;
    }
}