import java.util.*;

class Solution {
    public String solution(String[] survey, int[] choices) {
        String answer = "";

        Map<Character,Integer> map = new HashMap<>();
        char[] types = {'R', 'T', 'C', 'F', 'J', 'M', 'A', 'N'};
        for (char t : types) map.put(t, 0);
        
        for (int i = 0; i < survey.length; i++) {
            int score = choices[i] - 4;
            if (score < 0) {
                char type = survey[i].charAt(0);
                map.put(type, map.get(type) + Math.abs(score));
            } else if (score > 0) {
                char type = survey[i].charAt(1);
                map.put(type, map.get(type) + score);
            }
        }
        
        StringBuilder sb = new StringBuilder();
        sb.append(map.get('R') >= map.get('T') ? 'R' : 'T');
        sb.append(map.get('C') >= map.get('F') ? 'C' : 'F');
        sb.append(map.get('J') >= map.get('M') ? 'J' : 'M');
        sb.append(map.get('A') >= map.get('N') ? 'A' : 'N');
        
        return sb.toString();
    }
}