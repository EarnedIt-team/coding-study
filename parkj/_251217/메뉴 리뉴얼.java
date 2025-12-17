import java.util.*;

class Solution {
    public String[] solution(String[] orders, int[] course) {
        // 단품 메뉴 -> 조합 -> 코스 요리 형태
        // 가장 많이 주문한 단품메뉴를 기반으로 구성 (최소 2가지, 2명 이상)
        Map<String, Integer> countMap = new HashMap<>();
        List<String> answer = new ArrayList<>();

        // orders 기반으로 조합만들기 : AB, AC, ...
        // (길이가 다른 조합을 만들기 위해 재귀 사용)
        for (String order : orders) {
            // 같은 조합을 동일하게 만들기 위해 정렬
            char[] arr = order.toCharArray();
            Arrays.sort(arr);
            order = new String(arr);

            for (int c : course) {
                if (order.length() >= c) {
                    makeComb(order, "", 0, c, countMap);
                }
            }
        }

        // course 길이별로 처리
        for (int c : course) {
            int max = 0;
            
            // 해당 길이에서 최대 value 찾기 (가장 많이 주문된 횟수)
            for (Map.Entry<String, Integer> entry : countMap.entrySet()) {
                String key = entry.getKey();
                int value = entry.getValue();

                if (key.length() == c && value >= 2) {
                    max = Math.max(max, value);
                }
            }

            // 최대 value와 같은 것만 추가 (동일한 주문 횟수)
            for (Map.Entry<String, Integer> entry : countMap.entrySet()) {
                String key = entry.getKey();
                int value = entry.getValue();

                if (key.length() == c && value == max && value >= 2) {
                    answer.add(key);
                }
            }
        }

        Collections.sort(answer); // 오름차순 정렬

        return answer.toArray(new String[0]);
    }

    // 재귀를 이용해 조합 생성
    private void makeComb(String order, String current, int idx, int target,
                          Map<String, Integer> countMap) {

        // 목표 길이에 도달하면 카운트
        if (current.length() == target) {
            countMap.put(current, countMap.getOrDefault(current, 0) + 1);
            return;
        }

        // 다음 문자 선택
        for (int i = idx; i < order.length(); i++) {
            makeComb(order, current + order.charAt(i), i + 1, target, countMap);
        }
    }
}
