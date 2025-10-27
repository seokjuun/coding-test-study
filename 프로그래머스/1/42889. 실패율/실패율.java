import java.util.*;

class Solution {
    public int[] solution(int N, int[] stages) {
        int[] stop = new int[N+2];
        
        for(int stage : stages){
            stop[stage] += 1;
        }
        
        int user = stages.length;
        double[][] fail = new double[N][2];
        
        for(int i=0; i<N; i++){
            fail[i][0] = i+1;
            if (user > 0) {
                fail[i][1] = (double)stop[i + 1] / user;
            } else {
                fail[i][1] = 0.0; 
            }
            user -= stop[i+1];
        }
        
        Arrays.sort(fail, (a,b)-> {
            int result = Double.compare(b[1], a[1]);
            if(result == 0) return Double.compare(a[0],b[0]);
            return result;
        });
        
        int[] answer = new int[N];    
        for(int i =0; i<N; i++ ){
            answer[i] = (int)fail[i][0];
        }
        
        return answer;
    }
}