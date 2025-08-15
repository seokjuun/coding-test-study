
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int N,K;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        sb.append("<");

        Queue<Integer> queue = new ArrayDeque<>();
        for (int i = 1; i <= N ; i++) {
            queue.offer(i);
        }

        int count =1;
        while (queue.size() > 1){
            if ( count%K == 0){
                sb.append(queue.poll()).append(", ");
            } else {
              queue.offer(queue.poll());
            }
            count++;
        }

        sb.append(queue.poll()).append(">");
        System.out.println(sb);
    }
}
