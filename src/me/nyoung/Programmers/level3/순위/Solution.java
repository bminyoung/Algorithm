package me.nyoung.Programmers.level3.순위;

import java.util.*;

public class Solution {

    public static void main(String[] args) {
        Solution s = new Solution();
        int n = s.solution(5, new int[][]{{4,3}, {4,2}, {3,2}, {1,2}, {2,5}});
        System.out.println(n);
    }

    public int solution(int n, int[][] results) {
        int answer = 0;
        List<Integer>[] adj = new ArrayList[n+1];
        int[] pass = new int[n+1];
        for(int i = 1; i <= n; i++){
            adj[i] = new ArrayList();
        }
        for(int i = 0; i < results.length; i++){
            int from = results[i][0];
            int to = results[i][1];
            adj[from].add(to);
        }


        for (int i = 1; i <= n; i++) {
            findWay(adj, i, pass);
        }

        Arrays.sort(pass);
        int rank = -1;
        for (int i = 1; i <= n; i++) {
            if(pass[i] == rank) {
                answer--;
                rank = -1;
            }else if(pass[i] == i-1) {
                answer++;
                rank = i-1;
            }

        }

        return answer;
    }

    private void findWay(List<Integer>[] adj, int start, int[] pass) {
        boolean[] visited = new boolean[adj.length];
        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);
        visited[start] = true;

        while(queue.size() != 0){
            int from = queue.poll();
            for(int to : adj[from]){
                if(visited[to]) continue;
                visited[to] = true;
                queue.add(to);
                pass[to]++;
            }
        }
    }
}
