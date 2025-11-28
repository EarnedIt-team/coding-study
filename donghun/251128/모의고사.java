import java.util.*;

class Solution {
    public int[] solution(int[] answers) {
        int[] one = new int[]{1,2,3,4,5};
        int[] two = new int[]{2,1,2,3,2,4,2,5};
        int[] three = new int[]{3,3,1,1,2,2,4,4,5,5};
        
        // 각 수포자의 정답개수를 저장
        Map<Integer, Integer> map = new HashMap<>();
        
        // Map 세팅
        for(int i = 1; i <= 3; i++) map.put(i, 0);
        
        // 순회하며 정답 개수 체크
        for(int i = 0; i < answers.length; i++){
            // 수포자 1 계산
            if(one[i % one.length]  == answers[i]) map.put(1, map.get(1)+1);
                
            // 수포자 2 계산
            if(two[i % two.length]  == answers[i]) map.put(2, map.get(2)+1);
        
            // 수포자 3 계산
            if(three[i % three.length]  == answers[i]) map.put(3, map.get(3)+1);
        }
        
        // 가장 높은 점수 계산
        int maxScore = Collections.max(map.values());

        // 가장 많이 맞힌 사람(들) 리스트에 추가
        List<Integer> result = new ArrayList<>();
        for (int i = 1; i <= 3; i++) {
            if (map.get(i) == maxScore) result.add(i);
        }

        // 오름차순 정렬 후 배열로 변환
        Collections.sort(result);
        
        return result.stream().mapToInt(Integer::intValue).toArray();
    }
}