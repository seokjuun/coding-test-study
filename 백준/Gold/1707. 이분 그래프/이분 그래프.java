

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    static int K;
    static List<List<Integer>> list;
    static int[] visited;
    static boolean tf;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        K = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < K; i++) {
            // 정점 간선 개수 입력
            StringTokenizer st = new StringTokenizer(br.readLine());
            int V = Integer.parseInt(st.nextToken());
            int E = Integer.parseInt(st.nextToken());
            visited = new int[V+1];

            // 인접 리스트 선언
            list = new ArrayList<>();
            for (int j = 0; j < V+1; j++) {
                list.add(new ArrayList<>());
            }
            // 인접 리스트 입력
            for (int j = 0; j < E; j++) {
                st = new StringTokenizer(br.readLine());
                int u = Integer.parseInt(st.nextToken());
                int v = Integer.parseInt(st.nextToken());
                list.get(u).add(v);
                list.get(v).add(u);
            }

            tf = true;
            for (int j = 0; j < V; j++) {
                if (visited[j+1] ==0){
                    dfs(j+1,1);
                }
            }
            sb.append(tf ? "YES":"NO").append("\n");
        }
        System.out.println(sb);
    }


    static void dfs(int n, int team){
        if (!tf) return;
        visited[n] = team;

        List<Integer> nodes = list.get(n);
        for (int node : nodes) {
            if (visited[node] == 0){
                dfs(node, -team); // 팀 뒤집어서 저장
            } else if(visited[node] == team){
                tf = false;
                return;
            }
        }
    }
}
