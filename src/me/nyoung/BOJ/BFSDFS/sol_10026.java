package me.nyoung.BOJ.BFSDFS;

import java.util.LinkedList;
import java.util.Queue;

public class sol_10026 {
    static final int[] x = new int[]{0,0,1,-1};
    static final int[] y = new int[]{1,-1,0,0};

    public int solution(char[][] map){
        boolean[][] visited = new boolean[map.length][map[0].length];
        Queue<Integer> rowQ = new LinkedList<>();
        Queue<Integer> colQ = new LinkedList<>();
        int count = 0;

        for(int i = 0; i < map.length; i++){
            for(int j = 0; j < map[0].length; j++){
                if(visited[i][j]) continue;
                rowQ.add(i);
                colQ.add(j);
                visited[i][j] = true;
                char std = map[i][j];
                count++;

                while(rowQ.size() != 0){
                    int row = rowQ.poll();
                    int col = colQ.poll();

                    for(int k = 0; k < 4; k++){
                        int nextRow = row + x[k];
                        int nextCol = col + y[k];

                        if(nextRow < 0 || nextRow >= map.length || nextCol < 0 || nextCol >= map[0].length
                                || visited[nextRow][nextCol]) continue;
                        if(map[nextRow][nextCol] == std){
                            rowQ.add(nextRow);
                            colQ.add(nextCol);
                            visited[nextRow][nextCol] = true;
                        }
                    }
                }
            }
        }

        return count;
    }
}
