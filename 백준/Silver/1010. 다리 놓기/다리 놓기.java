
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int V;
    static int[][] dp = new int[30][30];
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        V = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        for (int i = 0; i < V; i++) {
            st = new StringTokenizer(br.readLine());
            sb.append(build(Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken()))).append("\n");
        }

        System.out.println(sb);
    }
    static int build(int x, int y){
        if(dp[y][x] > 0 ) return dp[y][x];
        if ( y == x || x == 0) return dp[y][x] = 1;
        dp[y][x] = build(x-1,y-1) + build(x, y-1);
        return dp[y][x];
    }
}
