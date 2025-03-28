

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N,M;
    static StringBuilder sb = new StringBuilder();
    static int[] tgt;
    static boolean[] src;

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        tgt = new int[M];
        src = new boolean[N + 1];

        back(0);
        System.out.println(sb);
    }

    static void back(int tgtIdx){
        if (tgtIdx == M){
            for (int t : tgt){
                sb.append(t+" ");
            }
            sb.append("\n");
            return;
        }

        for (int i = 1; i <= N; i++) {
            if(!src[i]){
                src[i] = true;
                tgt[tgtIdx] = i;
                back(tgtIdx+1);
                src[i] = false;
            }
        }
    }
}
