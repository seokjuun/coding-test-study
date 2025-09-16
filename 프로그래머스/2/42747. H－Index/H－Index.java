import java.util.*;
class Solution {
    public int solution(int[] citations) {
        Arrays.sort(citations); 
        
        for(int i = 0; i<citations.length; i++){
            // citations.length - i : 전체후보에서 현재 인덱스를 빼니까 인용이 citations.length - i 보다 이상인 논문 수 
             
            if (citations[i] >= citations.length - i) { // h번 인용된 논문이 h편 이상
                return citations.length - i;
            }
        }
        return 0;
    }
}