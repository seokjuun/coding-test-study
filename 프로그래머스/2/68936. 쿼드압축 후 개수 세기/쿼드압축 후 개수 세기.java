class Solution {
    
    static int[][] map;
    static int zero =0;
    static int one =0;
    
    public int[] solution(int[][] arr) {
        int[] answer = {};
        
        map = arr.clone();
        check(arr.length, 0, 0); 
        
        return new int[]{zero, one};
    }
    
    static void check(int n, int y, int x){
        // 기저
        if(n==1){
            if(map[y][x] == 1){
                one+=1;
            } else{
                zero+=1;
            }
            return;
        }
        // 다 같으면
        if(isSame(n,y,x)){
            if(map[y][x] == 1){
                one+=1;
            } else{
                zero+=1;
            }
        } else{// 4분할
            check(n/2, y,x);
            check(n/2, y+n/2,x);
            check(n/2, y,x+n/2);
            check(n/2, y+n/2, x+n/2);
        }
    
    }
    
    static boolean isSame(int n, int y, int x){
        
        int num = map[y][x];
        for(int i = y; i< y+n; i++){
            for(int j = x; j< x+n; j++){
                if(map[i][j] != num) return false;
            }
        }
        
        
        return true;
    }
}