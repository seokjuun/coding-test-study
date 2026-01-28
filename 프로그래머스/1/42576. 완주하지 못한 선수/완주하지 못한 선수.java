import java.util.*;

class Solution {
    public String solution(String[] participant, String[] completion) {
        String answer = "";
        
        Arrays.sort(participant, (a,b) -> a.compareTo(b));
        Arrays.sort(completion, (a,b) -> a.compareTo(b));
        
        
        for(int i=0; i<completion.length; i++){
            if(!participant[i].equals(completion[i])){
                return participant[i];
            }
        }
        
        return participant[participant.length -1];
        
    }
}