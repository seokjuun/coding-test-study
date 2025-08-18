
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());
        Deque<Integer> stack = new ArrayDeque<>();

        int next = 1;
        boolean ok = true;

        for (int i = 0; i < n; i++) {
            int target = Integer.parseInt(br.readLine());

            while ( next <= target ){
               stack.push(next++);
               sb.append("+\n");
            }

            if (!stack.isEmpty() && stack.peek() == target){
                stack.pop();
                sb.append("-\n");
            } else {
                ok = false;
                break;
            }
        }

        System.out.println(ok ? sb : "NO");
    }
}
