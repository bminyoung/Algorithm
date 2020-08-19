package me.nyoung.BOJ.Tree;

import java.util.ArrayList;
import java.util.Scanner;

public class sol_2533 {

    static ArrayList<Integer>[] adj;
    static boolean[] visited;
    static int[][] d;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        visited = new boolean[n+1];
        d = new int[n+1][2]; // 0 : not selected, 1 : selected
        adj = new ArrayList[n+1];
        for (int i = 1; i <= n; i++) {
            adj[i] = new ArrayList<>();
        }
        for (int i = 0; i < n-1; i++) {
            int from = sc.nextInt();
            int to = sc.nextInt();
            adj[from].add(to);
            adj[to].add(from);
        }

        dfs(1);
        System.out.println(Math.min(d[1][0], d[1][1]));
    }

    public static void dfs(int start){
        visited[start] = true;
        d[start][1] = 1;

        for(int node : adj[start]){
            if(visited[node]) continue;

            dfs(node);

            d[start][0] += d[node][1];
            d[start][1] += Math.min(d[node][0], d[node][1]);
        }
    }
}
