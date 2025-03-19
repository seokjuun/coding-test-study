

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N,M,V;
    static List<List<Integer>> list = new ArrayList<>();
    static StringBuilder sb1 = new StringBuilder();
    static StringBuilder sb2 = new StringBuilder();
    static boolean[] visited1;
    static boolean[] visited2;

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        V = Integer.parseInt(st.nextToken());
        visited1 = new boolean[N+1];
        visited2 = new boolean[N+1];

        for (int i = 0; i < N+1; i++) {
            list.add(new ArrayList<>());
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            list.get(a).add(b);
            list.get(b).add(a);
        }

        for (List<Integer> nodes : list) {
            nodes.sort((e1,e2)->e1-e2);
        }

        dfs(V);
        System.out.println(sb1);
        bfs(V);
        System.out.println(sb2);

    }

    static void dfs(int n){
        visited1[n]=true;
        sb1.append(n).append(" ");
        List<Integer> nodes = list.get(n);
        for (int node : nodes){
            if(!visited1[node]){
                dfs(node);
            }
        }
    }

    static void bfs(int n){
        Queue<Integer> queue = new ArrayDeque<>();
        queue.offer(n);

        while (!queue.isEmpty()){
            int poll = queue.poll();
            if (!visited2[poll]){
                visited2[poll] = true;
                sb2.append(poll).append(" ");
                List<Integer> nodes = list.get(poll);
                for (int node : nodes){
                    queue.offer(node);
                }
            }
        }

    }
}
