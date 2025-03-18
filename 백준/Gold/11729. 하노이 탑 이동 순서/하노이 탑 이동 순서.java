
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    static int N,count = 0;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        hanoi(N,1,2,3);

        System.out.println(count);
        System.out.println(sb);
    }

    static void hanoi(int n, int from, int temp, int to){
        count++;

        if(n==1){
            sb.append(from).append(" ").append(to).append("\n");
            return;
        }

        // from -> temp
        hanoi(n-1,from,to,temp); // 재귀 : 시작기둥에서 임시기둥으로
        // from -> to
        sb.append(from).append(" ").append(to).append("\n");
        // temp -> to
        hanoi(n-1,temp,from,to); // 재귀 : 임시기둥에서 목표기둥으로
    }
}
