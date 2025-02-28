import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N,M,count =0;
    static Set<String> set = new HashSet<>();
    static List<String> answer = new ArrayList<>();
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        for (int i = 0; i < N; i++) {
            set.add(br.readLine());
        }

        for (int i = 0; i < M; i++) {
            String str = br.readLine();
            if(set.contains(str)){
                answer.add(str);
                count ++;
            }
        }

        Collections.sort(answer);

        for (int i = 0; i < answer.size(); i++) {
            sb.append(answer.get(i)+"\n");
        }

        System.out.println(count);
        System.out.println(sb);
    }
}
