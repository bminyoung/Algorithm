package me.nyoung.Programmers.level3.디스크컨트롤러;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Solution {
    public int solution(int[][] jobs) {
        int answer = 0;
        PriorityQueue<Integer[]> queue = new PriorityQueue<>(Comparator.comparingInt(n -> n[1]));
        Arrays.sort(jobs, Comparator.comparingInt(n -> n[0]));

        int time = 0;
        int index = 1;
        queue.add(new Integer[]{jobs[0][0], jobs[0][1]});

        while(index < jobs.length || queue.size() != 0){
            if(index < jobs.length && jobs[index][0] <= time){
                queue.add(new Integer[]{jobs[index][0], jobs[index][1]});
                index++;
                continue;
            }

            if(queue.size() != 0 && queue.peek()[0] <= time){
                Integer[] arr = queue.poll();
                answer += (time + arr[1] - arr[0]);
                time += arr[1];
            }else{
                time++;
            }
        }

        return answer / jobs.length;
    }
}
