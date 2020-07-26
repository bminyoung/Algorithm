package me.nyoung.BOJ.BFSDFS;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class sol_2206 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();
        int n = sc.nextInt();
        char[][] map = new char[m][n];
        for (int i = 0; i < m; i++) {
            map[i] = sc.next().toCharArray();
        }

        int[] x = new int[]{1, -1, 0, 0};
        int[] y = new int[]{0, 0, 1, -1};
        boolean[][][] visited = new boolean[m][n][2];
        Queue<Location> queue = new LinkedList<>();
        queue.add(new Location(0, 0, 1, 0));
        visited[0][0][0] = true;
        int dist = Integer.MAX_VALUE;
        while(queue.size() != 0){
            Location loc = queue.poll();
            int row = loc.x;
            int col = loc.y;
            int broken = loc.broken;

            if(row == m-1 && col == n-1){
                dist = Math.min(dist, loc.dist);
                continue;
            }

            for (int i = 0; i < 4; i++) {
                int nRow = row + x[i];
                int nCol = col + y[i];
                if(nRow < 0 || nRow >= m || nCol < 0 || nCol >= n) continue;

                if(map[nRow][nCol] == '1'){
                    if(visited[nRow][nCol][1] || broken == 1) continue;
                    visited[nRow][nCol][1] = true;
                    queue.add(new Location(nRow, nCol, loc.dist + 1, 1));
                }else{
                    if(visited[nRow][nCol][broken]) continue;
                    visited[nRow][nCol][broken] = true;
                    queue.add(new Location(nRow, nCol, loc.dist + 1, broken));
                }
            }
        }
        System.out.println(dist == Integer.MAX_VALUE ? -1 : dist);
    }
}

class Location{
    int x;
    int y;
    int dist;
    int broken; // 0:no 1:yes

    public Location(int x, int y, int dist, int broken) {
        this.x = x;
        this.y = y;
        this.dist = dist;
        this.broken = broken;
    }
}