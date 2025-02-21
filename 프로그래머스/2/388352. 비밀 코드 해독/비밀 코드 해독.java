import java.util.*;

class Solution {
    static int result = 0;
    static int[] src;
    static int[] tgt = new int[5];
    public int solution(int n, int[][] q, int[] ans) {
        src = new int[n];
        for(int i=0; i<n; i++){
            src[i] = i+1;
        }
        
        comb(0,0,q,ans);
        return result;
    }
    
    static void comb(int srcIdx, int tgtIdx, int[][] q,int[] ans){
        if(tgtIdx == 5){ // 5개 다 채우면
            // 검증 해야됨
            check(q,ans);
            return;
        }
        if(srcIdx == src.length) return;
        
        tgt[tgtIdx] = src[srcIdx];
        comb(srcIdx+1, tgtIdx+1, q,ans);
        comb(srcIdx+1, tgtIdx, q,ans);
    };
    
    static void check(int[][] q,int[] ans){
        Set<Integer> set = new HashSet<>();
        for (int num : tgt) {  // 셋에 5개 넣고
            set.add(num);
        }

        int count = 0;
        for (int i = 0; i < q.length; i++) {
            int count2 = 0;
            for (int num : q[i]) {
                if (set.contains(num)) {
                    count2++;
                }
            }
            if (count2 == ans[i]) {
                count++;
            }
        }
        
        if (count == q.length) { 
            result++;
        }
    }
}