package me.nyoung.BOJ.BackTracking;

import java.io.*;

//care of timeout
public class sol_15652 {
        static BufferedWriter bw;
        public static void main(String[] args) throws IOException {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            bw = new BufferedWriter(new OutputStreamWriter(System.out));
            String[] line = br.readLine().split(" ");
            int n = Integer.parseInt(line[0]);
            int m = Integer.parseInt(line[1]);
            int[] arr = new int[m];
            combination(arr, 0, 1, n, m);
            bw.flush();
        }

        public static void combination(int[] arr, int index, int start, int n, int r) throws IOException {
            if(r == 0){
                for (int i = 0; i < arr.length; i++) {
                    bw.write(arr[i] + " ");
                }
                bw.newLine();
                return;
            }
            if(index >= n) return;

            for (int i = start; i <= n; i++) {
                arr[index] = i;
                combination(arr, index+1, i, n, r-1);
            }
        }

}
