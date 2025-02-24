import java.util.*;
class Solution {
    public int solution(int[] players, int m, int k) {
        int count = 0;
        int[] server = new int[24];
    
        for(int i=0; i<24; i++){
            if(players[i]>m*server[i]+(m-1)){
                int kk = ((players[i]-(m*server[i]+(m-1)))-1)/m+1;
                for(int j=0; j<k; j++){
                    if((i+j)>23) continue;
                    server[i+j] += kk;
                }
                count += kk;
            }
        }
        return count;
    }
}