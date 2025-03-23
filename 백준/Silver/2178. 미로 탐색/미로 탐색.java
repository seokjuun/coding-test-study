

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int N,M;
    static int[][] map;
    static boolean[][] visited;
    static int[] dy = {-1,1,0,0};
    static int[] dx = {0,0,-1,1};

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        visited = new boolean[N][M];

        for (int i = 0; i < N; i++) {
            String str = br.readLine();
            for (int j = 0; j < M; j++) {
                map[i][j] = str.charAt(j)-'0';
            }
        }

        bfs(0,0,1);
    }

    static class Node {
        int y;
        int x;
        int count;

        public Node(int y, int x, int count) {
            this.y = y;
            this.x = x;
            this.count = count;
        }
    }

    static void bfs(int y, int x, int count){
        Queue<Node> queue = new ArrayDeque<>();
        queue.offer(new Node(y,x,count));
        visited[y][x] = true;


        while (!queue.isEmpty()){
            Node node = queue.poll();
            if(node.y==N-1 && node.x==M-1){
                System.out.println(node.count);
                return;
            }

            for (int i = 0; i < 4; i++) {
                int yy = node.y + dy[i];
                int xx = node.x + dx[i];

                if(yy <0 || xx <0 || yy>N-1 || xx >M-1 || visited[yy][xx]|| map[yy][xx] ==0) continue;
                queue.offer(new Node(yy,xx,node.count+1));
                visited[yy][xx] = true;
            }
        }
    }

}
