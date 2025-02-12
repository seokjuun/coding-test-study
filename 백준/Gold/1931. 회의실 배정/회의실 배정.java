
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;


public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        long[][] time = new long[N][2];
        int count = 0;

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            time[i][0] = Long.parseLong(st.nextToken());
            time[i][1] = Long.parseLong(st.nextToken());
        }

        Arrays.sort(time, (a,b)->{
            if (a[1] == b[1]) return Long.compare(a[0], b[0]); // 종료 시간이 같다면 시작 시간 기준 정렬
            return Long.compare(a[1], b[1]); // 종료 시간이 작은 순으로 정렬
        });

        long end = time[0][1];
        count++;

        for (int i = 1; i < N; i++) {
            if(time[i][0] >= end){
                end = time[i][1];
                count++;
            }
        }
        System.out.println(count);

        br.close();
    }
}