
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        int[] degree = new int[N+1];

        for (int i = 0; i < N - 1; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            degree[a]++;
            degree[b]++;
        }

        int q = Integer.parseInt(br.readLine());

        for (int i = 0; i < q; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int t = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken());
            
            if (t == 1) { // 단절점 판별
                sb.append(degree[k] >= 2 ? "yes" : "no").append('\n');
            } else {      // 단절선 판별
                sb.append("yes").append('\n');
            }
        }
        System.out.print(sb);
    }

}
