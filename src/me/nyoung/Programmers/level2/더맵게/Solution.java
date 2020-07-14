package me.nyoung.Programmers.level2.더맵게;

import java.util.*;

class Solution {
    public int solution(int[] scoville, int k) {
        int cnt = 0;
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        for(int i = 0; i < scoville.length; i++) {
            queue.add(scoville[i]);
        }

        while(queue.peek() < k) {
            if(queue.size() == 1) return -1;
            int n1 = queue.poll();
            int n2 = queue.poll();
            queue.add(n1 + n2*2);
            cnt++;
        }

        return cnt;
    }
}