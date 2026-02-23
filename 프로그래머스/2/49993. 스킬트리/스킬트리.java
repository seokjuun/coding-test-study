import java.util.*;

class Solution {
    public int solution(String skill, String[] skill_trees) {
        int answer = 0;

        for (String tree : skill_trees) {
            Deque<Character> queue = new ArrayDeque<>();
            
            for(char c : skill.toCharArray()){
                queue.offer(c);
            }

            boolean can = true;

            for(int i=0; i<tree.length(); i++){
                char current = tree.charAt(i);
                
                if(skill.contains(String.valueOf(current))){
                    if(current == queue.peek()){
                        queue.poll();
                    } else{
                        can = false; 
                        break;
                    }
                }
            }

            if(can)answer++;
        }
        
        return answer;
    }
}