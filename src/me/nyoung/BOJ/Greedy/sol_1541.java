package me.nyoung.BOJ.Greedy;

public class sol_1541 {
    public int min(String str) {
        int index = 0;
        while (index < str.length() && str.charAt(index) != '-') index++;
        int result = 0;
        if (index == str.length()) { // only + OR only digit
            result = plus(str);
        } else {
            result = plus(str.substring(0, index));
            str = str.substring(index+1).replace('+', '-');
            String[] nums = str.split("-");
            for (int i = 0; i < nums.length; i++) {
                result -= Integer.parseInt(nums[i]);
            }
        }
        return result;
    }

    public int plus(String str){
        int result = 0;
        try {
            result = Integer.parseInt(str);
        } catch (NumberFormatException e) {
            String[] nums = str.split("\\+");
            for (int i = 0; i < nums.length; i++) {
                result += Integer.parseInt(nums[i]);
            }
        }

        return result;
    }
}
