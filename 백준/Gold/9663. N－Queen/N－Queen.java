

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    static int N, count =0;
    static int[] tgt;
    static boolean[] visited;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        tgt = new int[N];
        visited = new boolean[N];
        queen(0);
        System.out.println(count);
    }

    static void queen(int tgtIdx){
        if(tgtIdx == N){
            count++;
            return;
        }
        for (int i = 0; i < N; i++) {
            if (visited[i]) continue;

            boolean can = true;
            for (int j = 0; j < tgtIdx; j++) {
                if (Math.abs(tgtIdx - j) == Math.abs(i - tgt[j])) {
                    can = false;
                    break;
                }
            }

            if (!can) continue;

            tgt[tgtIdx] = i;
            visited[i] = true;
            queen(tgtIdx+1);
            visited[i] = false;
        }
    }
}
