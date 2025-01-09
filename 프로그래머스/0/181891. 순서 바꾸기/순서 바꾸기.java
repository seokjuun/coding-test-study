import java.util.*;
class Solution {
    public int[] solution(int[] num_list, int n) {
        
        int[] a = Arrays.copyOfRange(num_list, n, num_list.length);
        int[] b = Arrays.copyOfRange(num_list, 0, n);
        int[] answer = new int[num_list.length];
        
        System.arraycopy(a, 0, answer, 0, a.length);
        System.arraycopy(b, 0, answer, a.length, b.length);
        
        return answer;
    }
}