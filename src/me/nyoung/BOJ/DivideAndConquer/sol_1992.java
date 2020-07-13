package me.nyoung.BOJ.DivideAndConquer;

public class sol_1992 {
    public String compress(char[][] map, int startX, int startY, int length) {
        StringBuilder sb = new StringBuilder();
        char ch = map[startX][startY];
        boolean check = true;
        for (int i = 0; i < length; i++) {
            for (int j = 0; j < length; j++) {
                if(map[startX+i][startY+j] != ch){
                    check = false;
                    i = length;
                    break;
                }
            }
        }
        if(!check){
            sb.append('(');
            sb.append(compress(map, startX, startY, length/2));
            sb.append(compress(map, startX, startY + length/2, length/2));
            sb.append(compress(map, startX + length/2, startY, length/2));
            sb.append(compress(map, startX + length/2, startY + length/2, length/2));
            sb.append(')');
        }else{
            if(ch == '0'){
                sb.append(0);
            }else{
                sb.append(1);
            }
        }

        return sb.toString();
    }
}
