import java.util.*;

class Solution {
    public int solution(String[] want, int[] number, String[] discount) {
        // 정현이가 원하는 제품 : 바나나(3), 사과(2), 쌀(2), 돼지고기(2), 냄비(1)
        
        // XYZ 마트에서 14일간 할인하는 제품 (날짜 순서대로)
        // 치킨(1), 사과(2), 사과(3), 바나나(4), 쌀(5), 사과(6), 돼지고기(7), 바나나(8), 돼지고기(9), 
        // 쌀(10), 냄비(11), 바나나(12), 사과(13), 바나나(14)
        // 3, 4, 5가 원하는 제품을 모두 구매할 수 있는 회원 자격 갱신 날짜
        
        // 원하는 물건과 개수를 저장하는 Map
        Map<String, Integer> want_map = new HashMap<>(); 

        // 정답 변수
        int answer = 0;
        
        // Map에 삽입
        for(int i = 0; i < want.length; i++) {
            want_map.put(want[i], number[i]);
        }
        
        // 시작 날짜 기준 for문
        for(int i = 0; i <= discount.length - 10; i++) {
            // discount 물건의 개수를 카운팅하는 map
            Map<String, Integer> dis_map = new HashMap<>();
            
            // 시작 날짜 기준 +10일까지 품목 카운팅
            for(int j = i; j < i+10; j++) {
                dis_map.put(discount[j], dis_map.getOrDefault(discount[j], 0) + 1);
            }
            
            boolean check = true;
            for(String item : want_map.keySet()) {
                // dis_map에서 값을 꺼낼 땐 존재하지 않을 수 있으니 getOrDefault() 사용
                if(dis_map.getOrDefault(item, 0) < want_map.get(item)) {
                    check = false;
                    break;
                }
            }
            
            if(check) answer++;
        }
        
        return answer;
    }
}