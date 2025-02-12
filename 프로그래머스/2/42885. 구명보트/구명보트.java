import java.util.*;
class Solution {
    public int solution(int[] people, int limit) {
        int start = 0;
        int end = people.length-1;
        int count =0;
        Arrays.sort(people);
        
        while(start<=end){
            if(people[end] + people[start] <= limit){
                count++;
                start++;
                end--;
            } else{
                count++;
                end--;
            }
            
        }

        return count;
    }
}