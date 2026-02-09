class Solution {
    
    static int n;
    static int count = 0;
    
    public int solution(int[] numbers, int target) {
        int answer = 0;
        
        n = numbers.length;
        dfs(0,0,target,numbers);
        
        return count;
    }
    
    static void dfs(int idx, int sum ,int target, int[] numbers){
        // 기저
        if(idx == n){
            if(sum == target) count++;
            return;
        }
        
        dfs(idx+1, sum-numbers[idx], target, numbers);
        dfs(idx+1, sum+numbers[idx], target, numbers);
        
    }
}