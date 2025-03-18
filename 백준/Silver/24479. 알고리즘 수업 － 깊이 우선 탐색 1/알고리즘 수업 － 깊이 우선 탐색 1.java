
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N,M,R,cnt =1;;
    static List<List<Integer>> list;
    static int[] visited;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken()); // 정점
        M = Integer.parseInt(st.nextToken()); // 간선
        R = Integer.parseInt(st.nextToken()); // 시작 정점

        // 방문배열
        visited = new int[N+1];
        // 인접리스트 (1스타트)
        list = new ArrayList<>();
        for (int i = 0; i < N+1; i++) {
            list.add(new ArrayList<>());
        }
        // 리스트에 간선 정보 추가
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            list.get(a).add(b);
            list.get(b).add(a);
        }
        // 리스트 오름차순 정렬
        for (List<Integer> nodes : list) {
            Collections.sort(nodes);
        }

        dfs(R);
        for (int i = 1; i < visited.length; i++) {
            sb.append(visited[i]).append("\n");
        }
        System.out.println(sb);
    }

    static void dfs(int n){
        // 1. 방문체크
        visited[n] = cnt++;

        // 2. 오름차순으로 방문
        List<Integer> nodes = list.get(n);
        for (Integer node : nodes) {
            if(visited[node]==0) dfs(node);
        }
    }
}
