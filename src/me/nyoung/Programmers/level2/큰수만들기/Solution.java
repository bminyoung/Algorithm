package me.nyoung.Programmers.level2.큰수만들기;

public class Solution {
    public String solution(String number, int k) {
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < number.length();i++) {
            if(sb.length() == number.length() - k) return sb.toString();

            int index = -1;
            for( int j = 1; j <= k; j++) {
                if(number.charAt(i) < number.charAt(i+ j)) {
                    index = 0;
                    break;
                }
            }

            if(index == -1){
                sb.append(number.charAt(i));
            }
            else {
                k--;
            }
        }

        return sb.toString();
    }
}
