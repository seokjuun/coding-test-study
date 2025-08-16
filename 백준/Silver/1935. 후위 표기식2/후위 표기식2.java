
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        String str = br.readLine();

        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
        
        char[] strArr = str.toCharArray();
        Stack<Double> stack = new Stack<>();

        for (int i = 0; i < strArr.length; i++) {
            int num = strArr[i] - 'A';
            if (num >=0 && num <=25){ // 숫자면
                stack.push((double) arr[num]);
            } else if (strArr[i] == '*'){
                stack.push(stack.pop() * stack.pop());
            } else if (strArr[i] == '+'){
                stack.push(stack.pop() + stack.pop());
            } else if (strArr[i] == '-'){
                stack.push( - stack.pop() + stack.pop());
            } else if (strArr[i] == '/'){
                stack.push(1/stack.pop() * stack.pop());
            }
        }

        System.out.printf("%.2f",stack.pop());
    }
}
