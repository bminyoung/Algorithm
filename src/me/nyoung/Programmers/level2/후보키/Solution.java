package me.nyoung.Programmers.level2.후보키;

import java.util.*;

class Solution {
    boolean[] usedCol;
    ArrayList<Integer> keys;
    public int solution(String[][] relation) {
        int answer = 0;
        usedCol = new boolean[relation[0].length];
        keys = new ArrayList<>();

        int[] arr = new int[relation[0].length];
        for(int i = 0; i < relation[0].length; i++) arr[i] = i;

        boolean[] visited = new boolean[relation[0].length];
        for(int i = 1; i <= relation[0].length; i++){
            answer += combination(relation, arr, visited, 0, 0, i);
        }

        return answer;
    }

    public int combination(String[][] relation, int[] arr, boolean[] visited, int start, int depth, int r) {
        int answer = 0;
        if(depth == r) {
            int[] col = new int[r];
            int index = 0;
            for(int i = 0; i < arr.length; i++) {
                if(visited[i]){
                    col[index++] = arr[i];
                }
            }

            int key = 0;
            for(int c : col){
                int tmp = 1;
                for(int i = 1; i <= c; i++){
                    tmp <<= 1;
                }
                key = key | tmp;
            }

            for(int k : keys){
                if((k & key) == k) return 0;
            }

            if(isKey(relation, col)){
                keys.add(key);
                return 1;
            }

        }else {
            for(int i = start; i < arr.length; i++) {
                visited[i] = true;
                answer += combination(relation, arr, visited, i+1,depth+1, r);
                visited[i] = false;
            }
        }
        return answer;
    }

    public boolean isKey(String[][] relation, int[] col){
        ArrayList<String> data = new ArrayList<>();
        for(int i = 0; i < relation.length; i++){
            StringBuilder sb = new StringBuilder();
            for(int c : col){
                sb.append(relation[i][c]);
            }

            if(data.contains(sb.toString())){ //중복
                return false;
            }else{
                data.add(sb.toString());
            }
        }

        return data.size() == relation.length;
    }
}