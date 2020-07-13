package me.nyoung.BOJ.BFSDFS;

import java.util.LinkedList;
import java.util.Queue;

public class sol_2573 {
    public  int areaAfterStep(int[][] map){
        int[] x = new int[]{0,0,1,-1};
        int[] y = new int[]{1,-1,0,0};
        Queue<Integer> rowQ = new LinkedList<>();
        Queue<Integer> colQ = new LinkedList<>();
        boolean[][] visited = new boolean[map.length][map[0].length];
        int area = 0;

        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[0].length; j++) {
                if(map[i][j] == 0 || visited[i][j]) continue;
                rowQ.add(i);
                colQ.add(j);
                visited[i][j] = true;
                area++;

                while(rowQ.size() != 0){
                    int row = rowQ.poll();
                    int col = colQ.poll();

                    for (int k = 0; k < 4; k++) {
                        int nRow = row + x[k];
                        int nCol = col + y[k];

                        if(nRow < 0 || nRow >= map.length || nCol < 0 || nCol >= map[0].length
                                || visited[nRow][nCol]) continue;

                        if(map[nRow][nCol] > 0){
                            rowQ.add(nRow);
                            colQ.add(nCol);
                            visited[nRow][nCol] = true;
                        }else if(map[row][col] > 0){
                            map[row][col]--;
                        }
                    }
                }
            }
        }
        return area;
    }
}
