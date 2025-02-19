import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N,M,r,c,d,count;
    static int[] dy ={-1,0,1,0};
    static int[] dx ={0,1,0,-1};
    static boolean[][] room;
    static boolean[][] visited;

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        room = new boolean[N][M];
        visited = new boolean[N][M];

        st = new StringTokenizer(br.readLine());
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        d = Integer.parseInt(st.nextToken());

        // 룸에서 벽이면 트루
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                room[i][j] = st.nextToken().equals("1");
            }
        }

        // 일단 처음 좌표 청소해주고~
        visited[r][c] = true;
        count =1;
        findClean(r,c,d);
        System.out.println(count);
    }

    static void findClean(int y, int x, int d) {
        for (int i = 0; i < 4; i++) {
            int nd = (d+3)%4;
            int ny = y + dy[nd];
            int nx = x + dx[nd];

            if (!room[ny][nx] && !visited[ny][nx]){ // 청소되는곳이면?
                goClean(ny,nx,nd); // 고클린
                return; // 이 자리에선 더 찾지마
            }
            d = nd; // 방향 바꿔주고
        }
        // 못움직이면?
        cantMove(y,x,d);

    }

    static void cantMove(int y, int x, int d){
        int nd = (d+2)%4; // 후진방향
        int ny = y+dy[nd];
        int nx = x+dx[nd];

        // 후진 1칸
        if(room[ny][nx]){
            return;
        } else {
            // 후진되면
            findClean(ny,nx,d);
        }
    }

    static void goClean(int y, int x, int d){

        visited[y][x] = true;
        count++;
        findClean(y,x,d); // 클린하고 다시찾아
    }
}
