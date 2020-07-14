package me.nyoung.Programmers.level3.N_Queen;

class Solution {
    int count = 0;
    public int solution(int n) {
        boolean[] visited = new boolean[n];
        boolean[][] chess = new boolean[n][n];

        checking(chess, visited, 0);

        return count;
    }

    public void checking(boolean[][] chess, boolean[] visited, int start){

        if(start == chess.length){
            count++;
            return;
        }

        for(int i = 0; i < chess.length; i++){
            if(visited[i]) continue;

            //대각선 검사
            boolean check = true;
            for(int j = 1; j <= start && i >= j; j++){
                if(chess[start-j][i-j]){
                    check = false;
                    break;
                }
            }
            if(!check) continue;

            for(int j = 1; j <= start && i+j < chess.length; j++){
                if(chess[start-j][i+j]){
                    check = false;
                    break;
                }
            }
            if(!check) continue;

            chess[start][i] = true;
            visited[i] = true;
            checking(chess, visited, start+1);
            chess[start][i] = false;
            visited[i] = false;
        }
    }
}