import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    static int N;
    static int[][] map;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        map = new int[N][N];


        for (int i = 0; i < N; i++) {
            String str = br.readLine();
            for (int j = 0; j < N; j++) {
                map[i][j] = str.charAt(j)-'0';
            }
        }


        findSquare(N,0,0);
        System.out.println(sb);
    }

    static void findSquare(int len, int y, int x){
        if (!isSquare(len, y, x)){
            sb.append("(");
            findSquare(len/2,y,x);
            findSquare(len/2,y,x+len/2);
            findSquare(len/2,y+len/2,x);
            findSquare(len/2,y+len/2,x+len/2);

            sb.append(")");
        }
    }

    static boolean isSquare(int len, int y, int x){
        int num = map[y][x];
        for (int i = y; i < y+len; i++) {
            for (int j = x; j < x+len; j++) {
                if(map[i][j] != num) return false;
            }
        }
        sb.append(num);
        return true;
    }
}
