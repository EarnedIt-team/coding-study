import java.util.*;

class Solution {
    public int solution(int[] topping) {
        int answer = 0;

        /// 왼쪽 : 새로 만들어진 케이크
        /// 오른쪽 : 기존 케이크 (원본)
        /// 왼쪽 -> 오른쪽 방향으로 진행되고,
        /// 그 과정에서 왼쪽 케이크는 +, 오른쪽 케이크는 - 되면서 변화합니다.
        /// 오른쪽 케이크는 원본이기에, 기존 토핑의 종류와 개수를 기억해서 조건에 맞게 처리해야됩니다.
        /// 동일하게 set으로 remove 처리하게 되면 뒤에 동일한 종류의 토핑이 있어도 제거되었다고 판단되기에 결과값이 달라집니다.
        /// [1,2,1,1] <- 원본
        /// [1,2] [1,1] <- 두개로 나눔
        /// [1,2] [] <- 다음번에 그대로 remove 하면 오른쪽은 전부 사라짐 (원래 같으면 1이 남아 있어야 함)
      
        // 오른쪽 토핑 개수 (중복O)
        Map<Integer, Integer> rightCount = new HashMap<>();
        for (int t : topping) rightCount.put(t, rightCount.getOrDefault(t, 0) + 1);

        // 왼쪽, 오른쪽 중복X 토핑 개수
        Set<Integer> left = new HashSet<>();
        Set<Integer> right = new HashSet<>(rightCount.keySet());

        for (int t : topping) {
            // 왼쪽에 토핑 추가
            left.add(t);

            // 오른쪽 토핑 개수 감소
            // 감소 시키기전 값이 1이라면, 감소 이후에는 0이기에 토핑은 제거합니다.
            if (rightCount.put(t, rightCount.get(t) - 1) == 1) right.remove(t);

            // 종류 수 비교
            if (left.size() == right.size()) answer++;
        }

        return answer;
    }
}
