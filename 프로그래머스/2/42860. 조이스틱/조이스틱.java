class Solution {
    public int solution(String name) {
        int answer = 0;
        
        // 변경
        for(int i=0; i<name.length(); i++){
            char c = name.charAt(i);
            
            int up = c - 'A';
            int down = 'Z' - c + 1;
            answer += Math.min(up, down);
        }
        
        // 이동
        int move = name.length() -1;
        
        for(int i =0; i< name.length(); i++){
            // a뭉치들 끝부분
            int eIdx = i+1;
            while(eIdx< name.length() && name.charAt(eIdx) == 'A'){
                eIdx++;
            }
            
            int right = 2*i + (name.length()-eIdx); // 오른쪽부터
            int left = (name.length() - eIdx) * 2 + i;
            
            move = Math.min(move, Math.min(right, left));
            
        }
        

        return answer+ move;
    }
    
}