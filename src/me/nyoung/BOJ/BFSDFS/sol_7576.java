package me.nyoung.BOJ.BFSDFS;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class sol_7576 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[][] map = new int[m][n];
        Queue<Integer> rowQ = new LinkedList<>();
        Queue<Integer> colQ = new LinkedList<>();
        boolean check = true;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                map[i][j] = sc.nextInt();
                if(map[i][j] == 1){
                    rowQ.add(i);
                    colQ.add(j);
                }
                if(check && map[i][j] == 0) check = false;
            }
        }
        if(check){
            System.out.println(0);
            return;
        }

        int[] x = new int[]{0,0,1,-1};
        int[] y = new int[]{1,-1,0,0};
        int max = 0;
        while(rowQ.size() != 0){
            int row = rowQ.poll();
            int col = colQ.poll();

            for (int i = 0; i < 4; i++) {
                int nRow = row + x[i];
                int nCol = col + y[i];

                if(nRow < 0 || nRow >= map.length || nCol < 0 || nCol >= map[0].length
                        || map[nRow][nCol] != 0) continue;

                map[nRow][nCol] = map[row][col] + 1;
                rowQ.add(nRow);
                colQ.add(nCol);
                if(max < map[nRow][nCol]) max = map[nRow][nCol];
            }
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if(map[i][j] == 0) {
                    check = true;
                    break;
                }
            }
        }
        if(check) System.out.println(-1);
        else System.out.println(max-1);
    }
}
