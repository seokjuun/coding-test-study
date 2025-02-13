
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;


public class Main {
    static int N;
    static int[][] map; // 맵 배열
    static boolean[][] visit;

    // 상하좌우
    static int[] dy = { -1, 1,  0, 0 };
    static int[] dx = {  0, 0, -1, 1 };

    // 단지 크기 저장
    static List<Integer> danjiList = new ArrayList<>();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine()); // 지도 크기 입력
        visit = new boolean[N+1][N+1];
        map = new int[N+1][N+1];

        // 맵 배열에 수 집어넣기 ( 0 더미 )
        for (int i = 1; i <= N; i++) {
            String line = br.readLine();
            for (int j = 1; j <= N ; j++) {
                map[i][j] = line.charAt(j-1) -'0';
            }
        }
        // 배열을 돌다가
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N ; j++) {
                if(map[i][j] == 1 && !visit[i][j]){
                    int danjiSize = dfs(i ,j);
                    danjiList.add(danjiSize);
                }
            }
        }

        Collections.sort(danjiList);
        System.out.println(danjiList.size());
        for (int i=0; i<danjiList.size(); i++){
            System.out.println(danjiList.get(i));
        }

        br.close();
    }

    static int dfs(int y, int x){
        visit[y][x] = true;
        int count = 1;

        for(int d= 0; d<4; d++){
            int ny = y+dy[d];
            int nx = x+dx[d];

            if(ny < 1||nx<1||ny>N||nx>N||visit[ny][nx]) continue;

            if(map[ny][nx] == 1){

                count += dfs(ny ,nx);
            }
        }
        return count;

    }
}


