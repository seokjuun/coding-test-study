
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N,M,K;
    static int[][] arrA;
    static int[][] arrB;

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        // 행렬 A 입력
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arrA = new int[N][M]; 
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                arrA[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // 행렬 B 입력
        st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        arrB = new int[M][K];
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < K; j++) {
                arrB[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // 행렬곱 결과
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < K; j++) {
                int sum = 0;
                for (int k = 0; k < M; k++) {
                    sum += arrA[i][k] * arrB[k][j];
                }
                sb.append(sum).append(" ");
            }
            sb.append("\n");
        }

        // 출력
        System.out.println(sb);


    }
}
