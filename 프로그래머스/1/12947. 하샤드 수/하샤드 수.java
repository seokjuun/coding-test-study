class Solution {
    public boolean solution(int x) {
        int n = x;
        int sum = 0;

        while (x > 0) {
            sum += x % 10;
            x /= 10; 
        }

        return n % sum == 0;
    }
}