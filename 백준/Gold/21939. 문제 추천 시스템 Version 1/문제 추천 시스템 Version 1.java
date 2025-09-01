

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    
    static int N,M;
    static Map<Integer, Integer> map = new HashMap<>();
    static TreeSet<Problem> set = new TreeSet<>((a,b) -> {
        if(a.l != b.l) return Integer.compare(a.l, b.l);
        return Integer.compare(a.p, b.p);
    });

    static StringBuilder sb = new StringBuilder();

    static class Problem{
        int p;
        int l;

        public Problem(int p, int l) {
            this.p = p;
            this.l = l;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int p = Integer.parseInt(st.nextToken());
            int l = Integer.parseInt(st.nextToken());
            if (map.containsKey(p)){
                set.remove(new Problem(p, map.get(p)));
            }

            map.put(p,l);
            set.add(new Problem(p,l));
        }

        M = Integer.parseInt(br.readLine());

        for (int i = 0; i < M; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String method = st.nextToken();

            switch (method) {
                case "recommend": {
                    int x = Integer.parseInt(st.nextToken());
                    if (x == -1){
                        sb.append(set.first().p).append("\n");
                    } else {
                        sb.append(set.last().p).append("\n");
                    }
                    break;
                }
                case "solved": {
                    int p = Integer.parseInt(st.nextToken());

                    set.remove(new Problem(p, map.get(p)));
                    map.remove(p);
                    break;
                }
                case "add": {
                    int p = Integer.parseInt(st.nextToken());
                    int l = Integer.parseInt(st.nextToken());
                    if (map.containsKey(p)){
                        set.remove(new Problem(p, map.get(p)));
                    }

                    map.put(p,l);
                    set.add(new Problem(p,l));
                    break;
                }
            }
        }

        System.out.println(sb);
    }
}
