import java.util.*;

class Solution {
    public int solution(int[] priorities, int location) {
        int[] idxArr = new int[priorities.length];
        for(int i =0; i<idxArr.length; i++){
            idxArr[i] = i;
        } 
        // 0 1 2 3 4 5
        // 1 1 9 1 1 1
        int cnt=0;
        int tgtP = priorities[location];
        
        Queue<Integer> pQueue = new ArrayDeque<>();
        Queue<Integer> idxQueue = new ArrayDeque<>();
        
        for(int i=0; i<priorities.length; i++){
            pQueue.offer(priorities[i]);
            idxQueue.offer(idxArr[i]);
        }
        
        while(!pQueue.isEmpty()){
            int pollP = pQueue.poll();
            int pollIdx = idxQueue.poll();
            
            // 우선순위 높은게 있는지 체크
            boolean moreHigh = false;
            for(int p : pQueue){
                if(p>pollP){
                    moreHigh = true;
                    break;
                }
            }
            
            if(moreHigh){
                pQueue.offer(pollP);
                idxQueue.offer(pollIdx);
            } else {
                cnt++;
                if(pollIdx == location){
                    return cnt;
                }
            }
        }
        return 0;
    }
}


