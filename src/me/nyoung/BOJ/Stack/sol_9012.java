package me.nyoung.BOJ.Stack;

import java.util.Scanner;

public class sol_9012 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        for(int cnt = 0; cnt < T; cnt++){
            int count = 0;
            String br = sc.next();
            for(int i = 0; i < br.length(); i++) {
                char bracket = br.charAt(i);
                if(bracket == '(') {
                    count++;
                }else {
                    if(count-- == 0) break; //false;
                }
            }
            if(count == 0){
                System.out.println("YES");
            }else{
                System.out.println("NO");
            }
        }
    }
}
