package me.nyoung.BOJ.BFSDFS;

import java.util.LinkedList;
import java.util.Queue;

public class sol_2178 {
    public int solution(int row, int col, int[][] map){
        boolean[][] visited = new boolean[row][col];
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{0,0});

        while(queue.size() != 0){
            int[] loc = queue.poll();
            visited[loc[0]][loc[1]] = true;

            if(loc[0] > 0 && !visited[loc[0]-1][loc[1]] && map[loc[0]-1][loc[1]] == 1){
                queue.add(new int[]{loc[0]-1, loc[1]});
                map[loc[0]-1][loc[1]] = map[loc[0]][loc[1]] + 1;
            }
            if(loc[0] < row-1 && !visited[loc[0]+1][loc[1]] && map[loc[0]+1][loc[1]] == 1){
                queue.add(new int[]{loc[0]+1, loc[1]});
                map[loc[0]+1][loc[1]] = map[loc[0]][loc[1]] + 1;
            }
            if(loc[1] > 0 && !visited[loc[0]][loc[1]-1] && map[loc[0]][loc[1]-1] == 1){
                queue.add(new int[]{loc[0], loc[1]-1});
                map[loc[0]][loc[1]-1] = map[loc[0]][loc[1]] + 1;
            }
            if(loc[1] < col-1 && !visited[loc[0]][loc[1]+1] && map[loc[0]][loc[1]+1] == 1){
                queue.add(new int[]{loc[0], loc[1]+1});
                map[loc[0]][loc[1]+1] = map[loc[0]][loc[1]] + 1;
            }
        }

        return map[row-1][col-1];
    }
}
