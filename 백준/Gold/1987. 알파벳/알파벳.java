
import java.io.BufferedReader;
import java.io.InputStreamReader;

import java.util.StringTokenizer;

public class Main {
    static int R;
    static int C;
    static int max;

    static char[][] board;
    static boolean[] visited = new boolean[26];
    static int[] dy = { -1, 1, 0, 0};
    static int[] dx = { 0, 0, -1, 1};

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        board = new char[R][];
        for (int i = 0; i < R; i++) {
            board[i] = br.readLine().toCharArray();
        }
        visited[board[0][0]-'A'] = true;
        dfs(0,0,1);
        System.out.println(max);
    }

    static void dfs(int y, int x, int count){
        if (count > max) {
            max = count;
        }
        //
        for (int i = 0; i < 4; i++) {
            int ny = y + dy[i];
            int nx = x + dx[i];

            if(ny <0 || ny>=R || nx<0|| nx>=C) continue;

            if(!visited[board[ny][nx]-'A']){
                visited[board[ny][nx]-'A'] = true;
                dfs(ny,nx, count+1);
                visited[board[ny][nx]-'A'] = false;
            }
        }

    }
}
