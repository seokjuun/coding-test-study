import java.util.*;

class Solution {
    static Set<Integer> set = new HashSet<>();
    static String str;
    static boolean[] visited;
    
    public int solution(String numbers) {
        // 수열 찾기 -> 수열 리스트 만들기
        str = numbers;
        visited = new boolean[numbers.length()];
        
        dfs(""); // 빈 문자열, 넘버스 인덱스
        
        // 소수 검사하기
        if(set.isEmpty()) return 0;
        int cnt = 0;
        for(Integer i : set){
            if(isPrime(i)) cnt++;
        }
        return cnt;
    }
    
    static void dfs(String s){
        if(!s.equals("")) set.add(Integer.parseInt(s));
        
        for(int i =0; i<str.length(); i++){
            if(visited[i]) continue;
            visited[i] = true;
            dfs(s+str.charAt(i));
            visited[i] = false;
            
        }
    }
    
    static boolean isPrime(int n){
        if(n<2) return false;
        for(int i=2; i<= Math.sqrt(n); i++){
            if(n%i == 0) return false;
        }
        
        return true;
    }
    
}