import java.util.*;

class Solution {
    static int[] arr;
    
    public int solution(int n, int[][] costs) {
        // cost[i] [0] 섬 [1] 섬 [2] 비용
        
        Arrays.sort(costs, (a,b) ->{
            if(a[2] == b[2]){
                if(a[0] == b[0]){
                    return a[1] - b[1];
                } else return a[0] - b[0];
            }
            return a[2] - b[2];
        });
        
        
        
        arr = new int[n];
        for(int i=0; i<n; i++){
            arr[i] = i;
        }
        int count = 0;
        int value = 0;
        
        for(int i=0; i<costs.length; i++){
            int x = costs[i][0];
            int y = costs[i][1];
            
            // 사이클 생기는지 확인, 포함안된다면 추가
            if(find(x) != find(y) ){
                arr[find(y)] = find(x);
                System.out.println("1. 현재 밸류 : " + value);
                value += costs[i][2];
                count++;
                
                System.out.println("2. 더하는 밸류 : " + costs[i][2]);
                System.out.println("3. 현재 밸류 : " + value);
                System.out.println("----");
            }
            
            // 만약 간선개수가 n-1이면 break;
            if(count == n-1) break;
        }
        
        
        return value;
    }
    
    static int find(int n){ // 루트 확인
        if(arr[n] == n){
            return n;
        }
        
        int root = find(arr[n]);
        arr[n] = root;
        
        return root;
    }
    
}