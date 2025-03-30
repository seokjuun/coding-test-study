

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N,M;
    static int[] src;
    static int[] tgt;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        src = new int[N+1];
        for (int i = 0; i < src.length; i++) {
            src[i] = i;
        }
        tgt = new int[M];

        comb(0,1);
        System.out.println(sb);
    }

    static void comb(int tgtIdx, int srcIdx){
        if(tgtIdx==M){
            for (int t : tgt){
                sb.append(t+" ");
            }
            sb.append("\n");
            return;
        }
        if( srcIdx == src.length ) return;

        tgt[tgtIdx] = src[srcIdx];
        comb(tgtIdx+1,srcIdx+1);
        comb(tgtIdx,srcIdx+1);
    }
}
