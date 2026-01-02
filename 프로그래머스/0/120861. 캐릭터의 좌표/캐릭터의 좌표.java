class Solution {
    
    static int[] dy = {1,-1,0,0};
    static int[] dx = {0,0,-1,1};
    
    public int[] solution(String[] keyinput, int[] board) {
        int[] answer = new int[]{0, 0};
        
        int y = 0;
        int x = 0;
        int rx = board[0]/2;
        int ry = board[1]/2;
        
        for(String key : keyinput){
            int dir = -1;
            switch(key){
                case("up"):
                    dir = 0;
                    break;
                case("down"):
                    dir = 1;
                    break;
                case("left"):
                    dir = 2;
                    break;
                case("right"):
                    dir = 3;
                    break;
            }
            int ny = y+dy[dir];
            int nx = x+dx[dir];
            
            if(ny + ry < 0 || nx + rx< 0 || ny > ry || nx > rx) continue;
            
            y = ny;
            x = nx;
            System.out.println( x +" " +y);
        }
        answer[0] += x;
        answer[1] += y;
        
        return answer;
    }
}