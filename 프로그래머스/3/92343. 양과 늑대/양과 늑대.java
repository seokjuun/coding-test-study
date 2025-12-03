import java.util.*;

class Solution {
    
    static List<Integer>[] tree;
    static int maxSheep = 0;
    
    public int solution(int[] info, int[][] edges) {
        
        // 트리 만들기
        tree = new ArrayList[info.length];
        for(int i=0; i<info.length; i++){
            tree[i] = new ArrayList<>();
        }
        
        for(int[] edge : edges){
            tree[edge[0]].add(edge[1]);
        }
        
        // 양, 늑대, 후보 모든 경우 싹 다 비교?
        List<Integer> canGo = new ArrayList<>();
        canGo.add(0);
        // 찾아라
        dfs(0,0, canGo, info);
        
        return maxSheep;
    }
    
    private void dfs(int sheep, int wolf, List<Integer> canGo, int[] info){
        maxSheep = Math.max(maxSheep, sheep);
        
        for(int i=0; i<canGo.size(); i++){
            int node = canGo.get(i); // 후보 노드 번호
            int nextSheep = sheep;
            int nextWolf = wolf;
            
            if(info[node] == 0){ 
                nextSheep++;
            } else {
                nextWolf++;
            }
            
            if(nextSheep <= nextWolf) continue; // 넘겨잇
            
            List<Integer> nextCanGo = new ArrayList<>(canGo);
            nextCanGo.remove(i); // 이동 후 후보에서 삭제 후 dfs
            
            for(int j : tree[node]){
                nextCanGo.add(j);
            }
            
            dfs(nextSheep, nextWolf, nextCanGo, info);
        }

    }
}