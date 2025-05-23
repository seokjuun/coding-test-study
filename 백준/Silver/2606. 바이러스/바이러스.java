
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int totalCom, edge;
    static List<List<Integer>> list = new ArrayList<>();
    static boolean[] visited;
    static int count =-1;

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        totalCom = Integer.parseInt(br.readLine());
        edge = Integer.parseInt(br.readLine());
        visited = new boolean[totalCom+1];

        for (int i = 0; i < totalCom+1; i++) {
            list.add(new ArrayList<>());
        }

        for (int i = 0; i < edge; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            list.get(a).add(b);
            list.get(b).add(a);
        }

        bfs(1);
        System.out.println(count);
    }

    static void bfs(int num){
        Queue<Integer> queue = new ArrayDeque<>();
        queue.offer(num);

        while (!queue.isEmpty()){
            int poll = queue.poll();
            if (!visited[poll]){
                visited[poll] = true;
                count++;

                List<Integer> nodes = list.get(poll);
                for(int node : nodes){
                    queue.offer(node);
                }
            }
        }
    }
}
