import java.util.*;

class Solution {
    public long solution(int cap, int n, int[] deliveries, int[] pickups) {

        int dIdx = n-1;
        int pIdx = n-1;
        long dist = 0;
        
        while(dIdx>-1 || pIdx>-1){ // 다 완료되면 끝
            int dCap = cap;
            int pCap = cap;
            // 맨뒤 0인곳 없애기
            while(dIdx>=0 && deliveries[dIdx] == 0) dIdx--;
            while(pIdx>=0 && pickups[pIdx] == 0) pIdx--;
            
            // 물류센터 출발할때 거리 더하기
            dist += (Math.max(dIdx, pIdx)+1) * 2;
            
            // 맨 끝에서 부터 적재
            while(dIdx>=0 && dCap>0){
                if(deliveries[dIdx] <= dCap){
                    dCap -= deliveries[dIdx];
                    dIdx--;
                } else{
                    deliveries[dIdx] -= dCap;
                    dCap=0;
                }
            }
            
            while(pIdx>=0 && pCap>0){
                if(pickups[pIdx] <= pCap){
                    pCap -= pickups[pIdx];
                    pIdx--;
                } else{
                    pickups[pIdx] -= pCap;
                    pCap=0;
                }
            }
            
        }
        

        return dist;
    }
}