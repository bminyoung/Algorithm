package me.nyoung.BOJ.Queue;

import java.util.ArrayList;
import java.util.Scanner;

public class sol_10866 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        ArrayList<Integer> deque = new ArrayList<>();
        sc.nextLine();

        for(int i = 0; i < n; i++){
            String cmd = sc.nextLine();
            if(cmd.equals("pop_front")){
                if(deque.size() == 0) System.out.println(-1);
                else{
                    System.out.println(deque.get(0));
                    deque.remove(0);
                }
            }else if(cmd.equals("pop_back")){
                if(deque.size() == 0) System.out.println(-1);
                else{
                    System.out.println(deque.get(deque.size()-1));
                    deque.remove(deque.size()-1);
                }
            }else if(cmd.equals("size")){
                System.out.println(deque.size());
            }else if(cmd.equals("empty")){
                if(deque.size() == 0) System.out.println(1);
                else System.out.println(0);
            }else if(cmd.equals("front")){
                if(deque.size() == 0) System.out.println(-1);
                else System.out.println(deque.get(0));
            }else if(cmd.equals("back")){
                if(deque.size() == 0) System.out.println(-1);
                else System.out.println(deque.get(deque.size()-1));
            }else{
                if(cmd.split(" ")[0].equals("push_front")) {
                    deque.add(0, Integer.parseInt(cmd.split(" ")[1]));
                }else {
                    deque.add(Integer.parseInt(cmd.split(" ")[1]));
                }
            }
        }
    }
}
