package me.nyoung.BOJ.MST;

import java.util.*;

//By Prim
public class sol_1197_2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int V = sc.nextInt();
        int E = sc.nextInt();
        PriorityQueue<Edge> vertices = new PriorityQueue<>();
        Queue<Integer> queue = new LinkedList<>();
        boolean[] visited = new boolean[V+1];

        List<Edge>[] adj = new ArrayList[V+1];
        for (int i = 1; i <= V; i++) {
            adj[i] = new ArrayList<>();
        }
        for (int i = 0; i < E; i++) {
            int from = sc.nextInt();
            int to = sc.nextInt();
            int weight = sc.nextInt();
            adj[from].add(new Edge(from, to, weight));
            adj[to].add(new Edge(to, from, weight));
        }

        queue.add(1); //set start vertex
        int weightSum = 0;
        while(queue.size() != 0){
            // 선택된 정점과 연결된 간선 모두 vertices에 넣기
            int std = queue.poll();
            visited[std] = true;
            for (int i = 0; i < adj[std].size(); i++) {
                if(!visited[adj[std].get(i).v2]){
                    vertices.add(adj[std].get(i));
                }
            }

            // weight가 가장 적은 간선을 꺼내서 확인하고 추가한다
            while(vertices.size() != 0){
                Edge v = vertices.poll();
                if(!visited[v.v2]){
                    queue.add(v.v2);
                    weightSum += v.weight;
                    break;
                }
            }
        }
        System.out.println(weightSum);
    }
}