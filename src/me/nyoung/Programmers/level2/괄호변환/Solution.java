package me.nyoung.Programmers.level2.괄호변환;

class Solution {
    public String solution(String p) {
        StringBuilder sb = new StringBuilder();
        String u, v;
        int leftN = 0, rightN = 0;
        if(p.equals("") || isTrueBracket(p)) return p;

        int cnt = 0;
        while(leftN == 0 || leftN != rightN) {
            if(p.charAt(cnt++) == '(') leftN++;
            else rightN++;
        }
        u = p.substring(0, cnt);
        v = p.substring(cnt);

        if(isTrueBracket(u)) {
            sb.append(u);
            sb.append(solution(v));
        }else {
            sb.append("(");
            sb.append(solution(v));
            sb.append(")");

            u = u.substring(1, u.length()-1);
            for(int i = 0; i < u.length(); i++) {
                if(u.charAt(i) == '(') sb.append(")");
                else sb.append("(");
            }
        }
        return sb.toString();
    }

    public boolean isTrueBracket(String s) {
        int cnt = 0;
        if(s.equals("")) return true;

        for(int i = 0; i < s.length(); i++) {
            if(s.charAt(i) == '(') cnt++;
            else if(cnt < 1) return false;
            else cnt--;
        }

        return cnt == 0;
    }
}