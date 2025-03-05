import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
    static int n;
    static List<Integer> list = new ArrayList<>();
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        while(true){
            n = Integer.parseInt(br.readLine());
            if(n == 0) break;
            list.add(n);
        }

        for (int i = 0; i < list.size(); i++) {
            sb.append(countPrime(list.get(i))).append("\n");
        }
        System.out.println(sb);
    }

    static int countPrime(int num){
        int count = 0;

        for (int i = num+1; i <= 2*num; i++) {
            if(isPrime(i)) count++;
        }

        return count;
    }

    static boolean isPrime(int num){
        if(num == 1) return false;
        if(num == 2 || num==3) return true;
        for (int i = 2; i*i <= num; i++) {
            if(num%i == 0) return false;
        }
        return true;
    }
}
