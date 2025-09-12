import java.util.*;

class Solution {
    public int[] solution(String[] genres, int[] plays) {
        List<Integer> answer = new ArrayList<>();
        
        Map<String,Integer> genresPlay = new HashMap<>(); // 장르, 플레이 수
        Map<String, List<Integer>> genresSongIdx = new HashMap<>(); // 장르별 곡 인덱스
        for(int i = 0; i<genres.length; i++){
            // 장르별 플레이 수 추가
            genresPlay.put(genres[i], genresPlay.getOrDefault(genres[i],0)+plays[i]);
            // 장르별 곡 인덱스 추가
            List<Integer> list = genresSongIdx.getOrDefault(genres[i], new ArrayList<>());
            list.add(i);
            genresSongIdx.put(genres[i], list);
        }
        
        // 장르별 재생 수 내림차순
        List<String> sortGenres = new ArrayList<>(genresPlay.keySet());
        Collections.sort(sortGenres, (a,b) -> genresPlay.get(b) - genresPlay.get(a));
        
        // 장르별 두 곡 넣기
        for(String genre : sortGenres){ 
            // 일단 정렬: 재생 수, 인덱스
            List<Integer> list = genresSongIdx.get(genre);
            Collections.sort(list, 
                             (a,b) -> {
                                 if(plays[b] == plays[a]) return a-b;
                                 return plays[b] -plays[a];
                             });
            
            // 곡 뽑기
            if(list.size() >=2){
                answer.add(list.get(0));
                answer.add(list.get(1));
            } else{
                answer.add(list.get(0));
            }
        }
        
        return answer.stream().mapToInt(Integer::intValue).toArray();
    }
}