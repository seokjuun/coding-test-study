
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int T,M,N,K;
    static StringTokenizer st;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static int[] dy = {-1,1,0,0}; // 상하좌우
    static int[] dx = {0,0,-1,1};

    public static void main(String[] args) throws Exception{
        T = Integer.parseInt(br.readLine()); // 테케
        for (int i = 0; i < T; i++) {
            st = new StringTokenizer(br.readLine());
            M = Integer.parseInt(st.nextToken()); // 가로
            N = Integer.parseInt(st.nextToken()); // 세로
            K = Integer.parseInt(st.nextToken()); // 배추 개수
            boolean[][] map = new boolean[M][N];
            makeMap(M,N,K,map); // 맵
            moveWorm(M,N,map);
        }

        System.out.println(sb);
    }

    static void makeMap(int M, int N, int K, boolean[][] map) throws Exception{
        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            map[a][b] = true;
        }
    }

    static void moveWorm(int M, int N, boolean[][] map){
        int count = 0;
        boolean[][] visited = new boolean[M][N];
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                if(map[i][j] && !visited[i][j]){
                    count++;
                    check(i,j,map,visited);
                }
            }
        }
        sb.append(count).append("\n");
    }

    static void check(int y, int x, boolean[][] map, boolean[][] visited){
        visited[y][x] = true;
        for (int i = 0; i < 4; i++) {
            int yy = y + dy[i];
            int xx = x + dx[i];

            if(yy>=M || xx>=N || yy<0 || xx<0) continue;

            if(map[yy][xx] && !visited[yy][xx]){
                check(yy,xx,map,visited);
            }
        }
    }
}
