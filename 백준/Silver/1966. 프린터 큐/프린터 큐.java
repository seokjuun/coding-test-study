import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;


public class Main {
    static int testCase;
    static int[] answer;

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        testCase = Integer.parseInt(br.readLine());
        answer = new int[testCase];
        for (int i = 0; i < testCase; i++) {
            st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken()); 
            int M = Integer.parseInt(st.nextToken()); 

            Queue<int[]> queue = new ArrayDeque<>();
            PriorityQueue<Integer> pqueue = new PriorityQueue<>(Collections.reverseOrder()); // 내림차순

            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                int important = Integer.parseInt(st.nextToken());
                queue.offer(new int[]{j, important}); 
                pqueue.offer(important);
            }
            int count = 0;
            while (!queue.isEmpty()){
                int[] poll = queue.poll(); 
                if(poll[1] == pqueue.peek()){ 
                    pqueue.poll(); 
                    count++; 
                    if(poll[0] == M){ 
                        answer[i] = count; 
                        break; 
                    }
                } else {
                    queue.offer(poll); 
                }
            }
        }
        // 답 배열
        for (int i = 0; i < testCase; i++) {
            System.out.println(answer[i]);
        }
    }
}
