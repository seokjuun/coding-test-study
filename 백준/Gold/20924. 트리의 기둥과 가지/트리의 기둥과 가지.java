
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    static ArrayList<Line>[] list;
    static int N;
    static int R;
    static boolean[] visited;
    static int giga;
    static int max = 0;

    static class Line{
        int b;
        int d;

        public Line(int b, int d) {
            this.b = b;
            this.d = d;
        }
    }

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());
        visited = new boolean[N+1];
        giga = R;

        list = new ArrayList[N+1];
        for (int i = 1; i < N+1; i++) {
            list[i] = new ArrayList<>();
        }


        for (int i = 1; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());

            list[a].add(new Line(b,d));
            list[b].add(new Line(a,d));
        }

        StringBuilder sb = new StringBuilder();

        int GigaNodeD;
        if (list[R].size() != 1) GigaNodeD = 0;
        else GigaNodeD = findGiga(R);
        sb.append(GigaNodeD).append(" ");

        if (list[giga].size() == 1) max = 0;
        else dfs(giga, max);
        sb.append(max);

        System.out.println(sb);
    }


    static int findGiga(int node){
        int d = 0;
        // 기저조건
        if (node != R && list[node].size() > 2 || node != R && list[node].size() ==1){
            giga = node;
            return 0;
        }

        // 노드 선택
        visited[node] = true;
        int t;
        if(visited[list[node].get(0).b]){
            t = list[node].get(1).b;
            d += list[node].get(1).d;
        } else {
            t = list[node].get(0).b;
            d += list[node].get(0).d;
        }

        return d + findGiga(t);
    }

    static void dfs(int n, int d){
        // 기저조건
        if (n != giga && list[n].size() == 1){
            max = Math.max(d,max);
        }
        visited[n] = true;

        for (Line line : list[n]){
            if (visited[line.b]) continue;
            dfs(line.b, d + line.d);
        }
    }
}
