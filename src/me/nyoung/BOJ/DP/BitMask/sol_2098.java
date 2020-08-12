package me.nyoung.BOJ.DP.BitMask;

import java.util.Arrays;
import java.util.Scanner;

public class sol_2098 {
    static int[][] adj;
    static int[][] d;
    static int n;
    static int MAX = 16 * 1000000;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        adj = new int[n][n];
        d = new int[n][(1 << n) - 1];

        for (int i = 0; i < n; i++) {
            Arrays.fill(d[i], MAX);
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                adj[i][j] = sc.nextInt();
            }
        }
        System.out.println(travel(0, 1));
    }

    public static int travel(int vill, int visit){
        if(visit == (1 << n) - 1) {
            // 모두 다 돌았으니 1번 마을로
            return adj[vill][0] == 0 ? MAX : adj[vill][0];
        }

        //이미 계산
        if(d[vill][visit] != MAX) return d[vill][visit];

        for (int i = 0; i < n; i++) {
            int next = visit | (1 << i);

            if( (visit & (1 << i)) != 0) continue; // 이미 방문
            if(adj[vill][i] == 0) continue; // 길이 없음

            d[vill][visit] = Math.min(d[vill][visit], travel(i, next) + adj[vill][i]);
        }
        return d[vill][visit];
    }
}
