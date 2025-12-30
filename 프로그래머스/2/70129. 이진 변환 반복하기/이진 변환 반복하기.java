import java.util.*;

class Solution {
    static int zero;
    
    public int[] solution(String s) {
        int[] answer = {};
        zero = 0;
        int cnt =0;
        
        while(!s.equals("1")){
            cnt++;
            s = change(s);
        }
        
        
        return new int[]{cnt, zero};
    }
    
    static String change(String str){
        String s = str;
        int len = str.length();
        s = s.replace("0","");
        int c = s.length();
        zero += (len - c);
        
        Stack<Integer> stack = new Stack<>();
        while(c != 0){
            int n = c%2;
            c = c/2;
            
            stack.push(n);
        }
        
        String reStr = "";
        while(!stack.isEmpty()){
            reStr += stack.pop();
        }
        
        return reStr;
    }
}