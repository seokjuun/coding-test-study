import java.util.*;

class Solution {
    
    static class Work {
        String name;
        int sTime;
        int pTime;
        
        public Work(String name, int sTime, int pTime) {
            this.name = name;
            this.sTime = sTime;
            this.pTime = pTime;
        }
    }
    
    public String[] solution(String[][] plans) {
        String[] answer = new String[plans.length];
        // 0 : name 1: start 2: playtime
        // 멈춰둔 과제는 스택에 넣기
        // 과제를 끝낸 순대로 배열만들어 출력
        
        Stack<Work> stack = new Stack<>();
        PriorityQueue<Work> pq = new PriorityQueue<>(
            (a,b) -> Integer.compare(a.sTime, b.sTime)
        );
        List<String> list = new ArrayList<>();
        
        for(String[] plan : plans){
            String name = plan[0];
            int sTime = changeTime(plan[1]);
            int pTime = Integer.parseInt(plan[2]);
            
            pq.offer(new Work(name, sTime, pTime));
        }
        
        Work recent = pq.poll();
        
        while(!pq.isEmpty()){
            Work poll = pq.poll(); // 그 다음 작업
            
            int timeGap = poll.sTime - recent.sTime;
            if(timeGap < recent.pTime){ // 시간부족
                recent.pTime -= timeGap;
                stack.push(recent);
                
            } else { // 시간넉넉
                list.add(recent.name);
                timeGap -= recent.pTime;
                // 다음 작업시작까지 남은시간 = timeGap
                // 스택체크
                while(!stack.isEmpty()){
                    Work pop = stack.pop();
                    if(timeGap < pop.pTime){
                        pop.pTime -= timeGap;
                        stack.push(pop);
                        break;
                    } else{
                        list.add(pop.name);
                        timeGap -= pop.pTime;
                    }
                        
                }
            }
            recent = poll;
        }
        
        list.add(recent.name);
        while(!stack.isEmpty()){
            Work pop = stack.pop();
            list.add(pop.name);
        }
        
        
        for(int i =0; i<plans.length; i++){
            answer[i] = list.get(i);
        }
        
        return answer;
    }
    
    static int changeTime(String str){
        StringTokenizer st = new StringTokenizer(str, ":");
        int hour = Integer.parseInt(st.nextToken()) * 60;
        int min = Integer.parseInt(st.nextToken());
        
        return hour + min;
    }
}