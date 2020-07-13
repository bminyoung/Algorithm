package me.nyoung.BOJ.BFSDFS;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class sol_2606 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int num = sc.nextInt();
        boolean[][] arr = new boolean[n+1][n+1];
        for (int i = 0; i < num; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            arr[a][b] = true;
            arr[b][a] = true;
        }

        boolean[] visited = new boolean[n+1];
        Queue<Integer> queue = new LinkedList<>();
        queue.add(1);
        int count = 0;
        while(queue.size() != 0){
            int virus = queue.poll();
            if(visited[virus]) continue;
            visited[virus] = true;
            count++;
            for (int i = 1; i <= n; i++) {
                if(arr[virus][i] && !visited[i]) queue.add(i);
            }
        }
        System.out.println(--count);
    }
}
