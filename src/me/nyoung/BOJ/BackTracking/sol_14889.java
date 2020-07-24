package me.nyoung.BOJ.BackTracking;

import java.util.Scanner;

public class sol_14889 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] team = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                team[i][j] = sc.nextInt();
            }
        }
        boolean[] visited = new boolean[n];
        divideTeam(team, visited, 0, n/2);
        System.out.println(min);
    }
    static int min = Integer.MAX_VALUE;
    static void divideTeam(int[][] team, boolean[] visited, int start, int r) {
        if (r == 0) {
            int team1 = 0, team2 = 0;
            for (int i = 0; i < visited.length; i++) {
                if (visited[i]) {
                    for (int j = 0; j < visited.length; j++) {
                        if(visited[j]) team1 += team[i][j];
                    }
                }else{
                    for (int j = 0; j < visited.length; j++) {
                        if(!visited[j]) team2 += team[i][j];
                    }
                }
            }
            int diff = Math.abs(team1-team2);
            if(diff < min) min = diff;
            return;
        }
        if (start >= visited.length) return;

        visited[start] = true;
        divideTeam(team, visited, start + 1, r - 1);
        visited[start] = false;
        divideTeam(team, visited, start + 1, r);
    }
}
