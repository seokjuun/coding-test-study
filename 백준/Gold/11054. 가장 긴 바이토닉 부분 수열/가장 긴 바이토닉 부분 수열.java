
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int[] arr;
    static int[] dpUp;
    static int[] dpDown;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new int[N];
        dpUp = new int[N];
        dpDown = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }


        // 증가하는 수열
        for (int i = 0; i < N; i++) {
            dpUp[i] = 1;
            for (int j = 0; j < i; j++) {
                if (arr[i]>arr[j]){
                    dpUp[i] = Math.max(dpUp[i],dpUp[j]+1);
                }
            }
        }

        // 감소하는 수열
        for (int i = N-1; i >= 0; i--) {
            dpDown[i] = 1;
            for (int j = N-1; j > i; j--) {
                if (arr[i]>arr[j]){
                    dpDown[i] = Math.max(dpDown[i],dpDown[j]+1);
                }
            }
        }

        int count = 0;
        for (int i = 0; i < N; i++) {
            count = Math.max(count, dpUp[i]+dpDown[i]-1);
        }
        System.out.println(count);

    }
}
