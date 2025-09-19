import java.util.*;

class Solution {
    public int solution(int[][] jobs) {
        // 우선순위 : 작업의 소요시간 짧은거,  요청시각이 빠른것, 작업번호가 작은것
        // 작업마칠때 작업 요청 들어오면 작업 큐에 저장한 뒤 우선순위에 따름
        
        // 요청시간 기준 정렬
        Arrays.sort(jobs, (a,b) -> a[0] - b[0]);

        PriorityQueue<int[]> queue = new PriorityQueue<>((a,b) -> {
            // 0 : 요청 시점, 1 : 소요 시간
            if (a[1] != b[1]) return a[1] - b[1]; 
            return a[0] - b[0];
        });
        
        int time = 0; // 현재시간
        int sum = 0; // 반환시간 합
        int i =0; // 작업번호
        int done = 0; // 처리작업
        
        while(done < jobs.length){
            while(i < jobs.length && jobs[i][0] <= time){// 현재시간에 요청된 작업 큐에
                queue.offer(jobs[i]);
                i++;
            } 
            
            if (queue.isEmpty()) {
                time = Math.max(time, jobs[i][0]);
                continue;
            }
            
            int[] job = queue.poll();
            time += job[1]; // 꺼낸거 처리 완 시점
            sum += (time - job[0]);
            done++;
        }
        
        return sum/jobs.length;
    }
}