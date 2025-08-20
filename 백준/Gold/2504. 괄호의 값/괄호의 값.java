
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[] arr = br.readLine().toCharArray();

        int answer = 0;
        int temp = 1;
        Deque<Character> stack = new ArrayDeque<>();

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == '('){
                stack.push('(');
                temp *= 2;
            } else if( arr[i] == '['){
                stack.push('[');
                temp *= 3;
            } else if( arr[i] == ')'){
                if (stack.isEmpty() || stack.peek() != '(') {
                    System.out.println(0);
                    return;
                }

                if (i>0 && arr[i-1]== '(' ){
                    answer += temp;
                }
                stack.pop();
                temp/=2;

            } else if (arr[i] ==']'){
                if (stack.isEmpty() || stack.peek() != '[') {
                    System.out.println(0);
                    return;
                }

                if (i>0 && arr[i-1]== '[' ){
                    answer += temp;
                }
                stack.pop();
                temp/=3;
            }
        }

        System.out.println(stack.isEmpty() ? answer : 0);
    }
}
