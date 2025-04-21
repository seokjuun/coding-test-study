
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        long sum = 0;
        long mod;
        int[] cnt = new int[M];

        long count= 0;

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            int num = Integer.parseInt(st.nextToken());
            sum = (sum + num);
            mod = sum%M;

            cnt[(int)mod]++;
        }

        count = count + cnt[0];
        // 누적합%M 의 값이 같은것 끼리의 조합 그리고 애초에 나누어 떨어지는거
        for (int i = 0; i < M; i++) {
            if (cnt[i] > 1) {
                count += (long) cnt[i] * (cnt[i] - 1) / 2;
            }
        }

        System.out.println(count);
    }
}
