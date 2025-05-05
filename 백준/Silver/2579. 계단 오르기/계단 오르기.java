
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] score = new int[N+1];
        int[] dp = new int[N+1];

        for (int i = 1; i < N+1; i++) {
            score[i] = Integer.parseInt(br.readLine());
        }

        if (N == 1) {
            System.out.println(score[1]);
            return;
        }

        dp[1] = score[1];
        dp[2] = dp[1] + score[2];
        
        for (int i = 3; i < N+1; i++) {
            dp[i] = Math.max(dp[i-2], dp[i-3]+score[i-1]) + score[i];
        }
        
        System.out.println(dp[N]);
    }
}
