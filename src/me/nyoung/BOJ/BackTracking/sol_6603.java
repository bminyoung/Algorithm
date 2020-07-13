package me.nyoung.BOJ.BackTracking;

public class sol_6603 {
    public void combination(int[] num, boolean[] selection, int start, int r){
        if(r == 0){
            for (int i = 0; i < selection.length; i++) {
                if(selection[i]){
                    System.out.print(num[i] + " ");
                }
            }
            System.out.println();
            return;
        }

        if(start >= num.length) return;

        selection[start] = true;
        combination(num, selection, start+1, r-1);
        selection[start] = false;
        combination(num, selection, start+1, r);
    }
}
