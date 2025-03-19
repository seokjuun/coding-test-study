
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N,M,R, count=1;
    static List<List<Integer>> list = new ArrayList<>();
    static int[] visited;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());
        visited = new int[N+1];
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

        for (List<Integer> nodes : list) {
            nodes.sort((e1,e2)->e1-e2);
        }

        bfs(R);
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i < N+1; i++) {
            sb.append(visited[i]).append("\n");
        }
        System.out.println(sb);
    }
    static void bfs(int n){
        visited[n] = count++;
        Queue<Integer> queue = new ArrayDeque<>();
        queue.offer(n);

        while (!queue.isEmpty()){
            int poll = queue.poll();
            List<Integer> nodes = list.get(poll);
            for (int node : nodes){
                if(visited[node] == 0){
                    visited[node] = count++;
                    queue.offer(node);
                }
            }
        }
    }
}
