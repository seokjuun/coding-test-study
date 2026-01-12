import java.util.*;

class Solution {
    public String[] solution(String[] s) {
        String[] answer = new String[s.length];
        
        // 110 찾기
        // 마지막 0뒤, 1앞에 때려박기
        int t = 0;
        for(String str: s){ 
            StringBuilder sb = new StringBuilder();
            int count = 0;
            
            // 110 세기
            for(int i=0; i<str.length(); i++){
                char c = str.charAt(i);
                sb.append(c);
                
                if(sb.length() >= 3){
                    int len = sb.length();
                    if(sb.charAt(len-1) == '0' && sb.charAt(len-2) == '1' && sb.charAt(len-3) == '1'){
                        count++;
                        sb.delete(len-3, len);
                    }
                }
            }
            
            // sb 110뺀상태 -> 마지막0뒤
            int idx = sb.length() -1;
            while(idx>=0 && sb.charAt(idx) == '1'){
                idx -=1;
            }
            
            
            String left = sb.substring(0, idx+1);
            String right = sb.substring(idx+1);
            StringBuilder mid = new StringBuilder();
            
            for(int i =0; i<count; i++){
                mid.append("110");
            }
            
            answer[t] = left+mid+right;
            t++;
        }
           
        return answer;
    }
    
    
    
}