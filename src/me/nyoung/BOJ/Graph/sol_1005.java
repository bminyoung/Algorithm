package me.nyoung.BOJ.Graph;

import java.io.*;
import java.util.*;

//Topological Sorting
public class sol_1005 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int T = Integer.parseInt(br.readLine());
        for (int cnt = 0; cnt < T; cnt++) {
            String[] readLines = br.readLine().split(" ");
            int n = Integer.parseInt(readLines[0]);
            int k = Integer.parseInt(readLines[1]);
            int[] time = new int[n+1];
            List<Integer>[] adj = new ArrayList[n+1];
            int[] inDeg = new int[n+1];
            readLines = br.readLine().split(" ");
            for (int i = 1; i <= n; i++) {
                time[i] = Integer.parseInt(readLines[i-1]);
                adj[i] = new ArrayList<>();
            }

            for (int i = 0; i < k; i++) {
                readLines = br.readLine().split(" ");
                int from = Integer.parseInt(readLines[0]);
                int to = Integer.parseInt(readLines[1]);
                adj[from].add(to);
                inDeg[to]++;
            }
            int goal = Integer.parseInt(br.readLine());

            bw.write(getTime(adj, time, inDeg, goal)+"");
            bw.newLine();
        }
        bw.flush();
        bw.close();
    }

    private static int getTime(List<Integer>[] adj, int[] time, int[] inDeg, int goal) {
        Queue<Integer> queue = new LinkedList<>();
        int[] totalTime = new int[adj.length+1];

        for (int i = 1; i < inDeg.length; i++) {
            if(inDeg[i] == 0) {
                totalTime[i] = time[i];
                queue.add(i);
            }
        }

        while(queue.size() != 0){
            int from = queue.poll();
            if(from == goal) break;
            for(int to : adj[from]){
                totalTime[to] = Math.max(totalTime[to], totalTime[from] + time[to]);
                inDeg[to]--;
                if(inDeg[to] == 0) queue.add(to);
            }
        }

        return totalTime[goal];
    }
}
