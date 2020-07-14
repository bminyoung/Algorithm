package me.nyoung.Programmers.level3.단속카메라;

import java.util.Arrays;
import java.util.Comparator;

class Solution {
    public int solution(int[][] routes) {
        int answer = 0;

        Arrays.sort(routes, new Comparator<int[]>(){
            public int compare(int[] arr1, int[] arr2){
                return Integer.compare(arr1[0], arr2[0]);
            }
        });

        int start, end, std = 0;
        while(std < routes.length) {
            start = routes[std][0];
            end = routes[std][1];

            int i = std+1;
            for(; i < routes.length; i++) {
                start = routes[i][0]; //sort 때문
                if(routes[i][1] < end) end = routes[i][1];

                if(end < start) {
                    answer++;
                    std = i;
                    break;
                }
            }

            if(i == routes.length) {
                answer++;
                break;
            }
        }

        return answer;
    }
}