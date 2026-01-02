class Solution {
    public int solution(int n) {
        int answer = 0;
        
        int a=1, b=1;
        
        for(int i =3; i<n+1; i++){
            int c = (a+b) % 1234567;
            a = b;
            b = c;
        }
        
        return b;
    }
}