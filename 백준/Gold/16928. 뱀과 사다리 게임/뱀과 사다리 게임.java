

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N,M;
    static int[] visited = new int[101];
    static Map<Integer, Integer> move = new HashMap<>();
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        for (int i = 0; i < N+M; i++) {
            st =new StringTokenizer(br.readLine());
            move.put(Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken()));
        }

        bfs(1,0);
    }

    static void bfs(int n, int count){
        Queue<int[]> queue = new ArrayDeque<>();
        queue.offer(new int[]{n,count});
        visited[n] = 0;

        while (!queue.isEmpty()){
            int[] arr = queue.poll();
            int num = arr[0];
            int cnt = arr[1];

            if (num == 100){
                System.out.println(cnt);
                return;
            }

            for (int i = 1; i <= 6; i++) {
                if(num+i > 100) continue;


                if(visited[num+i]==0 || visited[num+i] > cnt+1 ){ // 더 적은 카운트로 방문 시
                    if(move.containsKey(num+i)){
                        queue.offer(new int[]{move.get(num+i),cnt+1} );
                        visited[num+i] = cnt+1;
                        continue;
                    }

                    queue.offer(new int[]{num+i,cnt+1});
                    visited[num+i] = cnt+1;
                }
            }
        }

    }
}
