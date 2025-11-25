import java.util.*;

class Solution {
    public int solution(String[] want, int[] number, String[] discount) {
        int answer = 0;

    
        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < want.length; i++) {
            map.put(want[i], number[i]);
        }

        if (discount.length < 10) {
            return 0;
        }


        for (int i = 0; i + 9 < discount.length; i++) {
            Map<String, Integer> window = new HashMap<>();


            for (int j = i; j < i + 10; j++) {
                String item = discount[j];
                window.put(item, window.getOrDefault(item, 0) + 1);
            }

            boolean ok = true;
            for (int k = 0; k < want.length; k++) {
                String item = want[k];
                int need = number[k];
                int have = window.getOrDefault(item, 0);

                if (need != have) {
                    ok = false;
                    break;
                }
            }

            if (ok) {
                answer++;
            }
        }

        return answer;
    }
}