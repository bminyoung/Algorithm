package me.nyoung.BOJ.Graph;

import java.util.*;

//Topological sorting
public class sol_2252 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[] inDeg = new int[n+1];
        List<Integer>[] adj = new ArrayList[n+1];
        for (int i = 1; i <= n; i++) {
            adj[i] = new ArrayList<>();
        }

        for (int i = 0; i < m; i++) {
            int first = sc.nextInt();
            int sec = sc.nextInt();
            adj[first].add(sec);
            inDeg[sec]++;
        }

        Queue<Integer> queue = new LinkedList<>();
        for (int i = 1; i <= n; i++) {
            if(inDeg[i] == 0) queue.add(i);
        }

        int[] sort = new int[n];
        int index = 0;
        while(queue.size() != 0){
            int start = queue.poll();
            sort[index++] = start;
            for(int to : adj[start]){
                inDeg[to]--;
                if(inDeg[to] == 0){
                    queue.add(to);
                }
            }
        }

        for (int i = 0; i < n; i++) {
            System.out.println(sort[i]);
        }
    }
}
