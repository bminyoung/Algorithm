package me.nyoung.BOJ.Tree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class sol_2213 {
    static int[][] d;
    static int[] weight;
    static ArrayList<Integer>[] adj;
    static boolean[] visited;
    static ArrayList<Integer> trace;
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        weight = new int[n+1];
        adj = new ArrayList[n+1];
        visited = new boolean[n+1];
        trace = new ArrayList<>();
        d = new int[n+1][2]; // 0 : not selected, 1: selected 
        for (int i = 1; i <= n; i++) {
            weight[i] = sc.nextInt();
            adj[i] = new ArrayList<>();
        }

        for (int i = 0; i < n-1; i++) {
            int from = sc.nextInt();
            int to = sc.nextInt();
            adj[from].add(to);
            adj[to].add(from);
        }
        dfs(1);
        System.out.println(Math.max(d[1][0], d[1][1]));

        visited = new boolean[n+1];
        boolean selected = d[1][0] < d[1][1];
        getTrace(1, selected);
        Collections.sort(trace);
        for(int num : trace){
            System.out.print(num + " ");
        }
    }
    
    public static void dfs(int start){
        visited[start] = true;
        d[start][1] = weight[start];
        for(int node : adj[start]){
            if(visited[node]) continue;
            dfs(node);

            d[start][0] += Math.max(d[node][0], d[node][1]);
            d[start][1] += d[node][0];
        }
    }

    public static void getTrace(int start, boolean selected){
        visited[start] = true;
        if(selected) trace.add(start);

        for(int node : adj[start]){
            if(visited[node]) continue;

            if(selected){ //selected -> next node : not selected
                getTrace(node, false);
            }else{
                getTrace(node, d[node][0] < d[node][1]); //true : select, false : not select
            }
        }
    }
}
