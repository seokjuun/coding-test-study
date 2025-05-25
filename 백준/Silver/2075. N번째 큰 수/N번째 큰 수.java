

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        
        int N = Integer.parseInt(br.readLine());
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());

            for (int j = 0; j < N; j++) {
                queue.offer(Integer.parseInt(st.nextToken()));

                if (queue.size() > N){
                    queue.poll();
                }
            }
        }

        System.out.println(queue.poll());
    }
}
