
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    static int N;
    static int[] arr;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new int[N+2];
        arr[1] = 1;
        arr[2] = 2;

        if (N==1){
            System.out.println(1);
        } else if (N==2) {
            System.out.println(2);
        } else {
            for (int i = 3; i <= N; i++) {
                arr[i] = (arr[i-1] + arr[i-2])%15746;
            }

            System.out.println(arr[N]);
        }

    }
}
