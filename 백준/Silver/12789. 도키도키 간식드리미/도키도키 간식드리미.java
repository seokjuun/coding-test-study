import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static Stack<Integer> stack = new Stack<>();
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        int num = 1;
        for (int i = 0; i < N; i++) {
            int n = Integer.parseInt(st.nextToken());
            if(num == n){
                num++;
            } else {
                stack.push(n);
            }

            while (!stack.isEmpty() && num == stack.peek()){
                stack.pop();
                num++;
            }
        }

        

        System.out.println(stack.isEmpty() ? "Nice" : "Sad");
    }
}
