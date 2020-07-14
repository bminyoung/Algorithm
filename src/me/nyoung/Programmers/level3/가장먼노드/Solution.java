package me.nyoung.Programmers.level3.가장먼노드;

import java.util.*;

class Solution {
    public int solution(int n, int[][] edge) {
        int answer = 0;
        int[] depth = new int[n+1];
        ArrayList<ArrayList<Integer>> con = new ArrayList<ArrayList<Integer>>();
        for(int i = 0; i < edge.length; i++){
            con.add(new ArrayList<Integer>());
        }

        for(int[] e:edge){
            con.get(e[0]).add(e[1]);
            con.get(e[1]).add(e[0]);
        }

        ArrayList<Integer> arr = new ArrayList<>();
        arr.add(1);
        depth[1] = 1;
        int std;
        while(!arr.isEmpty()) {
            std = arr.remove(0);

            for(int comp : con.get(std)) {
                if(depth[comp] == 0) {
                    depth[comp] = depth[std]+1;
                    arr.add(comp);
                }
            }
        }

        int max = 0;
        for(int d : depth) {
            if(max < d) {
                max = d;
                answer = 1;
            }else if(d == max) answer++;
        }
        return answer;
    }
}