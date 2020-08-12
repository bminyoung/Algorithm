package me.nyoung.BOJ.DP.BitMask;

import java.io.*;

public class sol_11723 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int M = Integer.parseInt(br.readLine());
        boolean[] arr = new boolean[21];
        for (int i = 0; i < M; i++) {
            String[] line = br.readLine().split(" ");
            String cmd = line[0];
            int num = 0;
            if(line.length > 1) num = Integer.parseInt(line[1]);
            switch (cmd){
                case "add":
                    arr[num] = true;
                    break;
                case "remove":
                    arr[num] = false;
                    break;
                case "check":
                    bw.write(arr[num] ? String.valueOf(1) : String.valueOf(0));
                    bw.newLine();
                    break;
                case "toggle":
                    arr[num] = !arr[num];
                    break;
                case "all":
                    for (int j = 1; j <= 20; j++) arr[j] = true;
                    break;
                case "empty":
                    arr = new boolean[21];
                    break;
            }
        }
        bw.flush();
        bw.close();
    }
}
