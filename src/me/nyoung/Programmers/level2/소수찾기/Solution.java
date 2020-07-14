package me.nyoung.Programmers.level2.소수찾기;

import java.util.*;

class Solution {
    public int solution(String numbers) {
        boolean[] primes = SetPrimes((int)Math.pow(10, numbers.length())+1);
        char[] c = numbers.toCharArray();
        ArrayList<Integer> nums = new ArrayList<>();
        for(int i = 1; i <= c.length; i++) {
            permutation(nums, c, 0, i, primes);
        }

        return nums.size();
    }

    public void permutation(ArrayList<Integer> set, char[] arr, int depth, int r, boolean[] prime) {
        if(depth == r) {
            String str = "";
            for(int i = 0; i < r; i++) {
                str += arr[i];
            }
            int number = Integer.parseInt(str);
            if(!set.contains(number) && !prime[number]) set.add(number);
        }else {
            for(int i = depth; i < arr.length; i++) {
                swap(arr, depth, i);
                permutation(set, arr, depth+1, r, prime);
                swap(arr, depth, i);
            }
        }
    }

    public void swap(char[] arr, int i, int j) {
        char tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    public boolean[] SetPrimes(int cap) {
        boolean[] primes = new boolean[cap];
        primes[0] = primes[1] = true;
        for(int i = 2; i <= Math.sqrt(cap); i++) {
            int index = 2;
            if(primes[i]) continue;
            while(index*i < cap) {
                primes[i*index++] = true;
            }
        }

        return primes;
    }
}