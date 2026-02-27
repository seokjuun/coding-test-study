import java.util.*;


class Solution {
    static boolean[] visited;
    
    static class Node{
        String str;
        int count;
        
        public Node(String str, int count){
            this.str = str;
            this.count = count;
        }
    }
    
    public int solution(String begin, String target, String[] words) {
        int answer = 0;
        
        int n = words.length;
        visited = new boolean[n];
        
        Deque<Node> queue = new ArrayDeque<>();
        queue.offer(new Node(begin, 0));
        
        
        while(!queue.isEmpty()){
            Node poll = queue.poll();
            int pCnt = poll.count;
            String pStr = poll.str;
            
            if(pStr.equals(target)) return pCnt;
            
            for(int i=0; i<n; i++){
                if(!visited[i] && canChange(pStr, words[i])){
                    visited[i] = true;
                    queue.offer(new Node(words[i], pCnt+1));
                }
            }
        }
        
        
        
        return 0;
    }
    
    static boolean canChange(String cur, String word){
        int cnt = 0;
        
        for(int i=0; i<cur.length(); i++){
            if(cur.charAt(i) != word.charAt(i)) cnt++;
            
            if(cnt > 1) return false;
        }
        
        return true;
    }
}