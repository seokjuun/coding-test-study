
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        int min =0, max =0;
        double total=0;

        int[] arr = new int[N];
        Integer[] arr2 = new Integer[N];
        Map<Integer,Integer> map = new HashMap<>();
        for (int i = 0; i < N; i++) {
            int num = Integer.parseInt(br.readLine());
            total += num;
            map.put(num, map.getOrDefault(num, 0) + 1);
            arr[i] = num;
        }

        Arrays.sort(arr);

        List<Integer> list = new ArrayList<>(map.keySet());
        list.sort((e1, e2) -> {
            int val = Integer.compare(map.get(e2), map.get(e1)); // 값 기준 내림차순
            return (val != 0) ? val : Integer.compare(e1, e2); // 값 같으면 키 오름차순
        });

        int mode = (list.size() > 1 && map.get(list.get(0)).equals(map.get(list.get(1))))
                ? list.get(1) : list.get(0);

        sb.append(Math.round(total/N)).append("\n");
        sb.append(arr[((N+1)/2)-1]).append("\n");
        sb.append(mode).append("\n");

        if(arr.length == 1 ){
            sb.append(0).append("\n");
        } else {
            sb.append(arr[N-1]-arr[0]).append("\n");
        }

        System.out.println(sb);
    }
}
