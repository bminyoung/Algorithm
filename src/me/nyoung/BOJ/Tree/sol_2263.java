package me.nyoung.BOJ.Tree;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Scanner;

public class sol_2263 {

    static BufferedWriter bw;
    static int[] inOrder;
    static int[] postOrder;
    static int[] indexOfInOrder;
    static int n;

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        inOrder = new int[n+1];
        postOrder = new int[n+1];
        indexOfInOrder = new int[n+1];
        for (int i = 1; i <= n; i++) {
            inOrder[i] = sc.nextInt();
            indexOfInOrder[inOrder[i]] = i;
        }

        for (int i = 1; i <= n; i++) {
            postOrder[i] = sc.nextInt();
        }

        find(1, n, 1, n);
        bw.flush();
        bw.close();
    }

    private static void find(int inStart, int inEnd, int postStart, int postEnd) throws IOException {
        if(inStart > inEnd || postStart > postEnd) return;

        int root = postOrder[postEnd];
        int std = indexOfInOrder[root];
        bw.write(root + " ");
        find(inStart, std-1, postStart, postEnd - inEnd + std - 1);
        find(std+1, inEnd, postEnd - inEnd + std, postEnd-1);
    }
}
