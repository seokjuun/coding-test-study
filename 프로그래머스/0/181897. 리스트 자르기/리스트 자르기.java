class Solution {
    public int[] solution(int n, int[] slicer, int[] num_list) {
        int a = slicer[0];
        int b = slicer[1];
        int c = slicer[2];
        
        int[] answer = {};
        
        switch(n){
                
            case 1:
                answer = new int[b+1];
                for (int i = 0; i <= b; i++) {
                    answer[i]=num_list[i];
                }
                break;
                
            case 2:
                answer = new int[num_list.length-a];
                for (int i = a; i < num_list.length; i++) {
                    answer[i-a]=num_list[i];
                }
                break;
                
            case 3:
                answer = new int[b-a+1];
                for (int i = a; i <= b; i++) {
                    answer[i-a]=num_list[i];
                }
                break;
                
            case 4:
                int count = 0;
                for (int i = a; i <= b; i += c) {
                    count++;
                }
                answer = new int[count];
                int index = 0;
                for (int i = a; i <= b; i += c) {
                    answer[index++] = num_list[i];
                }
                break;
        }
        return answer;
    }
}