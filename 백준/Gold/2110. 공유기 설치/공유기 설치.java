
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static int[] arr;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());
        arr = new int[N];

        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(arr);

        int low = 1;
        int high = arr[N - 1] - arr[0];

        int result = 0;

        while (low <= high) {
            int gap = (low + high) / 2; 
            int count = 1;
            int last = arr[0];

            for (int i = 1; i < N; i++) {
                if (arr[i] - last >= gap) {
                    count++;
                    last = arr[i];
                }
            }

            if (count >= C) {  
                result = gap;      
                low = gap + 1; // 갭 늘리기
            } else {
                high = gap - 1;    // 갭 줄이기
            }
        }

        System.out.println(result);
    }


}
