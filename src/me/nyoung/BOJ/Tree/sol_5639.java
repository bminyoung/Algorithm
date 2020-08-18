package me.nyoung.BOJ.Tree;

import java.util.Scanner;

public class sol_5639 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Tree tree = new Tree();
        while(sc.hasNextInt()){
            Node node = new Node(sc.nextInt());
            tree.add(node);
        }
        tree.postOrder(tree.root);
    }

    static class Node{
        int data;
        Node left;
        Node right;

        Node(int d){
            data = d;
        }
    }

    static class Tree{
        Node root;
        void add(Node node){
            if(root == null) root = node;
            else{
                Node parent = root;
                Node pre = parent;
                while(parent != null){
                    pre = parent;
                    if(parent.data > node.data){
                        parent = parent.left;
                    }else{
                        parent = parent.right;
                    }
                }

                if(pre.data > node.data){
                    pre.left = node;
                }else{
                    pre.right = node;
                }
            }
        }

        void postOrder(Node node){
            if(node == null) return;
            postOrder(node.left);
            postOrder(node.right);
            System.out.println(node.data);
        }
    }
}



