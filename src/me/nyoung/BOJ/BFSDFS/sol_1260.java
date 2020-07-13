package me.nyoung.BOJ.BFSDFS;

import java.util.*;

public class sol_1260 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int start = sc.nextInt();

        visit = new boolean[n+1];
        adj = new ArrayList[n+1];
        for(int i = 0; i <= n; i++) {
            adj[i] = new ArrayList<>();
        }

        for(int i = 0; i < m; i++) {
            int from = sc.nextInt();
            int to = sc.nextInt();
            adj[from].add(to);
            adj[to].add(from);
        }

        for(int i = 1; i <= n; i++) {
            Collections.sort(adj[i]);
        }

        dfs(start);
        System.out.println();
        visit = new boolean[n+1];
        bfs(start);
    }

    static ArrayList<Integer>[] adj;
    static boolean[] visit;

    static void bfs(int start) {
        Queue<Integer> queue = new LinkedList<>();
        visit[start] = true;
        queue.add(start);

        while(queue.size() != 0) {
            int std = queue.poll();
            System.out.print(std + " ");
            for(int item : adj[std]) {
                if(!visit[item]) {
                    visit[item] = true;
                    queue.add(item);
                }
            }
        }
        System.out.println();
    }

    static void dfs(int start) {
        visit[start] = true;
        System.out.print(start + " ");

        for(int tmp : adj[start]) {
            if(visit[tmp]) continue;
            dfs(tmp);
        }
    }
}
