
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] load = new int[N-1];
        int[] city = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N-1; i++) {
            load[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            city[i] = Integer.parseInt(st.nextToken());
        }

        long value = 0;
        int minPrice = city[0];

        for (int i = 0; i < N - 1; i++) {
            // 더 싸지면 여기서 주유
            if (city[i] < minPrice) {
                minPrice = city[i];
            }
            // 최소가격으로 주유
            value += (long) minPrice * load[i];
        }

        System.out.println(value);
    }
}
