package me.nyoung.Programmers.level2.프렌즈4블록;

class Solution {
    public int solution(int m, int n, String[] board) {
        int answer = 0;
        char[][] cBoard = new char[m][n];

        for(int i = 0; i < m; i++) { //board setting
            for(int j = 0; j < n; j++) {
                cBoard[i][j] = board[i].charAt(j);
            }
        }

        while(true) {
            boolean[][] check = new boolean[m][n];
            boolean success = false;
            for(int i = 0; i < m-1; i++) { //row
                for(int j = 0; j < n-1; j++) { //col
                    if(cBoard[i][j] != ' ' &&
                            cBoard[i][j] == cBoard[i][j+1] &&
                            cBoard[i][j] == cBoard[i+1][j] &&
                            cBoard[i+1][j] == cBoard[i+1][j+1]) {
                        check[i][j] = check[i][j+1] = check[i+1][j] = check[i+1][j+1] = true;
                        success = true;
                    }
                }
            }
            if(!success) break; //end

            for(int i = 0; i < m; i++) { //delete
                for(int j = 0; j < n; j++) {
                    if(check[i][j]) {
                        cBoard[i][j] = ' ';
                        answer++;
                    }
                }
            }

            for(int i = m-1; i >= 0; i--) { //pull
                for(int j = 0; j < n; j++) {
                    if(cBoard[i][j] == ' ') {
                        for(int k = i-1; k >= 0; k--) {
                            if(cBoard[k][j] != ' ') {
                                cBoard[i][j] = cBoard[k][j];
                                cBoard[k][j] = ' ';
                                break;
                            }
                        }
                    }
                }
            }
        }

        return answer;
    }
}