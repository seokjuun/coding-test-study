import java.util.*;

class Solution {
    public boolean solution(String[] phone_book) {
        Arrays.sort(phone_book);
        
        for(int i =0; i<phone_book.length-1; i++){
            int cnt =0;
            if(phone_book[i].length() >= phone_book[i+1].length()) continue;
            for(int j=0; j<phone_book[i].length(); j++){
                if(phone_book[i].charAt(j) != phone_book[i+1].charAt(j)) continue;
                cnt++;
            }
            
            if(cnt == phone_book[i].length()) return false;
            
        }
        
        return true;
    }
}