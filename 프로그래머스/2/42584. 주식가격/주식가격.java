import java.util.*;

class Solution {
    public int[] solution(int[] prices) {
        Deque<int[]> stack = new ArrayDeque<>();
        int[] arr = new int[prices.length];
        
        stack.push(new int[]{prices[0],0});
        for(int i =1; i<prices.length; i++){
            
                while(!stack.isEmpty() && stack.peek()[0] > prices[i]){ // 가격이 떨어져서 pop 해야 할 때
                    int[] pop = stack.pop(); // 가격, 시간
                    arr[pop[1]] = i - pop[1];
                }
                stack.push(new int[]{prices[i],i});
            
        }
        
        while(!stack.isEmpty()){
            int[] pop = stack.pop(); // 가격, 시간
            arr[pop[1]] = prices.length-1 - pop[1];
        }
        
        return arr;
    }
}