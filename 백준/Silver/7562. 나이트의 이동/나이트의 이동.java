
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int I, goalY, goalX;
    static boolean[][] visited;
    static int[] dy = {-2, -2, 2, 2, -1, 1, -1, 1};
    static int[] dx = {-1, 1, -1, 1, -2, -2, 2, 2};

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());

        for (int t = 0; t < T; t++) {
            I = Integer.parseInt(br.readLine());
            visited = new boolean[I][I]; 

            st = new StringTokenizer(br.readLine());
            int startY = Integer.parseInt(st.nextToken());
            int startX = Integer.parseInt(st.nextToken());

            st = new StringTokenizer(br.readLine());
            goalY = Integer.parseInt(st.nextToken());
            goalX = Integer.parseInt(st.nextToken());

            System.out.println(bfs(startY, startX));
        }
    }

    static int bfs(int y, int x) {
        if (y == goalY && x == goalX) return 0;

        Queue<int[]> queue = new ArrayDeque<>();
        queue.offer(new int[]{y, x, 0});
        visited[y][x] = true;

        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int cy = current[0];
            int cx = current[1];
            int cnt = current[2];

            for (int i = 0; i < 8; i++) {
                int ny = cy + dy[i];
                int nx = cx + dx[i];

                if (isInBounds(ny, nx) && !visited[ny][nx]) {
                    if (ny == goalY && nx == goalX) return cnt + 1; 
                    visited[ny][nx] = true;
                    queue.offer(new int[]{ny, nx, cnt + 1});
                }
            }
        }

        return -1; 
    }

    static boolean isInBounds(int y, int x) {
        return y >= 0 && y < I && x >= 0 && x < I;
    }
}