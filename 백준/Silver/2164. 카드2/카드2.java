import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;

public class Main {
    static int N;
    static Queue<Integer> queue = new ArrayDeque<>();
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        for (int i = 1; i <= N; i++) {
            queue.offer(i);
        }

        for (int i = 1; i <= N-1; i++) {
            queue.poll();
            queue.offer(queue.poll());
        }

        System.out.println(queue.poll());
    }
}
