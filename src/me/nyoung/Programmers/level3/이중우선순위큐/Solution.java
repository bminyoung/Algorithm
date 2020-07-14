package me.nyoung.Programmers.level3.이중우선순위큐;

import java.util.*;

class Solution {
    public int[] solution(String[] operations) {
        PriorityQueue<Integer> minQ = new PriorityQueue<>();
        PriorityQueue<Integer> maxQ = new PriorityQueue<>(Collections.reverseOrder());

        for(String op : operations) {
            int value = Integer.parseInt(op.split(" ")[1]);
            if(op.charAt(0) == 'I') {
                minQ.add(value);
                maxQ.add(value);
            }else if(value > 0 && maxQ.size() != 0) {
                minQ.remove(maxQ.poll());
            }else if(minQ.size() != 0){
                maxQ.remove(minQ.poll());
            }
        }

        return minQ.size() == 0 ? new int[] {0, 0} : new int[] {maxQ.poll(), minQ.poll()};
    }
}