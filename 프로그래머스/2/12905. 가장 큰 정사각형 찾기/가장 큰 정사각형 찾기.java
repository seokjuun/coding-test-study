class Solution
{
    public int solution(int[][] board)
    {
        int answer = 0;

        int y = board.length;
        int x = board[0].length;
        
        for(int i=1; i<y; i++){
            for(int j=1; j<x; j++){
                if(board[i][j] == 1){
                    int up = board[i-1][j];
                    int left = board[i][j-1];
                    int bear = board[i-1][j-1];
                
                    board[i][j] = Math.min(up, Math.min(left,bear)) +1;    
                }
                
            }
        }
        
        for (int i = 0; i < y; i++) {
            for (int j = 0; j < x; j++) {
                answer = Math.max(answer, board[i][j]);
            }
        }
        
        return answer*answer;
    }

}