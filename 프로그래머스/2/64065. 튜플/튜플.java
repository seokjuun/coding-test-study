import java.util.*;

class Solution {
    public int[] solution(String s) {
        
        
        String str = s.substring(2, s.length()-2);
        
        String[] strArr = str.split("\\},\\{");
        int[] answer = new int[strArr.length];
        
        Arrays.sort(strArr, (a,b) -> Integer.compare(a.length(), b.length()));
        
        Set<Integer> set = new HashSet<>();
        int idx =0;
        for(String ss : strArr){
            StringTokenizer st = new StringTokenizer(ss,",");
            while(st.hasMoreTokens()){
                int num = Integer.parseInt(st.nextToken());
                if(set.add(num)){
                   answer[idx++] = num;   
                }
            }
        }
        
        
        
        return answer;
    }
}
