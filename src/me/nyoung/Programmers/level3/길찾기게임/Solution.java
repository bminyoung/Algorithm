package me.nyoung.Programmers.level3.길찾기게임;

import java.util.*;

class Solution {
    public int[][] solution(int[][] nodeinfo) {
        ArrayList<Integer> preOrder = new ArrayList<>();
        ArrayList<Integer> postOrder = new ArrayList<>();
        Node[] nodes = new Node[nodeinfo.length];

        for(int i = 0; i < nodeinfo.length; i++) {
            Node node = new Node(i+1, nodeinfo[i][0], nodeinfo[i][1]);
            nodes[i] = node;
        }
        Arrays.sort(nodes, new Comp());

        Tree tree = new Tree(nodes[0]);
        for(int i = 1; i < nodes.length; i++) {
            tree.add(nodes[i]);
        }

        tree.preOrder(tree.root, preOrder);
        tree.postOrder(tree.root, postOrder);

        int[] pre = new int[nodeinfo.length];
        int[] post = new int[nodeinfo.length];

        for(int i = 0; i < nodeinfo.length; i++) {
            pre[i] = preOrder.get(i);
            post[i] = postOrder.get(i);
        }


        return new int[][] {pre, post};
    }

    class Comp implements Comparator<Node>{
        @Override
        public int compare(Node n1, Node n2) {
            if(n1.y < n2.y) return 1;
            else if(n1.y > n2.y) return -1;
            else {
                if(n1.x > n2.x) return 1;
                else return -1;
            }
        }
    }

    class Node{
        int num;
        int x;
        int y;
        Node left;
        Node right;

        Node(int num, int x, int y){
            this.num = num;
            this.x = x;
            this.y = y;
        }
    }

    class Tree{
        Node root;

        Tree(Node root){
            this.root = root;
        }

        void add(Node addNode) {
            add(addNode, root);
        }

        void add(Node addNode, Node parent) {
            if(addNode.x < parent.x) {
                if(parent.left == null) {
                    parent.left = addNode;
                }else {
                    add(addNode, parent.left);
                }
            }else {
                if(parent.right == null) {
                    parent.right = addNode;
                }else {
                    add(addNode, parent.right);
                }
            }
        }

        void preOrder(Node node, ArrayList<Integer> arr) {
            if(node == null) return;
            arr.add(node.num);
            preOrder(node.left, arr);
            preOrder(node.right, arr);
        }

        void postOrder(Node node, ArrayList<Integer> arr) {
            if(node == null) return;
            postOrder(node.left, arr);
            postOrder(node.right, arr);
            arr.add(node.num);
        }
    }
}