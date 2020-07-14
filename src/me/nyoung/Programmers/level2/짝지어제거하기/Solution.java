package me.nyoung.Programmers.level2.짝지어제거하기;

import java.util.Stack;

class Solution {
    public int solution(String s) {
        Stack<Character> stack = new Stack<>();
        stack.push(s.charAt(0));

        for (int i = 1; i < s.length(); i++) {

            if (stack.size() > 0) {
                char tmp = stack.peek();
                if (tmp == s.charAt(i)) {
                    stack.pop();
                    continue;
                }
            }
            stack.push(s.charAt(i));
        }

        return stack.size() > 0 ? 0 : 1;
    }
}