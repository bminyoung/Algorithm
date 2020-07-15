package me.nyoung.Programmers.level2.스킬트리;

public class Solution {
    public int solution(String skill, String[] skill_trees) {
        int answer = 0;
        for (int i = 0; i < skill_trees.length; i++) {
            boolean result= true;
            String skillTree = skill_trees[i];
            int[] indice = new int[skill.length()];
            for(int j = 0; j < skill.length(); j++) {
                indice[j] = skillTree.indexOf(skill.charAt(j));
            }

            boolean isEnd = false;
            int k;
            for (k = 0; k < indice.length - 1; k++) {
                if(indice[k] == -1) isEnd = true;

                if(isEnd && indice[k+1] != -1){
                    result = false;
                    break;
                }
                if(indice[k] >= indice[k + 1] && indice[k + 1] != -1) {
                    result = false;
                    break;
                }
            }
            if(result || k == indice.length - 1) answer++;
        }
        return answer;
    }
}
