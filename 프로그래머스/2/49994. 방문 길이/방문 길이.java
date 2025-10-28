import java.util.*;

class Solution {
    public int solution(String dirs) {
        
        Map<Character, int[]> map = new HashMap<>();
        map.put('U', new int[]{-1,0});
        map.put('D', new int[]{1,0});
        map.put('L', new int[]{0,-1});
        map.put('R', new int[]{0,1});
        
        int y = 5;
        int x = 5;
        
        Set<String> set = new HashSet<>();
        
        for(int i =0; i<dirs.length(); i++){
            char dir = dirs.charAt(i);
            int[] location = map.get(dir);
            int ny = y + location[0];
            int nx = x + location[1];
            
            if(ny <0 || ny>10 || nx<0 || nx>10){
                continue;
            }    
            
            set.add(y + " " + x + " " + ny + " " + nx);
            set.add(ny + " " + nx + " " + y + " " + x);
            y = ny;
            x = nx;
        }
        
        return set.size()/2;
        
    }
}