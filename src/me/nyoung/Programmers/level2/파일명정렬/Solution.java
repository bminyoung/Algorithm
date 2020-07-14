package me.nyoung.Programmers.level2.파일명정렬;

import java.util.*;

class Solution {
    public String[] solution(String[] files) {
        Arrays.sort(files, new Comparator<String>() {
            @Override
            public int compare(String str1, String str2) {
                // TODO Auto-generated method stub
                String tmpStr = "";

                String head1 = str1.split("[0-9]")[0];
                str1 = str1.substring(head1.length());
                head1 = head1.toLowerCase();

                int index = 0;
                while(Character.isDigit(str1.charAt(index)) && tmpStr.length() < 5) {
                    tmpStr += str1.charAt(index++);
                }
                int num1 = Integer.parseInt(tmpStr);

                String head2 = str2.split("[0-9]")[0];
                str2 = str2.substring(head2.length());
                head2 = head2.toLowerCase();

                if(!head1.equals(head2)) return head1.compareTo(head2);

                tmpStr = "";
                for(char c : str2.toCharArray()){
                    if(Character.isDigit(c) && tmpStr.length() < 5){
                        tmpStr += c;
                    }
                    else break;
                }
                int num2 = Integer.parseInt(tmpStr);

                if(num1 > num2) return 1;
                else if(num1 < num2) return -1;
                return 0;
            }
        });

        return files;
    }
}