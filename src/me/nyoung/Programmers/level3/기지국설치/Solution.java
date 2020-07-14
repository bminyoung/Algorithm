package me.nyoung.Programmers.level3.기지국설치;

class Solution {
    public int solution(int n, int[] stations, int w) {
        int answer = 0;
        int location = 1;
        int index = 0;

        while(index < stations.length){
            if(stations[index] - w <= location){
                location = stations[index++] + w+1;
            }else{
                answer++;
                location += 2*w+1;
            }
        }

        return answer;
    }
}