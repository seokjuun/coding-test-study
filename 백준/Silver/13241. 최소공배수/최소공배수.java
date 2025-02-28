import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static long A,B;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        A = Long.parseLong(st.nextToken());
        B = Long.parseLong(st.nextToken());

        long i = gcd(A,B);

        System.out.println((A/i) * (B/i) * i);
    }

    static long gcd(long a, long b){
        long numA = 0;
        long numB = 0;
        if(b==0){
            return a;
        }

        if(b >= a){
            numA = a;
            numB = b%a;
        } else {
            numA = b;
            numB = a%b;
        }

        return gcd(numA, numB);
    }
}
