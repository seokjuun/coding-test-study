import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int n,m;
    static int[][] board;
    static int[][] check;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        board = new int[n][m];
        check = new int[n][m];
        int max=0;

        for (int i = 0; i < n; i++) {
            String input = br.readLine();
            for (int j = 0; j < m; j++) {
                board[i][j] = input.charAt(j) -'0';
                check[i][j] = board[i][j];
                max = Math.max(max, check[i][j]);
            }
        }



        for (int i = 1; i < n; i++) {
            for (int j = 1; j < m; j++) {
                if(board[i][j]==1){
                    check[i][j] = Math.min(Math.min(check[i][j-1],check[i-1][j]),check[i-1][j-1]) + 1;
                    if (check[i][j]>max) max = check[i][j];
                }
            }
        }

        System.out.println(max*max);
    }
}
