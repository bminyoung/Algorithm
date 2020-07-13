package me.nyoung.BOJ.BackTracking;

public class sol_9663 {
    public int queen(boolean[][] chess, boolean[] visited, int start){
        if(start >= chess.length) return 1;

        int answer = 0;
        for (int i = 0; i < chess.length; i++) {
            if(visited[i]) continue;

            boolean check = false;
            for (int j = 1; j <= start && j <= i; j++) {
                if(chess[start-j][i-j]){
                    check = true;
                    break;
                }
            }
            if(check) continue;

            for (int j = 1; j <= start && j+i < chess.length; j++) {
                if(chess[start-j][i+j]){
                    check = true;
                    break;
                }
            }
            if(check) continue;

            chess[start][i] = visited[i] = true;
            answer += queen(chess, visited, start+1);
            chess[start][i] = visited[i] = false;
        }

        return answer;
    }
}
