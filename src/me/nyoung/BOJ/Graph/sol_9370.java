package me.nyoung.BOJ.Graph;

import java.util.*;

public class sol_9370 {
    static final int MAX = 50000001;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for (int cnt = 0; cnt < T; cnt++) {
            int n = sc.nextInt();
            int m = sc.nextInt();
            int t = sc.nextInt();
            int start = sc.nextInt();
            int[] pass = {sc.nextInt(), sc.nextInt()};
            List<Node>[] adj = new ArrayList[n+1];
            for (int i = 1; i <= n; i++) {
                adj[i] = new ArrayList<>();
            }

            for (int i = 0; i < m; i++) {
                int from = sc.nextInt();
                int to = sc.nextInt();
                int dist = sc.nextInt();
                adj[from].add(new Node(to, dist));
                adj[to].add(new Node(from, dist));
            }

            int[] candi = new int[t];
            for (int i = 0; i < t; i++) {
                candi[i] = sc.nextInt();
            }

            int[] possible = findWay(adj, start, pass, candi);
            for (int i = 0; i < possible.length; i++) {
                System.out.print(possible[i] + " ");
            }
        }
    }

    private static int[] findWay(List<Node>[] adj, int start, int[] pass, int[] candi) {
        int[] fromStart = dijkstra(adj, start);
        int[] fromPass1 = dijkstra(adj, pass[0]);
        int[] fromPass2 = dijkstra(adj, pass[1]);

        int[] arr = new int[candi.length];
        int index = 0;
        for (int i = 0; i < candi.length; i++) {
            //start -> pass[0] -> pass[1] -> candi
            int way1 = fromStart[pass[0]] + fromPass1[pass[1]] + fromPass2[candi[i]];
            //start -> pass[0] -> pass[1] -> candi
            int way2 = fromStart[pass[1]] + fromPass2[pass[0]] + fromPass1[candi[i]];
            if(fromStart[candi[i]] == way1 || fromStart[candi[i]] == way2){
                arr[index++] = candi[i];
            }
        }

        int[] answer = Arrays.copyOf(arr, index);
        Arrays.sort(answer);

        return answer;
    }

    private static int[] dijkstra(List<Node>[] adj, int start) {
        PriorityQueue<Node> queue = new PriorityQueue<>(Comparator.comparingInt(n -> n.dist));
        queue.add(new Node(start, 0));
        int[] dist = new int[adj.length];
        Arrays.fill(dist, MAX);
        dist[start] = 0;

        while(queue.size() != 0){
            Node from = queue.poll();
            for(Node node : adj[from.to]){
                if(dist[node.to] > dist[from.to] + node.dist){
                    dist[node.to] = dist[from.to] + node.dist;
                    queue.add(new Node(node.to, dist[node.to]));
                }
            }
        }
        return dist;
    }

    static class Node{
        int to;
        int dist;

        public Node(int to, int dist) {
            this.to = to;
            this.dist = dist;
        }
    }
}
