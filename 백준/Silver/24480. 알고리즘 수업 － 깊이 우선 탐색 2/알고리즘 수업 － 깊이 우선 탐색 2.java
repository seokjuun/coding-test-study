import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    static int N,M,R,count=1;
    static int[] visited;
    static List<List<Integer>> list = new ArrayList<>();
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());
        visited = new int[N+1];
        // 1 시작
        for (int i = 0; i < N+1; i++) {
            list.add(new ArrayList<>());
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            list.get(a).add(b);
            list.get(b).add(a);
        }

        for (int i = 1; i < list.size(); i++) {
            Collections.sort(list.get(i), (e1,e2)-> e2-e1);
        }

        dfs(R);

        for (int i = 1; i < N+1; i++) {
            sb.append(visited[i]).append("\n");
        }
        System.out.println(sb);
    }

    static void dfs(int n){
        visited[n] = count++;

        List<Integer> nodes = list.get(n);
        for (int i = 0; i < nodes.size(); i++) {
            if (visited[nodes.get(i)] == 0){
                dfs(nodes.get(i));
            }
        }
    }
}
