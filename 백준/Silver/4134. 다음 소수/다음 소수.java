import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    static long N;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        N = Long.parseLong(br.readLine());
        for (int i = 0; i < N; i++) {
            long num = Long.parseLong(br.readLine());
            while(!isPrime(num)){
                num++;
            }
            sb.append(num).append("\n");
        }

        System.out.println(sb);
    }

    static boolean isPrime(long num){
        if(num < 2) return false;
        if(num == 2 || num ==3) return true;
        for(long i=2; i*i <=num; i++){
            if(num%i==0) return false;
        };
        return true;
    }
}
