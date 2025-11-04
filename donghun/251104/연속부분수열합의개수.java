import java.util.*;

class Solution {
    public int solution(int[] elements) {
        // i = 1부터 수열의 길이만큼까지 더하기 (elements.length())
        // 더하면서 나오는 모든 수열의 합을 Set에 저장
        
        Set<Integer> set = new HashSet<>();
        int length = elements.length;

        for (int i = 0; i < length; i++) {
            int sum = 0;

            // 부분 수열의 길이를 1부터 length까지 늘려가며 합산
            for (int j = 0; j < length; j++) {
                int index = (i + j) % length; // 인덱스 초과 방지 (순환 구조)
                sum += elements[index];
                set.add(sum);
            }
        }

        return set.size();
    }
}