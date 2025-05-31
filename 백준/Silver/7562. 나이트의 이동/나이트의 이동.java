
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int N,I,goalY,goalX;
    static boolean[][] visited;

    static int[] dy = {-2,-2,2,2,-1,1,-1,1};
    static int[] dx = {-1,1,-1,1,-2,-2,2,2};


    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        N = Integer.parseInt(br.readLine()); // 테스트 케이스 수

        for (int i = 0; i < N; i++) {
            I = Integer.parseInt(br.readLine()); // 체스판 한 변의 길이
            visited = new boolean[I][I]; // 체스판

            st = new StringTokenizer(br.readLine());
            int y = Integer.parseInt(st.nextToken()); // 현재
            int x = Integer.parseInt(st.nextToken());

            st = new StringTokenizer(br.readLine());
            goalY = Integer.parseInt(st.nextToken()); // 목적지
            goalX = Integer.parseInt(st.nextToken());

            sb.append(bfs(y,x)).append("\n");
        }
        System.out.println(sb);
    }

    static int bfs(int y, int x){
        if (y == goalY && x == goalX) return 0;

        visited[y][x] = true;
        Queue<int[]> queue = new ArrayDeque<>();
        queue.offer(new int[]{y,x,0});

        while (!queue.isEmpty()){
            int[] poll = queue.poll();
            int count = poll[2];

            for (int i = 0; i < 8; i++) {
                int my = poll[0] + dy[i];
                int mx = poll[1] + dx[i];

                if (my >= 0 && my < I && mx >= 0 && mx < I && !visited[my][mx]){
                    if(my == goalY && mx == goalX){
                        return count+1;
                    }

                    visited[my][mx] = true;
                    queue.offer(new int[]{my,mx,count+1});
                }
            }
        }
        return -1;
    }
}
