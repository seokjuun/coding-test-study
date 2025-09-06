import java.util.*;

class Solution {
    public int solution(int k, int[] tangerine) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int size : tangerine) {
            map.put(size, map.getOrDefault(size, 0) + 1);
        }

        List<Integer> list = new ArrayList<>(map.values());
        list.sort((a,b)-> b -a);

        int cnt = 0;
        for(int n : list){
            if (k<=0) break;
            k -= n;
            cnt++;
        }

        return cnt;
    }
}