class Solution {
    static int N,w;
    static int[] weak2;
    static int[] perm;
    static boolean[] visited;
    static int answer;
    
    public int solution(int n, int[] weak, int[] dist) {
        answer = 100;
        N = n;
        w = weak.length;
        perm = new int[dist.length];
        visited = new boolean[dist.length];
        
        // 약점 펼치기... 이어지도록
        weak2 = new int[weak.length * 2];
        for(int i =0; i< weak.length; i++){
            weak2[i] = weak[i];
            weak2[i+weak.length] = weak[i] + n;
        }
        
        // 스타트 지점 정하고 친구들 순열만들기
        for(int i = 0; i < weak.length; i++){
            makePerm(weak, dist, 0, i);
        }
        
        if(answer == 100) return -1;
        
        return answer;
    }
    
    static void makePerm(int[] weak, int[] dist, int depth, int start){
        
        // 기저
        if(depth == dist.length){ // 순열 완성됐다면
            check(weak, dist, start); // 필요한 친구 수 구하기
            return;
        }
        
        // 백트래킹
        for(int i =0; i<dist.length; i++){
            if(visited[i]) continue;
            visited[i] = true;
            perm[depth] = dist[i];
            makePerm(weak, dist, depth+1, start);
            visited[i] = false;
        }
    }
    
    static void check(int[] weak, int[] dist, int start){ // start에서 부터 시작할때 perm 으로 친구들을 넣으면?
        int idx = start; // 시작 약점
        int endIdx = start + weak.length -1; // 이어진 약점 제일 끝, 뭔말알?
        
        for(int i =0; i<perm.length; i++){ // 친구들 하나씩 넣기
            // weak[idx] 에 perm[i] 를 더함
            // 이 값이 weak2[idx] 값보다 작아질때까지 idx를 더함
            // (성공조건) 만약 idx가 endIdx 보다 같거나 커진다면 그때의 i+1 값이 count
            // i+1이랑 answer랑 비교 후 리턴?
            if(i+1 >= answer) return;
            
            int cover = weak2[idx] + perm[i]; // 여기까지 커버함
            while(idx <= endIdx && cover >= weak2[idx]){
                idx++;
            }
            
            if(idx > endIdx){
                answer = Math.min(answer, i +1);
                return;
            }
            
        }
    }
    
    
    
    
    
    
    
    
    
}