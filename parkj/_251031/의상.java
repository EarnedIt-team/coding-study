import java.util.*;

class Solution {
    public int solution(String[][] clothes) {
        HashMap<String, Integer> map = new HashMap<>();
        int answer = 1; // 경우의 수를 곱하기 위해 시작은 1
        
        // 의상 종류별 개수 세기
        for (String[] cloth : clothes) {
            // 의상이 있으면 +1, 없으면 0
            map.put(cloth[1], map.getOrDefault(cloth[1], 0) +1);
        }
        
        // 경우의 수 계산 (Stream)
        // reduce(초기값, (누적값, 현재값) -> 계산식)
        // (b + 1) : 각 종류에서 “입지 않는 경우”를 추가
        // ex. 얼굴(o) 상의(x) 하의(x) 겉옷(x)
        // ex2. 상의 2개 / 하의 2개 경우의 수 => 2*2 = 4 (x)
        //      상의 2개 / 하의 2개 경우의 수 => 3*3-1 = 8 (o)
        answer = map.values().stream().reduce(1, (a, b) -> a * (b + 1));

        // "전부" 아무것도 안 입는 경우 제외 (코니는 최소 한 개의 의상은 입음)
        return answer - 1;
    }
}
