
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int M,N;
    static Map<String, Integer> map = new HashMap<>();
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        // 1. 최빈순
        // 2. 길이순
        // 3. 알파벳순
        for (int i = 0; i < N; i++) {
            String str = br.readLine();
            if(str.length()>=M){
                map.put(str, map.getOrDefault(str,0) +1);
            }
        }
        List<String> list = new ArrayList<>(map.keySet());
        Collections.sort(list, (e1,e2)->
                map.get(e1) == map.get(e2) ?
                        (e1.length() == e2.length() ? (e1.compareTo(e2)) : (e2.length() - e1.length()) )
                        : (map.get(e2) - map.get(e1))
                );

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < list.size(); i++) {
            sb.append(list.get(i)).append("\n");
        }
        System.out.println(sb);
    }


}
