import java.util.*;

class Solution {
    public int solution(int[][] data, int col, int row_begin, int row_end) {
        
        Arrays.sort(data, (a,b)-> {
            if(a[col-1] == b[col-1]){
                return Integer.compare(b[0], a[0]);
            } else {
                return Integer.compare(a[col-1], b[col-1]);
            }
        });
        
        int answer = 0;
        
        for(int i = row_begin-1; i<row_end; i++){
            int[] arr = data[i];
            int s = doMod(arr, i+1);
            
            answer = answer ^ s;
        }
        
        
        return answer;
    }
    
    static int doMod(int[] arr, int idx){
        int n =0;
        for(int i=0; i<arr.length; i++){
            n += arr[i]%idx;
        }
        
        return n;
    }
}