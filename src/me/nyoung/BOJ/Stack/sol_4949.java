package me.nyoung.BOJ.Stack;

import java.util.Scanner;
import java.util.Stack;

public class sol_4949 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str;
        while(!(str = sc.nextLine()).equals(".")){
            if(isValid(str)) System.out.println("yes");
            else System.out.println("no");
        }
    }

    static boolean isValid(String str){
        Stack<Character> stack = new Stack<>();
        str = str.replaceAll("[a-z. A-Z]", "");

        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            if(ch == '(' || ch == '['){
                stack.push(ch);
            }else if(ch == ')'){
                if(stack.size() == 0 || stack.pop() != '('){
                    return false;
                }
            }else if(ch == ']'){
                if(stack.size() == 0 || stack.pop() != '['){
                    return false;
                }
            }
        }
        return stack.size() != 0 ? false : true;
    }
}
