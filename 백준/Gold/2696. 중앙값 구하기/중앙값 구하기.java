
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    static int T;
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++) {
            PriorityQueue<Integer> leftQueue = new PriorityQueue<>((a,b) -> b-a); // 중앙값 왼쪽
            PriorityQueue<Integer> rightQueue = new PriorityQueue<>(); // 중앙값 오른쪽
            List<Integer> list = new ArrayList<>();
            int count =0;

            int M = Integer.parseInt(br.readLine());
            sb.append(M/2+1).append("\n");
            while (list.size()<M){
                st = new StringTokenizer(br.readLine());
                while (st.hasMoreElements()){
                    list.add(Integer.parseInt(st.nextToken()));
                }
            }

            for (int j = 0; j < M; j++) {
                if (leftQueue.size() == rightQueue.size()){
                    leftQueue.offer(list.get(j));
                } else {
                    rightQueue.offer(list.get(j));
                }

                if (!rightQueue.isEmpty() && leftQueue.peek()>rightQueue.peek()){
                    int left = leftQueue.poll();
                    int right = rightQueue.poll();

                    leftQueue.offer(right);
                    rightQueue.offer(left);
                }


                if (j%2 ==0){
                    sb.append(leftQueue.peek()).append(" ");
                    count++;
                }

                if (count == 10){
                    count = 0;
                    sb.append("\n");

                }
            }
            sb.append("\n");
        }

        System.out.println(sb);
    }

}
