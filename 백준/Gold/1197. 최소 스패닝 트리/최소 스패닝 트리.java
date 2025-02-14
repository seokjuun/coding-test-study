import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;


public class Main {

    static int V, E, sum; 	// sum : MST 비용
    static Edge[] edges; 	// 간선 리스트
    static int[] parent; 	// 각 원소(정점 번호)별 집합 관계를 표현하는 1차원 배열

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        V = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());
        int cnt=0;


        parent = new int[V+1];
        edges = new Edge[E];

        // 간선 리스트 입력 처리
        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            int v1 = Integer.parseInt(st.nextToken());
            int v2 = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            edges[i] = new Edge(v1, v2, c);
        }

        makeSet();
        Arrays.sort(edges, (e1,e2)-> e1.c - e2.c);
        for (int i = 0; i < edges.length; i++) {
            Edge edge = edges[i];
            if(union(edge.v1, edge.v2)){
                sum+= edge.c;
                if( cnt == V - 1 ) break;
            }

        }
        System.out.println(sum);
    }

    static void makeSet(){
        for (int i = 0; i < V; i++) {
            parent[i] = i;
        }
    }

    static int findSet(int i){
        if(parent[i] == i) return i;
        return i = findSet(parent[i]);
    }

    static boolean union(int x, int y){
        int x2 = findSet(x);
        int y2 = findSet(y);

        if(x2 == y2) return false;
        if(x2<y2) parent[y2] = x2;
        else parent[x2] = y2;

        return true;
    }
    static class Edge{
        int v1, v2, c;

        public Edge(int v1, int v2, int c) {
            this.v1 = v1;
            this.v2 = v2;
            this.c = c;
        }
    }
}


