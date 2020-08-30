package me.nyoung.BOJ.Graph;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Scanner;

//Topological Sorting
public class sol_1766 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        List<Integer>[] adj = new ArrayList[n+1];
        int[] inDeg = new int[n+1];
        for (int i = 1; i <= n; i++) {
            adj[i] = new ArrayList<>();
        }

        for (int i = 0; i < m; i++) {
            int from = sc.nextInt();
            int to = sc.nextInt();
            adj[from].add(to);
            inDeg[to]++;
        }

        PriorityQueue<Integer> queue = new PriorityQueue<>();
        for (int i = 1; i <= n; i++) {
            if(inDeg[i] == 0) queue.add(i);
        }

        while(queue.size() != 0){
            int from = queue.poll();
            System.out.print(from + " ");
            for(int to : adj[from]){
                inDeg[to]--;
                if(inDeg[to] == 0) queue.add(to);
            }
        }
    }
}
