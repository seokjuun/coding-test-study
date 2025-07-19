
import java.util.*;

class Solution {
    private static HashMap<Integer, HashMap<String, Integer>> courseMap = new HashMap<>();
    static List<String> list = new ArrayList<>();
    public String[] solution(String[] orders, int[] course) {

        for ( int len : course){
            courseMap.put(len, new HashMap<>()); // 조합 길이, (조합 문자열, 등장 횟수) 만들어 둠
        }

        // 주문별 조합
        for(String order : orders){
            char[] orderArr = order.toCharArray(); // 문자열-> 배열
            Arrays.sort(orderArr);

            for(int len : course){
                if (orderArr.length >= len){ // 문자열이 조합 크기보다 크거나 같으면
                    comb(orderArr, 0, len, new StringBuilder());
                }
            }
        }

        // 길이별 가장 많이 등장한 조합은?
        for (int len : course){
            Map<String, Integer> map = courseMap.get(len);

            int max = 0;
            for (int count : map.values()){
                if (count >= 2){
                    max = Math.max(max, count);
                }
            }

            for (var key : map.keySet()) {
                if (map.get(key) == max && max >= 2) {
                    list.add(key);
                }
            }

        }
        
        Collections.sort(list);
        return list.toArray(new String[0]);
    }

    static void comb(char[] arr, int idx, int len, StringBuilder sb){
        if (sb.length() == len){ // 조합길이랑 같아지면
            String str = sb.toString();

            Map<String,Integer> map = courseMap.get(len); // 조합 map 가져오기
            if (map.containsKey(str)){
                map.put(str, map.get(str)+1); // 이미 조합이 있으면 +1
                return;
            } else {
                map.put(str, 1); // 없으면 조합 넣어주고
                return;
            }
        }

        for (int i = idx; i< arr.length; i++){ // orderArr
            sb.append(arr[i]); // sb 에 현재 인덱스 값 추가
            comb(arr, i+1, len, sb); // 재귀
            sb.deleteCharAt(sb.length() -1); // 방금 추가했던거 빼고 백트래킹
        }

    }

}