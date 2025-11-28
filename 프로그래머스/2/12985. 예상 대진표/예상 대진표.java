class Solution
{
    public int solution(int n, int a, int b)
    {
        int round = 0; // 초기 라운드 0
        
        while(a != b){
            a = (a+1) / 2; // 다음 라운드 번호
            b = (b+1) / 2;
            round++;
        }
        
        return round;
    }
}