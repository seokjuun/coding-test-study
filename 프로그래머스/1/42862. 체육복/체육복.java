class Solution {
    public int solution(int n, int[] lost, int[] reserve) {
        int can = n - lost.length; // 현재 가능한 인원
        
        int[] arr = new int[n]; // 0: 있어 1:없어 2:여분있어
        for(int l : lost){
            arr[l-1] = 1;
        }
        
        for(int r : reserve){
            if(arr[r-1] == 1){
                arr[r-1] = 0;
                can++;
                continue;
            }
            arr[r-1] = 2;
        }
          
        for(int i =0; i<n; i++){
            if(arr[i] == 0){
                continue;
            } else if(arr[i] == 2 && i+1<n && arr[i+1] == 1){
                arr[i] = 0;
                arr[i+1] = 0;
                can++;
            } else if(arr[i] == 1 && i+1<n &&  arr[i+1]==2){
                arr[i] = 0;
                arr[i+1] = 0;
                can++;
            }
        }
        
        return can;
    }
}