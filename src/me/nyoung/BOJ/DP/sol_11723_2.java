package me.nyoung.BOJ.DP;

import java.io.*;

public class sol_11723_2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int M = Integer.parseInt(br.readLine());
        int bit = 0;
        for (int i = 0; i < M; i++) {
            String[] line = br.readLine().split(" ");
            String cmd = line[0];
            int num = 0;
            if(line.length > 1) num = Integer.parseInt(line[1]);
            switch (cmd){
                case "add":
                    bit |= (1 << num);
                    break;
                case "remove":
                    bit &= ~(1 << num);
                    break;
                case "check":
                    if((bit & (1 << num)) == 0) bw.write(String.valueOf(0));
                    else bw.write(String.valueOf(1));
                    bw.newLine();
                    break;
                case "toggle":
                    bit ^= (1 << num);
                    break;
                case "all":
                    bit = (1 << 21) - 1; // 111....11111 (0~20까지)
                    break;
                case "empty":
                    bit = 0;
                    break;
            }
        }
        bw.flush();
        bw.close();
    }
}
