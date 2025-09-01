
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N;
    static ArrayList<Integer>[] arr;
    static boolean[] visited;
    static int[] parent;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new ArrayList[N+1];
        visited = new boolean[N+1];
        parent = new int[N+1];

        for (int i = 1; i < arr.length; i++) {
            arr[i] = new ArrayList<>();
        }

        for (int i = 1; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            arr[a].add(b);
            arr[b].add(a);
        }

        bfs(1);

        StringBuilder sb = new StringBuilder();
        for (int i = 2; i < N+1; i++) {
            sb.append(parent[i]).append("\n");
        }
        System.out.println(sb);
    }

    static void bfs(int n){
        Deque<Integer> queue = new ArrayDeque<>();
        visited[n] = true;
        queue.push(n);

        while (!queue.isEmpty()){
            int poll = queue.poll();
            for(int num : arr[poll]){
                if (visited[num]) continue;

                visited[num] = true;
                queue.push(num);
                parent[num] = poll;
            }
        }
    }
}
