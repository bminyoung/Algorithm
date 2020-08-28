package me.nyoung.Programmers.level3.섬연결하기;

import java.util.Arrays;
import java.util.Comparator;

public class Solution {
    //Kruskal
    public int solution(int n, int[][] costs) {
        int answer = 0;
        int[] group = new int[n];
        for(int i = 0; i < n; i++){
            group[i] = i;
        }

        Arrays.sort(costs, Comparator.comparingInt(arr -> arr[2]));

        for(int i = 0; i < costs.length; i++){
            if(isCycle(group, costs[i][0], costs[i][1])) continue;
            answer += costs[i][2];
            union(group, costs[i][0], costs[i][1]);
        }

        return answer;
    }

    boolean isCycle(int[] group, int a, int b){
        return getParent(group, a) == getParent(group, b);
    }

    void union(int[] group, int a, int b){
        int p1 = getParent(group, a);
        int p2 = getParent(group, b);
        if(p1 == p2) return;

        if(p1 < p2){
            group[p2] = p1;
        }else{
            group[p1] = p2;
        }
    }

    int getParent(int[] group, int n){
        if(n == group[n]) return n;
        return group[n] = getParent(group, group[n]);
    }
}
