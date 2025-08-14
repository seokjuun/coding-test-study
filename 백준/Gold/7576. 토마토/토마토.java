
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int M,N;
    static int count;
    static int[] dy = {1,-1,0,0};
    static int[] dx = {0,0,-1,1};
    static int[][] map;
    static Queue<Node> queue = new ArrayDeque<>();


    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        map = new int[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                int num = Integer.parseInt(st.nextToken());
                map[i][j] = num;
                if (num == 1) queue.offer(new Node(i,j));
            }
        }

        bfs();

        System.out.println(check());
    }

    static void bfs(){
        while (!queue.isEmpty()){
            Node poll = queue.poll();

            for (int i = 0; i < 4; i++) {
                int y = poll.y + dy[i];
                int x = poll.x + dx[i];

                if ( y<0 || x<0 || y>=N || x>=M ) continue;
                if (map[y][x] != 0) continue;

                map[y][x] = map[poll.y][poll.x] + 1;
                queue.offer(new Node(y,x));
            }
        }
    }

    static int check(){
        int num =1;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (map[i][j] == 0) return -1;
                num = Math.max(num,map[i][j]);
            }
        }

        return num-1;
    }
}

class Node {
    int y,x;
    public Node(int y, int x) {
        this.y = y;
        this.x = x;
    }
}
