
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[] arr = br.readLine().toCharArray();
        int answer = 0;
        Deque<Integer> stack = new ArrayDeque();

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == '('){
                if (arr[i+1] == ')'){
                    answer += stack.size();
                    i++;
                } else {
                    stack.push(1);
                }
            } else {
                stack.pop();
                answer++;
            }
        }

        System.out.println(answer);
    }
}
