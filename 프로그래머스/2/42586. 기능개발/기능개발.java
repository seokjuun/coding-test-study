import java.util.*;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
    
        int idx=0;
        boolean[] checked = new boolean[progresses.length];
        List<Integer> list = new ArrayList<>();
        
        while(idx < progresses.length){
            // 매일 작업
            for(int i=0; i<progresses.length; i++){
                if (!checked[i]) {
                    progresses[i] += speeds[i];
                    if (progresses[i] >= 100) {
                        checked[i] = true;
                    }
                }
            }  
            // 하루 끝
            int count =0;
            while(idx < checked.length && checked[idx]){
                idx++;
                count++;
            }
            
            if(count>0){
                list.add(count);
            }
        }
        
        return list.stream().mapToInt(i->i).toArray();
    }
}