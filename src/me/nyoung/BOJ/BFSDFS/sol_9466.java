package me.nyoung.BOJ.BFSDFS;

import java.util.Stack;

public class sol_9466 {
    public int solution(int[] arr){
        boolean[] visited = new boolean[arr.length];
        Stack<Integer> stack = new Stack<>();
        int count = 0;

        for(int i = 1; i < arr.length; i++){
            if(visited[i]) continue;

            stack.push(i);
            visited[i] = true;

            while(stack.size() != 0){
                int std = stack.peek();
                int next = arr[std];
                if(!visited[next]){
                    stack.push(next);
                    visited[next] = true;
                    continue;
                }else{
                    int size = stack.size();
                    boolean cycle = false;
                    while(stack.size() != 0){
                        if(stack.pop() == next){
                            cycle = true;
                            break;
                        }
                    }
                    count += cycle ? stack.size() : size;
                    stack.clear();
                }
            }
        }
        return count;
    }
}
