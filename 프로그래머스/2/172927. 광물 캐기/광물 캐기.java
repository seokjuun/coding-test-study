import java.util.*;

class Solution {
    public int solution(int[] picks, String[] minerals) {
        int answer = 0;
        int dPick = picks[0];
        int iPick = picks[1];
        int sPick = picks[2];
        int totalPick = dPick + iPick + sPick;
        
        // 자르기
        int maxMinerals = Math.min(minerals.length, totalPick*5);
        
        // 피로도 계산
        List<int[]> list = new ArrayList<>();
        for(int i=0; i<maxMinerals; i+=5){
            int dia=0, iron=0, stn=0;
            
            for(int j = i; j<Math.min(i+5, maxMinerals); j++){
                if(minerals[j].equals("diamond")){
                    dia+=1;
                    iron+=5;
                    stn+=25;
                } else if(minerals[j].equals("iron")){
                    dia+=1;
                    iron+=1;
                    stn+=5;
                } else {
                    dia+=1;
                    iron+=1;
                    stn+=1;
                }
            }
            
            list.add(new int[]{dia,iron,stn});
        }
        
        // 피로도 정렬
        Collections.sort(list, (a,b)-> Integer.compare(b[2], a[2]));
        
        for(int i=0; i<list.size(); i++){
            int[] arr = list.get(i);
            
            if(dPick > 0){
                answer += arr[0];
                dPick--;
            }else if(iPick>0){
                answer += arr[1];
                iPick--;
            } else {
                answer += arr[2];
                sPick--;
            }
            
            
        }
        
        
        
        return answer;
    }
}