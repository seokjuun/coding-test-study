import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
    static int N,M;
    static Map<Integer, String> num = new HashMap<>();
    static Map<String,Integer> name = new HashMap<>();
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        for (int i = 0; i < N; i++) {
            String str = br.readLine();
            num.put(i+1, str);
            name.put(str,i+1);
        }

        for (int i = 0; i < M; i++) {
            String str = br.readLine();
            if(str.charAt(0)>='A'){
                sb.append(name.get(str) + "\n");
            } else {
                sb.append(num.get(Integer.parseInt(str))+ "\n");
            }
        }
        System.out.println(sb);
    }
}
