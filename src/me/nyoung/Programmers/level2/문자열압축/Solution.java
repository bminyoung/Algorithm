package me.nyoung.Programmers.level2.문자열압축;

class Solution {
    public int solution(String s) {
        int min = Integer.MAX_VALUE;
        if(s.length() == 1) return 1;
        for(int unit = 1; unit < s.length(); unit++){
            StringBuilder sb = new StringBuilder();
            int index = 0;
            String std, next;

            while(index < s.length()) {
                int times = 0;
                if(index+unit > s.length()) {
                    std = s.substring(index, s.length());
                    next = "";
                }else {
                    next = std = s.substring(index, index+unit);
                }
                while(std.equals(next)) {
                    times++;
                    index += unit;
                    next = index+unit > s.length() ? s.substring(index, s.length()) : s.substring(index, index+unit);
                }
                if(times<=1) sb.append(std);
                else sb.append(times+std);

                if(next.equals("")) break;
            }
            if(sb.length() < min) min = sb.length();
        }

        return min;
    }
}