import java.util.*;

class Solution {
    public int solution(int storey) {
        int answer = 0;
        
        int num = storey;
        while(num != 0){
            int n = num%10;
            num = num/10;
            
            if(n<5){
                answer += n;
            } else if(n>5) {
                answer += (10-n);
                num+=1;
            } else {
                if(num%10 >=5){
                    num+=1;
                } 
                answer+=n;
            }
        }

        return answer;
    }
}