package me.nyoung.BOJ.BFSDFS;

import java.util.LinkedList;
import java.util.Queue;

public class sol_6593 {
    static final int[] h = new int[]{0,0,0,0,1,-1};
    static final int[] x = new int[]{0,0,1,-1,0,0};
    static final int[] y = new int[]{1,-1,0,0,0,0};

    public int escape(char[][][] map, int startF, int startR, int startC){
        Queue<Integer> floorQ = new LinkedList<>();
        Queue<Integer> rowQ = new LinkedList<>();
        Queue<Integer> colQ = new LinkedList<>();
        boolean[][][] visited = new boolean[map.length][map[0].length][map[0][0].length];
        int[][][] time = new int[map.length][map[0].length][map[0][0].length];

        floorQ.add(startF);
        rowQ.add(startR);
        colQ.add(startC);
        visited[startF][startR][startC] = true;

        while(floorQ.size() != 0){
            int floor = floorQ.poll();
            int row = rowQ.poll();
            int col = colQ.poll();

            for(int i = 0; i < 6; i++){
                int nextF = floor + h[i];
                int nextR = row + y[i];
                int nextC = col + x[i];

                if(nextF < 0 || nextF >= map.length || nextR < 0 || nextR >= map[0].length || nextC < 0 || nextC >= map[0][0].length || visited[nextF][nextR][nextC]){
                    continue;
                }

                if(map[nextF][nextR][nextC] == '.'){
                    floorQ.add(nextF);
                    rowQ.add(nextR);
                    colQ.add(nextC);
                    time[nextF][nextR][nextC] = time[floor][row][col] + 1;
                    visited[nextF][nextR][nextC] = true;
                }else if(map[nextF][nextR][nextC] == 'E'){
                    return time[floor][row][col] + 1;
                }
            }
        }

        return -1;
    }
}
