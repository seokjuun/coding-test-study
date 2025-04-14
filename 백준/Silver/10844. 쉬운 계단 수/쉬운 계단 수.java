

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        long[][] dp = new long[N+1][10];
        for (int i = 1; i < 10; i++) {
            dp[1][i] = 1;
        }

        if (N==1){
            System.out.println(9);
        } else{
            for (int i = 2; i < N+1; i++) {
                for (int j = 1; j < 9; j++) {
                    dp[i][j] = (dp[i-1][j-1] + dp[i-1][j+1])%1000000000;
                }
                dp[i][0] = dp[i-1][1]%1000000000;
                dp[i][9] = dp[i-1][8]%1000000000;
            }

            long total =0;
            for (int i = 0; i < 10; i++) {
                total = (total+dp[N][i])%1000000000;
            }
            System.out.println(total);
        }


    }
}
