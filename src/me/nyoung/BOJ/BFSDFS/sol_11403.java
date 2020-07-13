package me.nyoung.BOJ.BFSDFS;

import java.util.LinkedList;
import java.util.Queue;

public class sol_11403 {
    public void solution(int[][] arr){
        Queue<Integer> queue = new LinkedList<>();
        boolean[] complete = new boolean[arr.length];
        boolean[] visited = new boolean[arr.length];

        for (int i = 0; i < arr.length; i++) {
            for(int j = 0; j < arr.length; j++){
                if(arr[i][j] == 1 && !visited[i]){
                    queue.add(i);
                    visited[i] = true;

                    while(queue.size() != 0){
                        int std = queue.poll();
                        for(int k = 0; k < arr.length; k++){
                            if(arr[std][k] == 1){
                                arr[i][k] = 1;
                                if(!complete[std] && !visited[k]) {
                                    queue.add(k);
                                    visited[k] = true;
                                }
                            }
                        }
                    }
                }
            }
            complete[i] = true;
            visited = new boolean[arr.length];
        }
    }
}
