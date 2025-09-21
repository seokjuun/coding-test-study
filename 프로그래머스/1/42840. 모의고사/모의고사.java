import java.util.*;
class Solution {
    public int[] solution(int[] answers) {
        int[] num1 = {1,2,3,4,5}; // 5
        int[] num2 = {2,1,2,3,2,4,2,5}; // 8
        int[] num3 = {3,3,1,1,2,2,4,4,5,5}; // 10
        
        int[] score = new int[3];
        
        for(int i=0; i<answers.length; i++){
            if(answers[i] == num1[i % num1.length]) score[0]++;
            if(answers[i] == num2[i % num2.length]) score[1]++;
            if(answers[i] == num3[i % num3.length]) score[2]++;
        
        }
        int max = Math.max(score[0], Math.max(score[1], score[2]));
        
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            if (score[i] == max) list.add(i + 1);
        }

        
        int[] result = new int[list.size()];
        for (int i = 0; i < list.size(); i++) result[i] = list.get(i);

        return result;
    }
}