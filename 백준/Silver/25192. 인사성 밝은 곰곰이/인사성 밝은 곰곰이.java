
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class Main {
    static int N,total =0;
    static Set<String> set;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        // 첫줄은 Enter
        set = new HashSet<>();

        for (int i = 0; i < N; i++) {
            String str = br.readLine();

            if(str.equals("ENTER")){
                total += set.size();
                set = new HashSet<>();
            } else {
                set.add(str);
            }
        }
        total += set.size();

        System.out.println(total);
    }
}
