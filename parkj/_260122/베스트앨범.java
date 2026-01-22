import java.util.*;

class Solution {
    public int[] solution(String[] genres, int[] plays) {
        ArrayList<Integer> result = new ArrayList<>();
        
        // 장르별 총 재생 수를 저장하는 Map
        Map<String, Integer> genreTotal = new HashMap<>();
    
        // classic : 0000, pop : 0000
        for (int i = 0; i < genres.length; i++) {
            genreTotal.put(genres[i], genreTotal.getOrDefault(genres[i], 0) + plays[i]);
        }

        // 총 재생 수 기준으로 정렬
        /// genreTotal.keySet()을 통해서 key값만 추출해서 Set 처리 [classic, pop]
        /// key의 value 값을 가져와서 람다 비교 (3100 - 1450)
        /// 양수 : b가 앞으로 / 음수 : a가 앞으로
        ArrayList<String> genreList = new ArrayList<>(genreTotal.keySet());
        genreList.sort((a, b) -> genreTotal.get(b) - genreTotal.get(a));

        // 순서대로 장르를 먼저 수록하고, 장르 내에서 조건 처리
        for (String genre : genreList) {
            ArrayList<int[]> list = new ArrayList<>();

            // 현재 장르와 같은 노래라면 list에 등록
            // 즉, classic / pop 끼리 묶는다는 소리
            for (int i = 0; i < genres.length; i++) {
                if (genres[i].equals(genre)) list.add(new int[]{i, plays[i]}); // 인덱스 번호, 재생 횟수
            }

            /// 만약 두 노래의 재생 횟수가 같으면, 인덱스를 기준으로 처리하고
            /// 재생 횟수가 다르면, 재생 횟수가 가장 큰 값을 리턴함
            list.sort((a, b) -> { return a[1] == b[1] ? a[0] - b[0] : b[1] - a[1]; });

            // 장르당 최대 "2개" 까지만 가능하기에 i < 2 제한
            for (int i = 0; i < list.size() && i < 2; i++) {
                result.add(list.get(i)[0]);
            }
        }

        int[] answer = new int[result.size()];
        for (int i = 0; i < result.size(); i++) {
            answer[i] = result.get(i);
        }

        return answer;
    }
}
