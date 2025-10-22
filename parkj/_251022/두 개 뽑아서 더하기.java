import java.util.*;

class Solution {
    public int[] solution(int[] numbers) {
        // Set : "중복된 원소"를 허용하지 않는 집합체
        Set<Integer> set = new HashSet<>();
        
        // 조합의 모든 수를 set에 추가
        for (int i = 0; i < numbers.length; i++) {
            for (int j = i + 1; j < numbers.length; j++) {
                set.add(numbers[i] + numbers[j]);
            }
        }
        
        // 람다식으로 처리
        // stream() : 저장 요소를 하나씩 참조해서 람다식으로 처리할 수 있도록 해주는 반복자 (Stream<Integer>)
        // mapToInt(Integer::intValue) : Integer 객체를 기본형 int로 변환
        // mapToInt(Integer::intValue) == mapToInt(i -> i)
        // sorted() : stream의 요소를 오름차순으로 정렬
        // toArray() : int배열로 변환 (Stream<Integer> -> int[])
        return set.stream().mapToInt(i -> i).sorted().toArray();
    }
}
