import java.util.*;

class Solution {
    static int count =0;
    
    public int solution(int[] topping) {
        
        // 시간초과 이슈 있었음(count 메서드안에서 계속 새로운 set 생성)
        int n = topping.length;
        int[] leftCnt = new int[n];
        int[] rightCnt = new int[n];
        
        Set<Integer> leftSet = new HashSet<>();
        for(int i =0; i<n; i++){
            leftSet.add(topping[i]);
            leftCnt[i] = leftSet.size();
        }
        
        Set<Integer> rightSet = new HashSet<>();
        for (int i=n-1; i>=0; i--) {
            rightSet.add(topping[i]);
            rightCnt[i] = rightSet.size();
        }
        
        for (int i=0; i < n-1; i++) {
            if (leftCnt[i] == rightCnt[i+1]) {
                count++;
            }
        }
        
        
        return count;
    }

}