import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int a1,a2,b1,b2,c1,c2;

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        a1 = Integer.parseInt(st.nextToken());
        a2 = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        b1 = Integer.parseInt(st.nextToken());
        b2 = Integer.parseInt(st.nextToken());

        c1 = a1 * b2 + a2 * b1;
        c2 = a2 * b2;
        int x =0;
        while (x != 1){
            x = gcd(c1,c2);
            c1 /= x;
            c2 /= x;
        }

        System.out.println(c1 + " " + c2);
    }

    static int gcd(int a, int b){
        return (b == 0) ? a : gcd(b,a%b);
    }
}
