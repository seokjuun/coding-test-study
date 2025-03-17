import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    static int N;
    static char[][] arr;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new char[N][N];
        for (int i = 0; i < N; i++) {
            Arrays.fill(arr[i], '*'); 
        }

        check(N,0,0);

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            sb.append(arr[i]).append("\n");
        }
        System.out.println(sb);
    }
    static void check(int n, int y, int x){ // 네모 크기, 시작 지점
        if(n==1) return;
        int newY = y + n/3;
        int newX = x + n/3;

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if(i==1 && j==1){
                    blank(newY,newX,n/3);
                } else {
                    check(n/3, y + i * (n/3), x + j * (n/3));
                }
            }
        }
    }
    static void blank(int y, int x, int n){
        for (int i = y; i < y+n; i++) {
            for (int j = x; j < x+n; j++) {
                arr[i][j] = ' ';
            }
        }
    }

}
