import java.util.*;

class Solution {
    public int solution(String[] want, int[] number, String[] discount) {
        // 자신이 원하는 제품&수량 == 할인하는 10일 연속 날짜
        int answer = 0;
        HashMap<String, Integer> wantItem = new HashMap<>(); // want & number
        
        // 원하는 제품 및 수량을 map으로 변환
        for (int i=0; i < want.length; i++) {
            wantItem.put(want[i], number[i]);
        }

        // 10일 단위로 끊어서 처리
        for (int i=0; i < discount.length-9; i++) {
            HashMap<String, Integer> discountItem = new HashMap<>(); // discount

            // 10일간 할인 제품 & 수량을 map으로 변환
            // i+j : 시작 날짜 기준점(i)을 함께 전달해줘야 10일 단위 처리가 가능.
            // 만약 i를 더해주지 않으면, 0 ~ 10일이 매번 반복되는 등 결과물이 발생.
            for (int j = 0; j < 10; j++) {
                discountItem.put(discount[i+j], discountItem.getOrDefault(discount[i+j], 0) + 1);
            }

            // 원하는 제품&수량 == 10일간 할인 제품&수량
            answer += wantItem.equals(discountItem) ? 1 : 0;
        }
        
        return answer;
    }
}
