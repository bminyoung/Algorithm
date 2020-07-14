package me.nyoung.Programmers.level3.단어변환;

import java.util.*;

class Solution {
    public int solution(String begin, String target, String[] words) {
        HashMap<String, Integer> dist = new HashMap<>();
        ArrayList<String> arr = new ArrayList<>();
        arr.add(begin);
        dist.put(begin, 0);
        while(!arr.isEmpty()) {
            String std = arr.remove(0);

            for(int i = 0; i < words.length; i++) {
                if(dist.containsKey(words[i])) continue; //visited
                String comp = words[i];
                int diff = 0;

                for(int j = 0; j < comp.length(); j++) {
                    if(std.charAt(j) != comp.charAt(j)) diff++;
                    if(diff > 1) break;
                }
                if(diff == 1) {
                    if(comp.equals(target)) {
                        return dist.get(std)+1;
                    }
                    arr.add(comp);
                    dist.put(comp, dist.get(std) + 1);
                }
            }
        }

        return 0;
    }
}