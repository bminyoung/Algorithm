package me.nyoung.Programmers.level3.방문길이;

class Solution {
    public int solution(String dirs) {
        int answer = 0;
        Direction[][] map = new Direction[11][11];
        for(int i = 0; i < 11; i++){
            for(int j = 0; j < 11; j++)
                map[i][j] = new Direction();
        }
        int row = 5, col = 5;

        for(char ch : dirs.toCharArray()){
            if(ch == 'U'){
                if(row == 0) continue;
                if(!map[row][col].up) {
                    map[row][col].up = true;
                    map[row-1][col].down = true;
                    answer++;
                }
                row--;
            }else if(ch == 'D'){
                if(row == 10) continue;
                if(!map[row][col].down) {
                    map[row][col].down = true;
                    map[row+1][col].up = true;
                    answer++;
                }
                row++;
            }else if(ch == 'L'){
                if(col == 0) continue;
                if(!map[row][col].left){
                    map[row][col].left = true;
                    map[row][col-1].right = true;
                    answer++;
                }
                col--;
            }else{ //R
                if(col == 10) continue;
                if(!map[row][col].right) {
                    map[row][col].right = true;
                    map[row][col+1].left = true;
                    answer++;
                }
                col++;
            }
        }

        return answer;
    }

    class Direction{
        boolean up;
        boolean down;
        boolean left;
        boolean right;
    }
}