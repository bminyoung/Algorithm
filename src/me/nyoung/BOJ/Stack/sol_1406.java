package me.nyoung.BOJ.Stack;

import java.io.*;
import java.util.Stack;

public class sol_1406 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String str = br.readLine();
        int num = Integer.parseInt(br.readLine());
        Stack<Character> leftStack = new Stack<>();
        Stack<Character> rightStack = new Stack<>();
        for (int i = 0; i < str.length(); i++) {
            leftStack.push(str.charAt(i));
        }


        for (int i = 0; i < num; i++) {
            String[] cmd = br.readLine().split(" ");
            if(cmd[0].charAt(0) == 'L'){
                if(leftStack.size() != 0){
                    rightStack.push(leftStack.pop());
                }
            }else if(cmd[0].charAt(0) == 'D'){
                if(rightStack.size() != 0){
                    leftStack.push(rightStack.pop());
                }
            }else if(cmd[0].charAt(0) == 'B'){
                if(leftStack.size() != 0){
                    leftStack.pop();
                }
            }else{
                char ch = cmd[1].charAt(0);
                leftStack.push(ch);
            }
        }

        leftStack.stream().forEach(x -> {
            try {
                bw.write(x);
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
        while(rightStack.size() != 0) bw.write(rightStack.pop());
        bw.flush();
        bw.close();
    }
}
