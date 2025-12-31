
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {


    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[] day = new int[N+1];
        int[] price = new int[N+1];
        int[] dp = new int[N+2];

        for(int i =1; i<N+1; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            day[i] = Integer.parseInt(st.nextToken());
            price[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = N; i >= 1; i--) {
            if (i + day[i] <= N + 1) {
                dp[i] = Math.max(price[i] + dp[i+day[i]], dp[i+1]);
            } else {
                dp[i] = dp[i+1];
            }
        }

        System.out.println(dp[1]);
    }

}
