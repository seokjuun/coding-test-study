import java.util.*;
class Solution {
    
    public int solution(int[] schedules, int[][] timelogs, int startday) {
        int answer = 0;
        // schedules[0] : 첫번째 직원이고 700~1100 사이 값
        // timelogs[n][7] : (일주일) n명 직원이 7일동안 출근한 시각 600~2359
        // startday 1: 월
        
        // 1. 요일 포문을 돌면서 schedules[i] <= int[][] timelogs <= schedules[i] + 10
        // 1-1. 100나머지가 60을 넘으면 시간처리
        // 2. startday가 6,7이면 넘겨
        
        int person=0;
        for(int i=0; i<schedules.length; i++){ // 희망 시간 변경
            if((schedules[i]+10)%100>59){
                schedules[i] = (((schedules[i]+10)/100)+1)*100 + ((schedules[i]+10)%100-60);
            } else {
                schedules[i] += 10;
            }
        }
        
        
        for(int i=0; i<schedules.length; i++){ // 직원 수 만큼 돌아
            int day = startday;
            int count = 0;
            for(int j=0; j<7; j++){ // 7일동안
                if(day%7 == 6 || day%7 == 0){
                    count++;
                } else if(timelogs[i][j] <= schedules[i]){
                    count++;
                }
                day++;
            }
            if(count == 7){
                person++;
            }
        }
        
        return person;
    }
}