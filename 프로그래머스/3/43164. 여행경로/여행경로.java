import java.util.*;

class Solution {
    static boolean[] visited;
    
    public String[] solution(String[][] tickets) {
        String[] answer = new String[tickets.length+1];
        
        visited = new boolean[tickets.length];
        Arrays.sort(tickets, (a,b)-> a[1].compareTo(b[1]));
        
        answer[0] = "ICN";
        dfs("ICN", answer, 1, tickets);
        
        return answer;
    }
    
    static boolean dfs(String start, String[] answer, int idx, String[][] tickets){
        if(idx == tickets.length+1){
           return true; 
        }
        
        for(int i=0; i<tickets.length; i++){
            if(!visited[i] && tickets[i][0].equals(start)){
                visited[i] = true;
                
                answer[idx] = tickets[i][1];
                
                if(dfs(tickets[i][1], answer, idx+1, tickets)) return true;
                
                visited[i] = false;
            }
        }
        
        return false;
    }
}