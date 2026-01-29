import java.util.*;

class Solution {
    public int[] solution(String[] genres, int[] plays) {
        
        // 가장 많이 재생된 장르 ->
        // 장르 내에서 가장 많이 재생된 노래 ->
        // 재생횟수가 같으면 고유 번호가 낮은 노래 먼저 
        
        Map<String, List<Music>> map = new HashMap<>();
        Map<String, Integer> sum_map = new HashMap<>();
        
        List<Integer> answer = new ArrayList<>();
        
        for(int i = 0; i < genres.length; i++) {
            Music music = new Music(i, plays[i]);
            map.computeIfAbsent(genres[i], 
                                k -> new ArrayList<>()).add(music);
        }
        
        // 정렬 처리하여 map세팅
        for(Map.Entry<String, List<Music>> entry : map.entrySet()) {
            // 정렬
            List<Music> list = entry.getValue();
            list.sort((a, b) -> b.plays - a.plays);
            
            int sum = 0;
            for (Music m : entry.getValue()) {
                sum+= m.plays;
            }
            sum_map.put(entry.getKey(), sum); // 장르의 재생횟수 총 합산 기록
        }
        
        // 장르 재생횟수 총 합산 내림차순 정렬 후 상위 2개 장르의 곡 2개씩 뽑아오기
        List<Map.Entry<String, Integer>> genreList =
            new ArrayList<>(sum_map.entrySet());
        
        // 총 재생횟수 기준 내림차순 정렬
        genreList.sort((a, b) -> b.getValue() - a.getValue());
        
        // 상위 장르 접근
        for(Map.Entry<String, Integer> genre : genreList) {
            String genreName = genre.getKey();
            List<Music> musics = map.get(genreName);
            
            // 장르의 노래가 2개 이상이라면
            if(musics.size() >= 2) {
                // 2개 삽입
                for(int i = 0; i < 2; i++) {
                    answer.add(musics.get(i).idx);
                }    
            } else { // 장르에 곡한 곡이 하나라면
                answer.add(musics.get(0).idx);
            }
        }
        
        // List -> Array
        int[] result = new int[answer.size()];
        for(int i = 0; i < answer.size(); i++) {
            result[i] = answer.get(i);
        }    
    
        return result;
    }
    
    class Music {
        int idx;
        int plays;
        
        Music(int idx, int plays) {
            this.idx = idx;
            this.plays = plays;
        }
    }
}