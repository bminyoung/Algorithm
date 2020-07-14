package me.nyoung.Programmers.level3.매칭점수;

import java.util.*;

class Solution {
    public int solution(String word, String[] pages) {
        int answer = 0;
        Page[] page_score = new Page[pages.length];
        HashMap<String, Integer> addressMatch = new HashMap<>();
        word = word.toLowerCase();

        for(int i = 0; i < pages.length; i++) {
            String page = pages[i];
            Page p = new Page();
            addressMatch.put(page.split("<meta property=\"og:url\" content=\"")[1].split("\"")[0], i);

            String contents = page.split("body>")[1].toLowerCase();
            String[] links = contents.split("<a href=\"");
            p.outer = links.length - 1;
            p.connect  = new String[p.outer];
            for(int j = 1; j < links.length; j++) {
                p.connect[j-1] = links[j].split("\"")[0];
            }

            int start = 0;
            while(true) {
                int index = contents.indexOf(word, start);
                if(index == -1) break;

                start = index + word.length();
                if(!Character.isLowerCase(contents.charAt(index-1))
                        && !Character.isLowerCase(contents.charAt(index+word.length()))) {
                    p.basic++;
                }
                if(start >= contents.length()) break;
            }
            p.link = p.basic * 1.0 / p.outer;
            p.total = p.basic;
            page_score[i] = p;
        }

        for(int i = 0; i < page_score.length; i++) {
            Page p = page_score[i];
            for(String comp : p.connect) {
                if(addressMatch.get(comp) == null) continue;
                page_score[addressMatch.get(comp)].total += p.link;
            }
        }

        double max = 0;
        for(int i = 0; i < page_score.length; i++) {
            Page p = page_score[i];
            if(p.total > max) {
                max = p.total;
                answer = i;
            }
        }

        return answer;
    }

    class Page{
        int basic;
        int outer;
        double link;
        double total;
        String[] connect;
    }
}