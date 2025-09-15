import java.util.*;

class Solution {
    public String solution(int[] numbers) {
        String[] strArr = new String[numbers.length];
        for(int i =0; i<numbers.length; i++){
            strArr[i] = Integer.toString(numbers[i]);
        }
        // 여기서 문자열 내림차순 정렬
        Arrays.sort(strArr, (a,b)->  
            (b+a).compareTo(a+b)
        );
        // 억까;
        if (strArr[0].equals("0")) return "0";
        
        StringBuilder sb = new StringBuilder();
        for(String str : strArr){
            sb.append(str);
        }
        
        return sb.toString();
    }
}