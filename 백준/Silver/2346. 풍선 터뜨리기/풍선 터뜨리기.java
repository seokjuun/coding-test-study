import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;
import java.util.List;

public class Main {
    static int N;
    static Deque<Integer> deque = new ArrayDeque<>();
    static int[] arr;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        arr = new int[N];

        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            deque.offer(i);
        }
        // 처음꺼
        int jump = arr[deque.pollFirst()];
        sb.append(1+" ");

        for (int i = 0; i < N-1; i++) {
            if(jump > 0){
                for (int j = 0; j < jump; j++) {
                    int a = deque.pollFirst();
                    deque.offerLast(a);
                }
                int idx = deque.pollLast();
                jump = arr[idx];
                sb.append(idx+1).append(" ");
            } else {
                for (int j = 0; j > jump; j--) {
                    int a = deque.pollLast();
                    deque.offerFirst(a);
                }
                int idx = deque.pollFirst();
                jump = arr[idx];
                sb.append(idx+1).append(" ");
            }
        }

        System.out.println(sb);
    }
}
