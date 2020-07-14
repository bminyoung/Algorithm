package me.nyoung.Programmers.level2.단체사진찍기;

import java.util.*;

class Solution {
    public int solution(int n, String[] data) {
        ArrayList<String> perm = new ArrayList<>();
        char[] character = new char[] {'A', 'C', 'F', 'J', 'M', 'N', 'R', 'T'};
        permutation(perm, character, 0, character.length, data);

        return perm.size();
    }
    public void permutation(ArrayList<String> strArr, char[] arr, int depth, int r, String[] condition) { // nPr

        if(depth == r) {
            String str = "";
            for(int i = 0; i < r; i++) {
                str += arr[i];
            }

            for(int j = 0; j < condition.length; j++) { //condition
                String cond = condition[j];
                char ch1 = cond.charAt(0);
                char ch2 = cond.charAt(2);
                char sign = cond.charAt(3);
                int term = cond.charAt(4) - '0';
                int diff = Math.abs(str.indexOf(ch1) - str.indexOf(ch2));

                if(sign == '=') {
                    if(diff != term+1) return;
                }else if(sign == '<') {
                    if(diff >= term+1) return;
                }else { //>
                    if(diff <= term+1) return;
                }
            }
            strArr.add(str);
        }else {
            for(int i = depth; i < arr.length; i++) {
                swap(arr, depth, i);
                permutation(strArr, arr, depth+1, r, condition);
                swap(arr, depth, i);
            }
        }
    }

    public void swap(char[] arr, int i, int j) {
        char tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }
}