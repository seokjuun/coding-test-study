import java.util.*;

class Solution { 
    public int solution(int[] diffs, int[] times, long limit) {
        int answer = 0;
        
        int[] diffSort = diffs.clone();
        Arrays.sort(diffSort);
        int levelMin = diffSort[0];
        int levelMax = diffSort[diffSort.length -1];
        
        // 찾을때까지 while
        while(levelMin < levelMax){
            int levelTest = (levelMin + levelMax) / 2;
        
            long sum = 0;
            for(int i=0; i<diffs.length; i++){
                int diff = diffs[i];
                int time = times[i];

                if(levelTest >= diff){ 
                    sum += time;
                } else {
                    int gap = diff - levelTest;
                    int timePrev = (i == 0) ? 0 : times[i - 1];;
                    sum += (long)(gap * (time + timePrev) + time);
                }

                if(sum>limit) break;
            }

            if(sum>limit){
                levelMin = levelTest +1; 
            } else {
                levelMax = levelTest;
            }
        }
        
        return levelMin;
    }
    
    
}