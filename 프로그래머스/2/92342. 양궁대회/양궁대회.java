import java.util.*;

class Solution {
    static int N;
    static int[] peach; // 어피치 기록
    static int[] lion; // dfs로 완성되는 라이언 기록
    static int[] answer; 
    static int max = 0;
    
    public int[] solution(int n, int[] info) {
        N = n;
        peach = info;
        lion = new int[11];
        answer = null; // 절대 못이길때
        
        dfs(n, 0); // 남은 화살, idx
        
        return answer == null ? new int[]{-1} : answer;
    }
    
    static void dfs(int remain, int idx){ 
        if(idx == 11){ // 점수판 다 확인했으면
            // 점수
            int lionScore =0;
            int peachScore =0;
            // 남는 화살처리 필요
            if(remain > 0){
                lion[10] += remain;
            }
            
            // 점수계산
            for(int i = 0; i<11; i++){
                int score = 10 - i; // 0일때 10점이니까
                
                if(lion[i] == 0 && peach[i] ==0) continue;
                
                if(lion[i]>peach[i]){ //라이언 승
                    lionScore += score;
                } else {
                    peachScore += score;
                }          
            }
            
            // 가장 큰 점수차이 검사
            int diff = lionScore - peachScore;
            if(diff > 0){
                if(diff > max){ // 기존 max보다 크면
                    max = diff;
                    answer = lion.clone();
                } else if(diff == max){ // 같으면 가장 낮은 점수 더많이 맞춘기록
                    for(int i=10; i>=0; i--){ // 0점부터
                        if(lion[i]==answer[i]) continue;
                        if(lion[i]>answer[i]){
                            answer = lion.clone();
                        } 
                        break; // 크든 작든 넘어갔으니
                        
                    }
                }
            }
            
            // 남는 화살처리 복구
            if(remain > 0){
                lion[10] -= remain;
            }
            return;
        }
        
        //여기서 라이언배열 만들기
        // 포기하기
        lion[idx] = 0;
        dfs(remain, idx+1);
        // 이기기 (남은 화살이 어피치기록+1보다 많으면)
        if(remain >= peach[idx]+1){
            lion[idx] = peach[idx]+1;
            
            dfs(remain - (peach[idx]+1), idx+1);
            
            lion[idx] = 0;
        }
    }
    
    
}