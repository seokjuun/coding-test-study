

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int N,M;
    static int[][] map;
    static int[] my = {-1,1,0,0};
    static int[] mx = {0,0,-1,1};
    static boolean[][][] visited;


    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        visited = new boolean[N][M][2];

        for (int i = 0; i < N; i++) {
            String str = br.readLine();
            for (int j = 0; j < M; j++) {
                map[i][j] = str.charAt(j) - '0';
            }
        }
        visited[0][0][1] = true;
        bfs(0,0,1,1);
    }

    static void bfs(int y, int x, int wall, int count){
        Queue<int[]> queue = new ArrayDeque<>();
        queue.offer(new int[]{y,x,wall,count});

        while (!queue.isEmpty()){
            int[] arr = queue.poll();

            if(arr[0] == N-1 && arr[1] == M-1) {
                System.out.println(arr[3]);
                return;
            }

            for (int i = 0; i < 4; i++) {
                int dy = arr[0] + my[i];
                int dx = arr[1] + mx[i];

                if(dy < 0 || dx <0 || dy >= N || dx >= M ) continue;

                if(map[dy][dx] == 1 && arr[2] == 1 && !visited[dy][dx][0]){
                    queue.offer(new int[]{dy,dx,0,arr[3]+1});
                    visited[dy][dx][0] = true;
                } else if(map[dy][dx] ==0 && !visited[dy][dx][arr[2]]){
                    queue.offer(new int[]{dy,dx,arr[2],arr[3]+1});
                    visited[dy][dx][arr[2]] = true;
                }
            }
        }

        System.out.println(-1);
    }

}
