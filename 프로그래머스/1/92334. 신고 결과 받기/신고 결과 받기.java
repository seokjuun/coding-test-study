import java.util.*;

class Solution {
    public int[] solution(String[] id_list, String[] report, int k) {
        int[] answer = new int[id_list.length];
        
        // 이름-id 맵 
        Map<String, Integer> id_name = new HashMap<>();
        for(int i =0; i<id_list.length; i++){
            id_name.put(id_list[i], i);
        }
        
        
        // id별 신고자 저장 리스트 배열
        List<Integer>[] reporter_list = new List[id_list.length];
        for(int i = 0; i < id_list.length; i++){
            reporter_list[i] = new ArrayList<>();
        }
        
        // 중복신고 제거
        Set<String> reportSet = new HashSet<>();
        for (String r : report) {
            reportSet.add(r);
        }
        
        // report 배열 돌리기
        for(String str : reportSet){
            StringTokenizer st = new StringTokenizer(str);
            String a = st.nextToken(); // 신고자
            String b = st.nextToken(); // 신고받음
            
            reporter_list[id_name.get(b)].add(id_name.get(a));
        }
        
        // k 이상인 애들 찾기
        for(int i =0; i< id_list.length; i++){
            if(reporter_list[i].size() >= k){
                for(int id : reporter_list[i]){
                    answer[id]++;
                }
            }
        }
        
        
        return answer;
    }
}