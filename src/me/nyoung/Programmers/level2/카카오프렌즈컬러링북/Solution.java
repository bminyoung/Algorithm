package me.nyoung.Programmers.level2.카카오프렌즈컬러링북;

import java.util.*;

class Solution {
    public int[] solution(int m, int n, int[][] picture) {
        int numberOfArea = 0;
        int maxSizeOfOneArea = 0;
        boolean[][] visited = new boolean[m][n];
        Stack<Integer> xStack = new Stack<>();
        Stack<Integer> yStack = new Stack<>();

        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                int size = 0;
                if(picture[i][j] != 0 && !visited[i][j]){
                    xStack.push(i);
                    yStack.push(j);
                    visited[i][j] = true;
                    size++;
                    numberOfArea++;
                }else continue;

                while(xStack.size() != 0){
                    int x = xStack.pop();
                    int y = yStack.pop();
                    int std = picture[x][y];

                    if(y < n-1 && picture[x][y+1] == std && !visited[x][y+1]) {
                        xStack.push(x);
                        yStack.push(y+1);
                        visited[x][y+1] = true;
                        size++;
                    }
                    if(y > 0 && picture[x][y-1] == std && !visited[x][y-1]) {
                        xStack.push(x);
                        yStack.push(y-1);
                        visited[x][y-1] = true;
                        size++;
                    }
                    if(x < m-1 && picture[x+1][y] == std && !visited[x+1][y]) {
                        xStack.push(x+1);
                        yStack.push(y);
                        visited[x+1][y] = true;
                        size++;
                    }
                    if(x > 0 && picture[x-1][y] == std && !visited[x-1][y]) {
                        xStack.push(x-1);
                        yStack.push(y);
                        visited[x-1][y] = true;
                        size++;
                    }
                }
                maxSizeOfOneArea = Math.max(maxSizeOfOneArea, size);
            }
        }

        return new int[] {numberOfArea, maxSizeOfOneArea};
    }
}