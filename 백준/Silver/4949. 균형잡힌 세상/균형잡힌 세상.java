import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main{
    static Stack<Character> stack;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        while (true) {
            String line = br.readLine();
            if (line.equals(".")) break;

            if (check(line)) {
                sb.append("yes\n");
            } else {
                sb.append("no\n");
            }
        }

        System.out.println(sb);
    }

    static boolean check(String str){
        stack = new Stack<>();
        for (int j = 0; j < str.length(); j++) {
            char c = str.charAt(j);
            if(c == '(' || c=='[') {
                stack.push(c);
            }

            if(c == ')' || c==']'){
                if (stack.isEmpty()) return false;
                if( c==')' && stack.peek()=='(' || c==']' && stack.peek()=='['){
                    stack.pop();
                } else return false;
            }
        }
        return stack.isEmpty();
    }
}
