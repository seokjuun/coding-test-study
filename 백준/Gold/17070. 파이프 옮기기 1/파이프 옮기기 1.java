import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N,count;
    static int[][] map;

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        map = new int[N][N];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        count =0;
        dfs(0,1, 0); // x , y, 이동방법
        System.out.println(count);
    }

    static void dfs(int y, int x, int d){
        // 끝에 도착하면?
        if(y==N-1 && x==N-1){
            count ++;
            return;
        }
        // 가로로 움직일때
        if (d == 0 || d == 2) {
            if (x + 1 < N && map[y][x + 1] == 0) {
                dfs(y, x + 1, 0);
            }
        }
        // 세로로
        if (d == 1 || d == 2) {
            if (y + 1 < N && map[y + 1][x] == 0) {
                dfs(y + 1, x, 1);
            }
        }
        // 대각
        if (x + 1 < N && y + 1 < N) { // 범위 확인 먼저
            if (map[y][x + 1] == 0 && map[y + 1][x] == 0 && map[y + 1][x + 1] == 0) {
                dfs(y + 1, x + 1, 2);
            }
        }

    }

}
