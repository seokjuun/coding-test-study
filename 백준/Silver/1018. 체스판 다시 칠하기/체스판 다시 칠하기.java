
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N,M,min = Integer.MAX_VALUE;
    static char[][] map;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new char[N][];
        for (int i = 0; i < N; i++) {
            map[i] = br.readLine().toCharArray();
        }

        for (int i = 0; i < N-7; i++) {
            for (int j = 0; j < M-7; j++) {
                check(map[i][j], i,j); // 시작점
            }
        }
        System.out.println(min);
    }

    static void check(char start, int y, int x){
        int count=0;
        int a = y%2;
        int b = x%2;
        int count2=0;

        for (int i = y; i <y+8 ; i++) {
            for (int j = x; j < x+8; j++) {
                if((i%2 == a && j%2== b) || (i%2 != a && j%2 != b)){
                    if(map[i][j] != start){
                        count++;
                    } else {
                        count2++;
                    }

                } else{
                    if(map[i][j] == start){
                        count++;
                    } else {
                        count2++;
                    }
                }
            }
        }


        min = Math.min(min, Math.min(count, count2));
    }
}
