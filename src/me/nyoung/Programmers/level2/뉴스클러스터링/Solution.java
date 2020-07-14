package me.nyoung.Programmers.level2.뉴스클러스터링;

import java.util.*;

class Solution {
    public int solution(String str1, String str2) {
        ArrayList<String> set1 = new ArrayList<>();
        ArrayList<String> set2 = new ArrayList<>();
        ArrayList<String> intersect = new ArrayList<>();

        for(int i = 0; i < str1.length()-1; i++) {
            String word = str1.substring(i, i+2).toLowerCase();
            if(word.replaceAll("[a-z]", "").length() == 0) set1.add(word);
        }
        for(int i = 0; i < str2.length()-1; i++) {
            String word = str2.substring(i, i+2).toLowerCase();
            if(word.replaceAll("[a-z]", "").length() == 0) set2.add(word);
        }

        for(int i = set1.size()-1; i >= 0; i--) {
            String str = set1.get(i);
            if(set2.contains(str)) {
                intersect.add(str);
                set1.remove(str);
                set2.remove(set2.indexOf(str));
            }
        }

        double jaccard = 1;
        if(intersect.size()+set1.size()+set2.size() != 0) {
            jaccard = intersect.size() * 1.0 / (intersect.size()+set1.size()+set2.size());
        }
        return (int)(jaccard * 65536);
    }
}