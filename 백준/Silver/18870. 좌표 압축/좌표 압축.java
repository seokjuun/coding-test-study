import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N;
    static Map<Integer, Integer> map = new HashMap<>();
    static int[] arr,arrTest;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        N = Integer.parseInt(br.readLine());
        arr = new int[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        arrTest = arr.clone();
        Arrays.sort(arrTest);

        int num=0;
        for (int i = 0; i < arrTest.length; i++) {
            if(!map.containsKey(arrTest[i])){
                map.put(arrTest[i],num++);
            }
        }

        for (int i = 0; i < arr.length; i++) {
            sb.append(map.get(arr[i])+" ");
        }
        System.out.println(sb);
    }
}
