
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N, M;
    static int[] X;

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine()); // 굴다리 길이
        M = Integer.parseInt(br.readLine()); // 가로등 수
        StringTokenizer st = new StringTokenizer(br.readLine());
        X = new int[M]; // 위치

        int gap =0;
        for (int i = 0; i < M; i++) {
            X[i] = Integer.parseInt(st.nextToken());

            if (i >0){
                if( ((X[i]-X[i-1])%2) ==1){
                    gap = Math.max(gap, (X[i]-X[i-1])/2+1);
                } else {
                    gap = Math.max(gap, (X[i]-X[i-1])/2);
                }
            }
        }

        int side = Math.max(X[0], N - X[M-1]); // 0 지점과 끝 지점을 비추도록


        System.out.println(Math.max(side, gap));
    }
}