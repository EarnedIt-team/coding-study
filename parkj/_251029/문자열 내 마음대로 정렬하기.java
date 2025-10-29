import java.util.*;

class Solution {
    public String[] solution(String[] strings, int n) {
        // 배열에서 가져온 문자열 a 와 b 값에 따라 정렬의 기준이 정해진다. (람다식 Comparator)
        // a > b (양수) : a가 b보다 뒤
        // a < b (음수) : a가 b보다 앞
        // a == b (0) : a와 b가 서로 같음
        
        Arrays.sort(strings, (a, b) -> {
            // n번째 글자가 서로 같다면, "문자 전체"를 사전순으로 정렬합니다.
            if (a.charAt(n) - b.charAt(n) == 0) {
                // A.compareTo(B) : 문자(char)의 유니코드 값(ASCII 값)을 비교 (A의 문자 - B의 문자)
                return a.compareTo(b);
            } else {
                // n번째 글자가 서로 다르다면, 유니코드 값 차이만큼 반환하면 정렬이 거기에 맞게 됨
                return a.charAt(n) - b.charAt(n);
            }
        });
        return strings;
    }
}
