class Solution {
    public int[] solution(int[] arr) {
        int first= -1;
        int last= -1;
        for(int i=0; i<arr.length; i++){
            if(arr[i]==2&&first==-1){
                first = i;
                last = i;
            } else if(arr[i] ==2){
                last = i;
            } 
        }
        
        if(first == -1){
            int[] answer = {-1};
            return answer; 
        }
        
        int[] answer = new int[last-first+1];
        for(int i=first; i<=last; i++){
            answer[i-first] = arr[i]; 
        }
        
        
        return answer;
    }
}