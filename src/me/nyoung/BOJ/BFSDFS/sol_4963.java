package me.nyoung.BOJ.BFSDFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class sol_4963 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[][] map;
        boolean[][] visited;

        while(true){
            String[] nums = br.readLine().split(" ");
            int w = Integer.parseInt(nums[0]);
            int h = Integer.parseInt(nums[1]);
            if(w == 0 && h == 0) break;

            //setting map
            map = new char[h][w];
            visited = new boolean[h][w];
            for (int i = 0; i < h; i++) {
                nums = br.readLine().split(" ");
                for (int j = 0; j < w; j++) {
                    map[i][j] = nums[j].charAt(0);
                    if(map[i][j] == '0') visited[i][j] = true;
                }
            }
            System.out.println(numOfIsland(map, visited));
        }
    }

    static final int[] x = new int[]{-1, 0, 1};
    static final int[] y = new int[]{-1, 0, 1};
    private static int numOfIsland(char[][] map, boolean[][] visited) { //bfs
        Queue<Integer> xQueue = new LinkedList<>();
        Queue<Integer> yQueue = new LinkedList<>();
        int[] start = findNotVisited(visited);
        int islandCount = 0;

        while(start != null){
            xQueue.add(start[0]);
            yQueue.add(start[1]);
            islandCount++;

            while(xQueue.size() != 0){
                int row = xQueue.poll();
                int col = yQueue.poll();
                if(visited[row][col]) continue;
                visited[row][col] = true;

                for (int i = 0; i < 3; i++) {
                    for (int j = 0; j < 3; j++) {
                        int nextX = row + x[i];
                        int nextY = col + y[j];

                        if(nextX < 0 || nextX >= map.length || nextY < 0 || nextY >= map[0].length) continue;
                        if(visited[nextX][nextY]) continue;

                        xQueue.add(nextX);
                        yQueue.add(nextY);
                    }
                }
            }

            start = findNotVisited(visited);
        }

        return islandCount;
    }

    private static int[] findNotVisited(boolean[][] visited) {
        for (int i = 0; i < visited.length; i++) {
            for (int j = 0; j < visited[0].length; j++) {
                if(!visited[i][j]) return new int[]{i, j};
            }
        }
        return null;
    }
}
