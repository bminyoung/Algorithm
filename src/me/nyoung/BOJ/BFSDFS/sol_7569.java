package me.nyoung.BOJ.BFSDFS;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class sol_7569 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();
        int n = sc.nextInt();
        int h = sc.nextInt();
        int[][][] box = new int[m][n][h]; // [x,y,z]
        Queue<Integer> xQueue = new LinkedList<>();
        Queue<Integer> yQueue = new LinkedList<>();
        Queue<Integer> zQueue = new LinkedList<>();
        boolean check = true;
        for (int k = 0; k < h; k++) {
            for (int j = 0; j < n; j++) {
                for (int i = 0; i < m; i++) {
                    box[i][j][k] = sc.nextInt();
                    if(box[i][j][k] == 1){
                        xQueue.add(i);
                        yQueue.add(j);
                        zQueue.add(k);
                    }
                    if(box[i][j][k] == 0) check = false;
                }
            }
        }
        if(check){//시작할때 모두 익어있음
            System.out.println(0);
            return;
        }

        int[] x = new int[]{1, -1, 0, 0, 0, 0};
        int[] y = new int[]{0, 0, 1, -1, 0, 0};
        int[] z = new int[]{0, 0, 0, 0, 1, -1};
        int max = 0;
        while(xQueue.size() != 0){
            int curX = xQueue.poll();
            int curY = yQueue.poll();
            int curZ = zQueue.poll();

            for (int i = 0; i < 6; i++) {
                int nextX = curX + x[i];
                int nextY = curY + y[i];
                int nextZ = curZ + z[i];
                if(nextX < 0 || nextX >= m || nextY < 0 || nextY >= n || nextZ < 0 || nextZ >= h
                        || box[nextX][nextY][nextZ] != 0)
                    continue;

                box[nextX][nextY][nextZ] = box[curX][curY][curZ] + 1;
                xQueue.add(nextX);
                yQueue.add(nextY);
                zQueue.add(nextZ);
                if(max < box[nextX][nextY][nextZ]) max = box[nextX][nextY][nextZ];
            }
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < h; k++) {
                    if(box[i][j][k] == 0){
                        System.out.println(-1);
                        return;
                    }
                }
            }
        }
        System.out.println(max-1);
    }
}
