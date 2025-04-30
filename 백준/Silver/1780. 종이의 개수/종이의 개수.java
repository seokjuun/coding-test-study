

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int[] count = new int[3];
    static int[][] map;

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        map = new int[N][N];
        StringTokenizer st;

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        countPaper(N,0,0);

        System.out.println(count[0]);
        System.out.println(count[1]);
        System.out.println(count[2]);
    }

    static void countPaper(int len, int y, int x){
        if (isSquare(len, y, x)){
            count[map[y][x]+1]++;
            return;
        }

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                countPaper(len/3, y + i*(len/3), x+ j*(len/3));
            }
        }
    }

    static boolean isSquare(int len, int y, int x){
        int num = map[y][x];
        for (int i = y; i < y+len; i++) {
            for (int j = x; j < x+len; j++) {
                if(map[i][j] != num) return false;
            }
        }
        return true;
    }
}
