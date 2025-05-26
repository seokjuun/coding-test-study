import java.util.*;

class Solution {
        public int solution(String[][] book_time) {
        int[][] book = new int[book_time.length][2];

        for (int i = 0; i < book.length; i++) {
            for (int j = 0; j < 2; j++) {
                String[] timeParts = book_time[i][j].split(":");
                book[i][j] =  Integer.parseInt(timeParts[0]) * 60 + Integer.parseInt(timeParts[1]);
            }
        }

        Arrays.sort(book, (a,b) -> a[0] - b[0]);
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        
        for (int[] time : book) {
            if (!queue.isEmpty() && queue.peek() <= time[0]) {
                queue.poll(); 
            }

            queue.offer(time[1] + 10);
        }


        return queue.size();
    }
}