package me.nyoung.BOJ.BFSDFS;

public class sol_1987 {
    static final int[] x = new int[]{0,0,1,-1};
    static final int[] y = new int[]{1,-1,0,0};

    public int solution(char[][] map){
        boolean[] alpha = new boolean[26];
        int[][] ways = new int[map.length][map[0].length];

        alpha[map[0][0]-'A'] = true;
        ways[0][0] = 1;

        return find(map, ways, alpha, 0, 0, 1);
    }

    public int find(char[][] map, int[][] ways, boolean[] alpha, int startRow, int startCol, int max){
        for(int i = 0; i < 4; i++){
            int row = startRow + x[i];
            int col = startCol + y[i];
            if(row < 0 || row >= map.length || col < 0 || col >= map[0].length) continue;

            char ch = map[row][col];
            if(alpha[ch-'A']) continue; //used

            alpha[ch-'A'] = true;
            ways[row][col] = ways[startRow][startCol] + 1;
            max = Math.max(max, ways[row][col]);
            max = Math.max(max, find(map, ways, alpha, row, col, max));
            alpha[ch-'A'] = false;
        }
        return max;
    }
}
