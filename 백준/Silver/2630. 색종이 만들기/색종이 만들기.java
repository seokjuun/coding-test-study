

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N, white =0, blue=0;
    static int[][] map;

    public static void main(String[] args) throws Exception{
        // 입력
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());
        map = new int[N][N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        findSquare(N,0,0);

        System.out.println(white);
        System.out.println(blue);
    }
    // 한 변의 길이와 좌표 받아서 모두 같은 색인지 확인
    // 같은 색이라면 해당 색 +1 해주고
    // 같은 색이 아니라면 나누기
    static void findSquare(int size, int y, int x){
        if (isSquare(size,y,x)){
            if (map[y][x] == 1){
                blue++;
            } else white++;

            return;
        }

        findSquare(size/2, y, x);
        findSquare(size/2, y, x+size/2);
        findSquare(size/2, y+size/2, x);
        findSquare(size/2, y+size/2, x+size/2);
    }


    static boolean isSquare(int size, int y, int x){
        int color = map[y][x];
        for (int i = y; i < y+size; i++) {
            for (int j = x; j < x+size; j++) {
                if (map[i][j] != color) {
                    return false;
                }
            }
        }

        return true;
    }
}
