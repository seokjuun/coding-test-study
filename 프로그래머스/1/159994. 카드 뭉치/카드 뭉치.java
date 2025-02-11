import java.util.*;
class Solution {
    public String solution(String[] cards1, String[] cards2, String[] goal) {
        Deque<String> queue1 = new ArrayDeque<>(Arrays.asList(cards1));
        Deque<String> queue2 = new ArrayDeque<>(Arrays.asList(cards2));
        
        for(int i=0; i<goal.length; i++){
            if(goal[i].equals(queue1.peek())){
                queue1.poll();
            } else if(goal[i].equals(queue2.peek())){
                queue2.poll();
            } else {
                return "No";
            }
        }
        
        return "Yes";
    }
}