package me.nyoung.BOJ.Tree;

import java.util.Scanner;

public class sol_2250 {
    static int[] leftOfLevel;
    static int[] rightOfLevel;
    static int[] xCoord;
    static int x;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        Node[] nodes = new Node[n+1];
        leftOfLevel = new int[n+1];
        rightOfLevel = new int[n+1];
        xCoord = new int[n+1];
        x = 1;
        for (int i = 1; i <= n; i++) {
            nodes[i] = new Node(i);
            leftOfLevel[i] = n;
            rightOfLevel[i] = 0;
        }
        for (int i = 1; i <= n; i++) {
            int data = sc.nextInt();
            int left = sc.nextInt();
            int right = sc.nextInt();
            nodes[data].left = left;
            nodes[data].right = right;
            if(left != -1) nodes[left].parent = data;
            if(right != -1) nodes[right].parent = data;
        }

        int root = 1;
        for (int i = 1; i <= n; i++) {
            if(nodes[i].parent == 0){
                root = i;
                break;
            }
        }
        inOrder(nodes, root, 1);

        int max = 0;
        int maxLevel = 1;
        for (int i = 1; i <= n; i++) {
            if(max < rightOfLevel[i]-leftOfLevel[i]+1) {
                max = rightOfLevel[i]-leftOfLevel[i]+1;
                maxLevel = i;
            }
        }
        System.out.println(maxLevel + " " + max);
    }

    public static void inOrder(Node[] nodes, int start, int level){
        if(nodes[start].left != -1) inOrder(nodes, nodes[start].left, level+1);

        if(leftOfLevel[level] > x) leftOfLevel[level] = x;
        if(rightOfLevel[level] < x) rightOfLevel[level] = x;
        x++;

        if(nodes[start].right != -1) inOrder(nodes, nodes[start].right, level+1);
    }
}

class Node{
    int parent = 0;
    int data;
    int left = -1;
    int right = -1;

    public Node(int data) {
        this.data = data;
    }
}