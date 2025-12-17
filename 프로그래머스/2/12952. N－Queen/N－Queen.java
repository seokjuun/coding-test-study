class Solution {
    static boolean[] col;
    static boolean[] bear;
    static boolean[] bull;
    static int count = 0;
    
    public int solution(int n) {
        int answer = 0;
        // 행은 자동처리
        col = new boolean[n]; // 열
        bear = new boolean[2*n - 1]; // 상승, y+x 같음
        bull = new boolean[2*n - 1]; // 하락, y-x 같음
        
        dfs(0,n);
        
        return count;
    }
    
    static void dfs(int row, int n){ // row : 현재위치하는 행, 퀸의개수-1
        if(row == n){ 
            count++;
            return; 
        }
        
        for(int i=0; i<n; i++){ // 행은정해져 있고, 열 시도
            
            if(col[i] || bear[row+i] || bull[row-i+(n-1)]) continue; // 대각,열 이미 퀸있으면
            
            col[i] = true;
            bear[row+i] = true;
            bull[row-i+(n-1)] = true;  // 음수보정
            
            dfs(row+1, n);
            
            col[i] = false;
            bear[row+i] = false;
            bull[row-i+(n-1)] = false;
        }
        
        
    }
}