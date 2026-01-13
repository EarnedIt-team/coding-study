import java.util.*;

class Solution {
    public int solution(String str1, String str2) {
        /// 유사도 값은 0 ~ 1 사이의 실수이기에, 결과값에 "65536"을 곱하고 정수로만 출력한다.
        
        // 윈소를 저장하는 ArrayList
        List<String> list1 = new ArrayList<>(), list2 = new ArrayList<>();
        int anbCount = 0; // 교집합 개수 (A ∩ B)
        int aubCount = 0; // 합집합 개수 (A ∪ B)
        
        // 각 문자열에서 다중집합 원소 구하기
        list1 = getElementList(str1);
        list2 = getElementList(str2);

        // 모두 공집합인 경우 나눗셈이 정의되지 않아 유사도는 1
        if (list1.isEmpty() && list2.isEmpty()) return 1 * 65536;
        
        // 교집합 계산을 위해 하나의 집합을 복사
        List<String> copyList2 = new ArrayList<>(list2);

        // 교집합 구하기 (A ∩ B)
        for (String s : list1) {
            // list1 원소중에 list2에 포함되는 원소가 있는가?
            if (copyList2.contains(s)) {
                anbCount++;
                copyList2.remove(s); // 중복 방지
            }
        }

        // 합집합 구하기 (A ∪ B) = A + B - (A ∩ B)
        aubCount = list1.size() + list2.size() - anbCount;

        // 자카드 유사도
        return (int) (((double) anbCount / (double) aubCount) * 65536);
    }

    // 문자열에서 원소 구하기
    List<String> getElementList(String str) {
        str = str.toLowerCase(); // 대소문자 무시
        List<String> list = new ArrayList<>();
        for (int i = 0; i < str.length() - 1; i++) {
            // 영문자인지 체크 (= isLetter)
            if (Character.isLetter(str.charAt(i)) && Character.isLetter(str.charAt(i + 1))) {
                list.add("" + str.charAt(i) + str.charAt(i + 1)); // 두 글자씩 끊어서 원소 생성
            }
        }
        return list;
    }
}
