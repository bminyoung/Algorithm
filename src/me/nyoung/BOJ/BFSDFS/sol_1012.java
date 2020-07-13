package me.nyoung.BOJ.BFSDFS;

import java.util.Stack;

public class sol_1012 {
    static final int[] x = new int[]{0,0,1,-1};
    static final int[] y = new int[]{1,-1,0,0};

    public int solution(boolean[][] map, int r, int c){
        Stack<Integer> rowStack = new Stack<>();
        Stack<Integer> colStack = new Stack<>();
        int count = 0;

        for(int i = 0; i < r; i++){
            for(int j = 0; j < c; j++){
                if(!map[i][j]) continue;

                rowStack.push(i);
                colStack.push(j);
                map[i][j] = false;
                count++;

                while(rowStack.size() != 0){
                    int row = rowStack.pop();
                    int col = colStack.pop();

                    for(int k = 0; k < 4; k++){
                        int nextRow = row+x[k];
                        int nextCol = col+y[k];
                        if(nextRow < 0 || nextRow >= r || nextCol < 0 || nextCol >= c) continue;

                        if(map[nextRow][nextCol]){
                            rowStack.push(nextRow);
                            colStack.push(nextCol);
                            map[nextRow][nextCol] = false;
                        }
                    }
                }
            }
        }
        return count;
    }
}
