import java.util.*;

class Solution {
    public int solution(int[] citations) {
        // H-Index = 인용 횟수가 h번 이상인 논문이 h편 이상
        // H-Index 최대값 : 논문의 개수
        // H-Index를 큰 값부터 검사 (낮은 숫자에서 걸릴수도 있기에)
        for (int h = citations.length; h >= 0; h--) {
            // 람다 함수에서 사용되는 값이 "변경되지" 않아야 한다. (final or effectively final)
            final int h_Index = h;
            
            // citations 배열에서 / 현재 인용횟수(citation) >= h_Index / 인 개수가 h_Index 이상인가?
            boolean isCheck = Arrays.stream(citations)
                    .filter(citation -> citation >= h_Index)
                    .count() >= h_Index;

            if (isCheck) return h;
        }

        return 0;
    }
}
