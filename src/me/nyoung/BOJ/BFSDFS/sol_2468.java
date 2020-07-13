package me.nyoung.BOJ.BFSDFS;

import java.util.LinkedList;
import java.util.Queue;

public class sol_2468 {
    public int safeArea(int[][] map, int flood){
        int[] x = new int[]{0,0,1,-1};
        int[] y = new int[]{1,-1,0,0};

        Queue<Integer> rowQ = new LinkedList<>();
        Queue<Integer> colQ = new LinkedList<>();
        boolean[][] visited = new boolean[map.length][map[0].length];
        int count = 0;

        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[0].length; j++) {
                if(visited[i][j]) continue;

                if(map[i][j] > flood){
                    rowQ.add(i);
                    colQ.add(j);
                    visited[i][j] = true;
                    count++;

                    while(rowQ.size() != 0){
                        int row = rowQ.poll();
                        int col = colQ.poll();

                        for (int k = 0; k < 4; k++) {
                            int nRow = row + y[k];
                            int nCol = col + x[k];
                            if(nRow < 0 || nRow >= map.length || nCol < 0 || nCol >= map[0].length
                                    || visited[nRow][nCol]) continue;

                            visited[nRow][nCol] = true;
                            if(map[nRow][nCol] > flood){
                                rowQ.add(nRow);
                                colQ.add(nCol);
                            }
                        }
                    }
                }
            }
        }
        return count;
    }
}
