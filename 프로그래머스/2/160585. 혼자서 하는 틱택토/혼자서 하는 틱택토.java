class Solution {
    public int solution(String[] board) {
        int answer = -1;
        
        // 실수1 : 차례실수
        // 실수2 : 게임 종료 후 진행
        
        // 1:o 2:x 3:o 4:x 5:o
        // 체크갯수가 n일때 o의 개수는 n/2+1 , x의 개수는 n/2
        
        // 만약 o성공 : x개수는 o개수-1
        // x성공 : o개수는 x개수-1
        
        // 0 1 2
        // 3 4 5
        // 6 7 8
        

        int o = 0;
        int x = 0;
        
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[i].charAt(j) == 'O') o++;
                else if (board[i].charAt(j) == 'X') x++;
            }
        }
        
        // 차례 실수검토
        if(x > o || o-x > 1) return 0;
        
        boolean oWin = isWin('O', board);
        boolean xWin = isWin('X', board);
        
        if(oWin && xWin) return 0;
        // x와 개수 비교
        if(oWin && x >= o) return 0;
      
        // o와 개수 비교
        if(xWin && o > x) return 0;  
        
        System.out.println(o);
        System.out.println(x);
        System.out.println(oWin);
        System.out.println(xWin);
        
        return 1;
    }
    
    static boolean isWin(char c, String[] board){
        for(int i=0; i<3; i++){
            if(board[i].charAt(0) == c && board[i].charAt(1) == c && board[i].charAt(2) == c) return true;
            if(board[0].charAt(i) == c && board[1].charAt(i) == c && board[2].charAt(i) == c) return true;
        }
        
        if(board[0].charAt(0) == c && board[1].charAt(1) == c && board[2].charAt(2) == c) return true;
        if(board[0].charAt(2) == c && board[1].charAt(1) == c && board[2].charAt(0) == c) return true;
        
        return false;
    }
}