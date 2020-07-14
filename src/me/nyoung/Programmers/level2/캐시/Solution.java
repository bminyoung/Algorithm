package me.nyoung.Programmers.level2.캐시;

import java.util.*;

class Solution {
    public int solution(int cacheSize, String[] cities) {
        int answer = 0;
        ArrayList<String> cache = new ArrayList<>();

        for(int i = 0; i < cities.length; i++) {
            String city = cities[i].toLowerCase();
            if(cache.contains(city)) {
                cache.remove(city);
                cache.add(city);
                answer++;
            }
            else if(cache.size() < cacheSize) {
                cache.add(city);
                answer += 5;
            }else {
                if(!cache.isEmpty()) {
                    cache.remove(0);
                    cache.add(city);
                }
                answer += 5;
            }
        }

        return answer;
    }
}