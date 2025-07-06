import java.util.*;

class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        Deque<Integer> bridge = new ArrayDeque<>();
        int totalWeight = 0;
        int time = 0;

        for (int i = 0; i < bridge_length; i++) {
            bridge.offer(0);
        }

        int idx = 0;
        while (idx < truck_weights.length) {
            time++;
            totalWeight -= bridge.poll();

            if (totalWeight + truck_weights[idx] <= weight) {
                bridge.offer(truck_weights[idx]);
                totalWeight += truck_weights[idx];
                idx++;
            } else {
                bridge.offer(0);
            }
        }

        time += bridge_length;

        return time;
    }
}