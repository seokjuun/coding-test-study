import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        Deque<int[]> stack = new ArrayDeque<>(); // 탑, 높이

        for (int i = 0; i < N; i++) {
            int height = Integer.parseInt(st.nextToken());

            while (!stack.isEmpty() && height > stack.peek()[1]){
                stack.pop();
            }
            if(stack.isEmpty()) {
                sb.append("0 ");
            } else{
                sb.append(stack.peek()[0]+1);
                sb.append(" ");
            }
            stack.push(new int[]{i,height});
        }
        System.out.println(sb);

        br.close();
    }
}