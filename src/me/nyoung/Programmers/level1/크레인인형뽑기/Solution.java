package me.nyoung.Programmers.level1.크레인인형뽑기;

import java.util.*;

class Solution {
    public int solution(int[][] board, int[] moves) {
        int answer = 0;
        Stack<Integer> stack = new Stack<>();
        for (int move: moves) {
            for (int i = 0; i < board.length; i++) {
                int block = board[i][move-1];
                if(block != 0){
                    board[i][move-1] = 0;
                    if(!stack.isEmpty() && stack.peek() == block){
                        stack.pop();
                        answer++;
                    }else{
                        stack.push(block);
                    }
                    break;
                }
            }
        }
        return answer*2;
    }
}