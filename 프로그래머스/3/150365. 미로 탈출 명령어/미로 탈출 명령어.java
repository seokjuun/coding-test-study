import java.util.*;

class Solution {
        
    public String solution(int n, int m, int x, int y, int r, int c, int k) {
        String answer = "";
        
        int[] count = new int[4];
        // 최단구하기
        int dy = r - x;
        int dx = c - y;
        
        int total = Math.abs(dy) + Math.abs(dx);
    
        if(dy > 0){
            count[0] = Math.abs(dy); //d
        } else if(dy < 0){
            count[1] = Math.abs(dy); //u
        }
        
        if(dx > 0){
            count[2] = Math.abs(dx); //r
        } else if(dx < 0){
            count[3] = Math.abs(dx); //l
        }
        
        // k에 도착불가
        if(total > k || (k - total)%2==1 ) return "impossible";
        
        // 반복넣기
        int repeat = (k - total)/2;
        StringBuilder sb = new StringBuilder();
        int cy = x;
        int cx = y;
        
        for(int i=0; i<k; i++){
            if(count[0] > 0){
                sb.append('d');
                count[0]--;
                cy++;
                continue;
            } else if(cy<n && repeat >0){ // d u
                sb.append('d');
                count[1]++;
                cy++;
                repeat--;
                continue;
            } else if(count[3] > 0){
                sb.append('l');
                count[3]--;
                cx--;
                continue;
            } else if(cx>1 && repeat >0){ // l r
                sb.append('l');
                count[2]++;
                cx--;
                repeat--;
                continue;
            } else if(cx<m && repeat >0){ // r l
                sb.append('r');
                count[3]++;
                cx++;
                repeat--;
                continue;
            } else if(count[2] >0){
                sb.append('r');
                count[2]--;
                cx++;
            } else if(count[1]>0){
                sb.append('u');
                count[1]--;
                cy--;
            }
        }
        
        
        
        
        
        return sb.toString();
    }
}