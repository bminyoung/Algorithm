package me.nyoung.BOJ.BackTracking;

import java.io.*;

//care of timeout
public class sol_15651 {
    static BufferedWriter bw;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] line = br.readLine().split(" ");
        int n = Integer.parseInt(line[0]);
        int m = Integer.parseInt(line[1]);
        int[] arr = new int[m];
        perm(arr, 0, n, m);
        bw.flush();
    }

    public static void perm(int[] arr, int start, int n, int r) throws IOException {
        if (start == r) {
            for (int i = 0; i < r; i++) {
                bw.write(arr[i] + " ");
            }
            bw.newLine();
            return;
        }
        for (int i = 0; i < n; i++) {
            arr[start] = i + 1;
            perm(arr, start + 1, n, r);
        }
    }

}
