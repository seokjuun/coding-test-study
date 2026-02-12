import java.util.*;

class Solution {
    public int[] solution(int n, int[][] roads, int[] sources, int destination) {
        int[] answer = new int[sources.length];

        List<Integer>[] list = new ArrayList[n + 1];
        for (int i = 1; i < n + 1; i++) {
            list[i] = new ArrayList<>();
        }
        
        for (int[] road : roads) {
            int a = road[0];
            int b = road[1];
            list[a].add(b);
            list[b].add(a);
        }

        int[] distance = new int[n + 1];
        Arrays.fill(distance, -1); 

        bfs(n, list, distance, destination);

        for (int i = 0; i < sources.length; i++) {
            answer[i] = distance[sources[i]];
        }
        
        return answer;
    }

    private void bfs(int n, List<Integer>[] list, int[] distance, int start) {
        Deque<Integer> queue = new ArrayDeque<>();
        queue.offer(start);
        distance[start] = 0;

        while (!queue.isEmpty()) {
            int current = queue.poll();

            for (int neighbor : list[current]) {

                if (distance[neighbor] == -1) {
                    distance[neighbor] = distance[current] + 1;
                    queue.offer(neighbor);
                }
            }
        }
    }
}