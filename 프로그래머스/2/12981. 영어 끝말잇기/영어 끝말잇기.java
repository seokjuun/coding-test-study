import java.util.*;

class Solution {
    public int[] solution(int n, String[] words) {

        Set<String> set = new HashSet<>();
        int turn=0,num=0;
        set.add(words[0]);
        
        for(int i=1; i<words.length; i++){
            char last = words[i-1].charAt(words[i-1].length() - 1);
            char first = words[i].charAt(0);
            
            if(!set.add(words[i]) || (last!=first) ){
                turn = i/n +1; 
                num = i%n +1;
                break;
            }
        }
        
        int[] answer = {num, turn};

        return answer;
    }
}