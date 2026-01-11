import java.util.*;

class Solution {
    public int[] solution(String today, String[] terms, String[] privacies) {
        
        List<Integer> list = new ArrayList<>();
        
        // 오늘
        StringTokenizer st = new StringTokenizer(today, ".");
        int tYear = Integer.parseInt(st.nextToken());
        int tMonth = Integer.parseInt(st.nextToken());
        int tDay = Integer.parseInt(st.nextToken());
        int todayDays = tYear*12*28 + tMonth*28 + tDay;

        // 기간
        Map<String, Integer> map = new HashMap<>();
        for (String term : terms) {
            StringTokenizer st2 = new StringTokenizer(term);
            String type = st2.nextToken();
            int add = Integer.parseInt(st2.nextToken());
            map.put(type, add);
        }

        // 체크
        for (int i = 0; i < privacies.length; i++) {
            StringTokenizer st3 = new StringTokenizer(privacies[i]);

            String start = st3.nextToken();
            String type = st3.nextToken();

            int startDays = toDays(start);
            int add = map.get(type);

            // 만료일
            int dueDays = startDays + add*28 -1;

            if (todayDays > dueDays) {
                list.add(i+1);
            }
        }

        int[] answer = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            answer[i] = list.get(i);
        }
        
        return answer;
    }
    
    private int toDays(String date) {
        StringTokenizer st = new StringTokenizer(date, ".");
        int year = Integer.parseInt(st.nextToken());
        int month = Integer.parseInt(st.nextToken());
        int day = Integer.parseInt(st.nextToken());

        return year*12*28 + month*28 + day;
    }
}