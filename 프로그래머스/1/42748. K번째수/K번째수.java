import java.util.*;

class Solution {
    
    static List<Integer> list;
    static int[] arr;
    
    public int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];
        
        list = new ArrayList<>();
        arr = array.clone();
        
        for(int[] cmd : commands){
            int start = cmd[0];
            int end = cmd[1];
            int k = cmd[2];
            
            cut(start, end, k);
        }
        
        for(int i =0; i<list.size(); i++){
            answer[i] = list.get(i);
        }
        
        return answer;
    }
    
    static void cut(int s, int e, int k){
        List<Integer> nList = new ArrayList<>();
        
        for(int i = (s-1); i < e; i++){
            nList.add(arr[i]);
        }
        
        nList.sort((a,b) -> Integer.compare(a,b));
        list.add(nList.get(k-1));
    }
    
}