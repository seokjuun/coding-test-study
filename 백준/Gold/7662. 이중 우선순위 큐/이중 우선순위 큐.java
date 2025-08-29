
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int T;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {
            int k = Integer.parseInt(br.readLine());

            TreeMap<Integer, Integer> map = new TreeMap<>(); // 수,개수 기록

            for (int j = 0; j < k; j++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                char c = st.nextToken().charAt(0); // I는 삽입
                int n = Integer.parseInt(st.nextToken());

                if (c == 'I'){
                    map.put(n, map.getOrDefault(n,0)+1);
                } else if (!map.isEmpty() && n == 1){ // 최대값 삭제
                    if (map.get(map.lastKey()) > 1) {
                        map.put(map.lastKey() , map.get(map.lastKey()) - 1);
                    } else if (!map.isEmpty()){
                        map.remove(map.lastKey());
                    }
                } else if (!map.isEmpty()){ // 최소값 삭제
                    if (map.get(map.firstKey()) > 1) {
                        map.put(map.firstKey() , map.get(map.firstKey()) - 1);
                    } else if (!map.isEmpty()){
                        map.remove(map.firstKey());
                    }
                }

            }

            if (map.isEmpty()){
                sb.append("EMPTY").append("\n");
            } else {
                sb.append(map.lastKey()).append(' ').append(map.firstKey()).append("\n");
            }
        }

        System.out.println(sb.toString());
    }


}
