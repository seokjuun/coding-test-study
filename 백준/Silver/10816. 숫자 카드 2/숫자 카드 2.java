import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
    static int N,M;
    static int[] card ;
    static int[] hi;
    static Map<Integer,Integer> map = new HashMap<>();
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        card = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N ; i++) {
            card[i] = Integer.parseInt(st.nextToken());
        }

        M = Integer.parseInt(br.readLine());
        hi=new int[M];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) {
            int num = Integer.parseInt(st.nextToken());
            hi[i] = num;
            map.put(num,0);
        }

        for (int pick : card) {
            if(!map.containsKey(pick)) continue;
            map.put(pick, map.get(pick)+1);
        }
       
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < hi.length; i++) {
            sb.append(map.get(hi[i]) + " ");
        }
        System.out.println(sb);
    }
}
