
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int max= 0;


        int[] arr = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            if (arr[i]>max) max =arr[i];
        }

        int low = 0;
        int high = max;
        int result = 0;

        while (low<=high){
            int mid = (low + high) /2;
            long total = 0;

            for(int len : arr){
                if (len > mid){
                    total += len - mid;
                }
            }

            if (total >= M){
                result = mid;
                low = mid + 1;
            } else{
                high = mid -1;
            }
        }

        System.out.println(result);
    }
}
