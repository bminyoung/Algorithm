package me.nyoung.BOJ.Queue;

import java.io.*;
import java.util.Deque;
import java.util.LinkedList;

public class sol_18258 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        Deque<Integer> queue = new LinkedList<>();
        int n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; i++) {
            String cmd = br.readLine();
            switch (cmd){
                case "pop":
                    if(queue.size() != 0) bw.write(queue.poll() + "\n");
                    else bw.write(-1 + "\n");
                    break;
                case "size":
                    bw.write(queue.size() + "\n");
                    break;
                case "empty":
                    bw.write( (queue.isEmpty() ? 1 : 0)  + "\n");
                    break;
                case "front":
                    if(queue.size() != 0) bw.write(queue.peek() + "\n");
                    else bw.write(-1 + "\n");
                    break;
                case "back":
                    if(queue.size() != 0) bw.write(queue.getLast() + "\n");
                    else bw.write(-1 + "\n");
                    break;
            }
            if(cmd.startsWith("push")){
                int num = Integer.parseInt(cmd.split(" ")[1]);
                queue.add(num);
            }
        }
        bw.flush();
        bw.close();
    }
}
