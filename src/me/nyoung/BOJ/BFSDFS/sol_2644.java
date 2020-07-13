package me.nyoung.BOJ.BFSDFS;

import java.util.LinkedList;
import java.util.Queue;

public class sol_2644 {
    public int solution4(int n, int x, int y, int[][] relation){
        int[] chon = new int[n+1];
        boolean[][] rel = new boolean[n+1][n+1];
        boolean[] visited = new boolean[n+1];

        for(int i = 0; i < relation.length; i++){
            rel[relation[i][0]][relation[i][1]] = true;
            rel[relation[i][1]][relation[i][0]] = true;
        }

        Queue<Integer> queue = new LinkedList<>();
        queue.add(x);

        while(queue.size() != 0){
            int person = queue.poll();
            for(int i = 1; i <= n; i++){
                if(rel[person][i] && !visited[i]){
                    if(i == y) return chon[person]+1;
                    visited[i] = true;
                    queue.add(i);
                    chon[i] = chon[person]+1;
                }
            }
        }
        return -1;
    }
}
