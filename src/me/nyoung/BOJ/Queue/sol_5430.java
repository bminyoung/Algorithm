package me.nyoung.BOJ.Queue;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Scanner;

public class sol_5430 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        Deque<Integer> queue = new LinkedList<>();
        for (int i = 0; i < T; i++) {
            String cmd = sc.next();
            sc.nextInt();
            String str = sc.next();
            String[] arr = str.substring(1, str.length()-1).split(",");
            for(String s : arr){
                if(s.isEmpty()) continue;
                queue.add(Integer.parseInt(s));
            }

            System.out.println(process(queue, cmd));
        }
    }

    static String process(Deque<Integer> queue, String cmd){
        boolean left = true;
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        for (int j = 0; j < cmd.length(); j++) {
            char ch = cmd.charAt(j);
            if(ch == 'R'){
                left = !left;
            }else{ //D
                if(queue.size() == 0){
                    return "error";
                }
                if(left){
                    queue.poll();
                }else{
                    queue.pollLast();
                }
            }
        }

        if(left){
            while(queue.size() > 1){
                sb.append(queue.poll() + ",");
            }
        }else{
            while(queue.size() > 1){
                sb.append(queue.pollLast() + ",");
            }
        }
        if(queue.size() != 0) sb.append(queue.poll());
        sb.append("]");

        return sb.toString();
    }
}
