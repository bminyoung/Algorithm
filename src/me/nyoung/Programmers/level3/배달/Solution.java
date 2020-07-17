package me.nyoung.Programmers.level3.배달;

import java.util.*;

public class Solution {
    public int solution(int N, int[][] road, int K) {
        int[][] adj = new int[N+1][N+1];
        int[] dist = new int[N+1];
        for(int i = 0; i < road.length; i++) {
            adj[road[i][0]][road[i][1]] = adj[road[i][0]][road[i][1]] == 0 ? road[i][2] : Math.min(adj[road[i][0]][road[i][1]], road[i][2]);
            adj[road[i][1]][road[i][0]] = adj[road[i][1]][road[i][0]] == 0 ? road[i][2] : Math.min(adj[road[i][0]][road[i][1]], road[i][2]);
        }
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[1] = 0;

        boolean[] visited = new boolean[N+1];
        PriorityQueue<Vertex> queue = new PriorityQueue<>();
        queue.add(new Vertex(1, 0));
        while(queue.size() != 0){
            Vertex v = queue.poll();
            int std = v.number;
            if(visited[std]) continue;
            visited[std] = true;
            for (int j = 2; j <= N; j++) {
                if(adj[std][j] != 0){
                    if(dist[std] + adj[std][j] < dist[j]) dist[j] = dist[std] + adj[std][j];
                    if(!visited[j]) queue.add(new Vertex(j, dist[j]));
                }
            }
        }

        int count = 0;
        for (int i = 1; i <= N; i++) {
            if(dist[i] <= K) count++;
        }

        return count;
    }
}

class Vertex implements Comparable<Vertex>{
    int number;
    int dist;

    public Vertex(int number, int dist) {
        this.number = number;
        this.dist = dist;
    }

    @Override
    public int compareTo(Vertex v) {
        return this.dist - v.dist;
    }
}