
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> queue = new PriorityQueue<>(Collections.reverseOrder());
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < N; i++) {
            int num = Integer.parseInt(br.readLine());

            if (num == 0){
                if (queue.isEmpty()){
                    sb.append(0).append("\n");
                } else {
                    sb.append(queue.poll()).append("\n");
                }
            } else {
                queue.offer(num);
            }
        }

        System.out.println(sb);
    }
}
