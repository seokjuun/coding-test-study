
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int N,K,count=0;
    static boolean[] visited = new boolean[100001];
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        // N -> K
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        bfs(N);
    }

    static void bfs(int n){
        Queue<int[]> queue = new ArrayDeque<>();
        queue.offer(new int[]{n, 0});
        visited[n] = true;

        while (!queue.isEmpty()){
            int[] arr = queue.poll();
            int num = arr[0];
            int c = arr[1];

            if (num == K) {
                System.out.println(c);
                return;
            }

            if (num - 1 >= 0 && !visited[num - 1]) {
                visited[num - 1] = true;
                queue.offer(new int[]{num - 1, c + 1});
            }

            if (num + 1 <= 100000 && !visited[num + 1]) {
                visited[num + 1] = true;
                queue.offer(new int[]{num + 1, c + 1});
            }

            if (num * 2 <= 100000 && !visited[num * 2]) {
                visited[num * 2] = true;
                queue.offer(new int[]{num * 2, c + 1});
            }
        }
    }
}
