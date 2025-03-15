
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    static int num, length;
    static String input;
    static char[] arr;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb;

        while ((input = (br.readLine())) != null){
            num = Integer.parseInt(input);
            length = (int) Math.pow(3, num);
            arr = new char[length];
            Arrays.fill(arr,'-');
            sol(0, length);

            sb = new StringBuilder();
            for (int i = 0; i < length; i++) {
                sb.append(arr[i]);
            }
            System.out.println(sb);
        }
    }

    static void sol(int start, int len){
        if(len == 1) return;

        for (int i = start + len/3; i < start + len/3*2 ; i++) {
            arr[i] = ' ';
        }

        sol(start, len/3);
        sol(start + len/3*2, len/3);
    }
}
