package me.nyoung.BOJ.Tree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class sol_1991 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        Node[] nodes = new Node[26];

        for (int i = 0; i < 26; i++) {
            nodes[i] = new Node();
        }

        Tree tree = new Tree(nodes[0]);

        for (int i = 0; i < n; i++) {
            String[] arr = br.readLine().split(" ");
            Node node = nodes[arr[0].charAt(0) - 'A'];
            node.data = arr[0].charAt(0);
            if(arr[1].charAt(0) != '.'){
                Node left = nodes[arr[1].charAt(0) - 'A'];
                node.leftNode = left;
            }
            if(arr[2].charAt(0) != '.'){
                Node right = nodes[arr[2].charAt(0) - 'A'];
                node.rightNode = right;
            }
        }

        System.out.println(tree.preOrder(tree.root, new StringBuilder()).toString());
        System.out.println(tree.inOrder(tree.root, new StringBuilder()).toString());
        System.out.println(tree.postOrder(tree.root, new StringBuilder()).toString());
    }

    static class Tree{
        Node root;

        Tree(Node root){
            this.root = root;
        }

        public StringBuilder preOrder(Node start, StringBuilder sb){
            if(start == null) return null;

            sb.append(start.data);
            preOrder(start.leftNode, sb);
            preOrder(start.rightNode, sb);

            return sb;
        }

        public StringBuilder inOrder(Node start, StringBuilder sb){
            if(start == null) return null;

            inOrder(start.leftNode, sb);
            sb.append(start.data);
            inOrder(start.rightNode, sb);

            return sb;
        }

        public StringBuilder postOrder(Node start, StringBuilder sb){
            if(start == null) return null;

            postOrder(start.leftNode, sb);
            postOrder(start.rightNode, sb);
            sb.append(start.data);

            return sb;
        }
    }

    static class Node<T>{
        T data;
        Node leftNode;
        Node rightNode;
    }
}
