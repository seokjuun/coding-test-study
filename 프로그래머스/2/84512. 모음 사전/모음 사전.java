import java.util.*;

class Solution {
    public int solution(String word) {
        int answer = 0;
        
        String[] arr = new String[] {"A", "E", "I", "O", "U"};
        List<String> list = new ArrayList<>();
        
        for(int i=1; i<=5; i++){
            dfs(i, arr, list, "");
        }
        
        Collections.sort(list);
        
        for(int j =0; j<list.size(); j++){
            if(list.get(j).equals(word)){
                return j+1;
            }
        }
        
        return answer;
    }
    
    static void dfs(int len, String[] src, List<String> list, String tgt){
        if(tgt.length() == len) {
            list.add(tgt);
            return;
        }
        
        for(int i=0; i<src.length; i++){
            dfs(len, src, list, tgt+src[i]);
        }
    }
}