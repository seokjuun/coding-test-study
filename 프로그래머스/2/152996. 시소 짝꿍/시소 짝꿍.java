import java.util.*;


class Solution {
    static boolean[] visited;
    
    public long solution(int[] weights) {
        long answer = 0;
        // 1:1 2/3:1 3/4:1 1/2:1
        Arrays.sort(weights);
        
        Map<Double, Integer> map = new HashMap<>();
        
        for(int weight : weights){
            double w = (double) weight;
            
            if(map.containsKey(w)) answer+= map.get(w);
            if(map.containsKey(2*w/3)) answer+= map.get(2*w/3);
            if(map.containsKey(3*w/4)) answer+= map.get(3*w/4);
            if(map.containsKey(w/2)) answer+= map.get(w/2);
            
            map.put(w, map.getOrDefault(w, 0) +1);
        }
        
        return answer;
    }

}