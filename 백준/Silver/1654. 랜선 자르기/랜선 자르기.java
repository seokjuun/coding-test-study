import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int K = Integer.parseInt(st.nextToken()); // 가진 랜선 개수
        int N = Integer.parseInt(st.nextToken()); // 필요한 랜선 개수

        // 배열에 랜선 길이 저장
        long[] lens = new long[K];
        long maxLen = 0;  // 가장 큰 랜선 길이를 저장할 변수

        for (int i = 0; i < K; i++) {
            lens[i] = Integer.parseInt(br.readLine());
            if (lens[i] > maxLen) {  // 최댓값 갱신
                maxLen = lens[i];
            }
        }

        // 찾기
        long left = 1;
        long right = maxLen;
        long result = 0; // 최고랜선

        while (left <= right){
            long middle = (left+right)/2;
            long count =0;

            for(long len : lens){
                count += len / middle;
            }
            if(count >=N){
                result = middle;
                left = middle+1;
            } else{
                right= middle-1;
            }

        }
        // 첫째 줄에 N개를 만들 수 있는 랜선의 최대 길이를 센티미터 단위의 정수로 출력한다.
        System.out.println(result);
        br.close();
    }
}