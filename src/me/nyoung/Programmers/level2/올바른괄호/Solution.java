package me.nyoung.Programmers.level2.올바른괄호;

import java.util.Stack;

class Solution {
    boolean solution(String s) {
        boolean answer = true;

        Stack<Character> stack = new Stack<>();

        for(int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            if(c == '('){
                stack.push(c);
            }else if(stack.size() != 0 && c == ')'){
                stack.pop();
            }else{
                answer = false;
                break;
            }
        }

        if(stack.size() != 0) answer = false;


        return answer;
    }
}