class Solution {
    public int[] solution(int brown, int yellow) {
        // int total = brown + yellow;
        // yellow = n*m;
        // brown = 2n+4+2m
        
//         yellow = n * m;
//         24 = n * m;
//         (brown-4) /2 = n+m;
//         10 = n+m;
//         10-m = n;
        
//         24 = (10-m) * m;
//         24 = 10*m - m*m;
        // int n,m;
        for(int m=1; m*m<=yellow; m++){ // m<n
            if(yellow%m !=0) continue; // 약수아님 컷
            int n = yellow/m;
            
            if(2*(n+m) +4 == brown){
                return new int[]{n+2, m+2};
            }
        }
        
        
        return new int[]{0,0};
    }
}