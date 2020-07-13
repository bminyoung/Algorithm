package me.nyoung.BOJ.DP;

public class sol_2293 {
    public int solution(int[] arr, int n, int k){
        int[] d = new int[k+1];
        d[0] = 1;
        for(int i = 0; i < n; i++){
            for(int j = 1; j <= k; j++){
                if(j-arr[i] >= 0) d[j] += d[j-arr[i]];
            }
        }

        return d[k];
    }
}
