import java.util.*;

class Solution {
    public int[] solution(int n, long k) {
        /// k번째 위치를 찾고 싶다면, 각 자리마다 하나씩 고정하면서 찾아보면 되지않을까?
        /// 전체 경우의 수에서 시작해서, 각 자리를 찾으면서 줄여나가는 방식
        
        int[] answer = new int[n]; // k번째 방법의 순서
        List<Integer> list = new ArrayList<>(); // n명의 순서를 저장하는 공간
        long factorial = 1;

        // 1부터 n까지의 숫자를 리스트에 담고, 전체 경우의 수(n!) 계산
        for (int i = 1; i <= n; i++) {
            list.add(i);
            factorial *= i;
        }

        k--; // 인덱스와 계산의 편의를 위해 1을 뺌
        int idx = 0;
        
        // 각 자리마다 순차적으로 계산 (0번째에서 와야되는 숫자, 1번째에서 와야되는 숫자...)
        while (n > 0) {
            // 한 블록(구간)의 크기 : (n-1)!
            /// ex. n=3일 때 첫 번째 자리가 결정되면 나머지로 만들 수 있는 경우의 수는 (3-1)!개
            /// (n-1)! == n! / n
            factorial = factorial / n; 
            
            // k / 한 블록의 크기 = 현재 자리에 올 숫자의 인덱스
            /// ex. n=3,k=5일 때 5 / (3-1)! => 5/2 = 2.xxx *(소수 제거)
            /// 즉, 2번째 인덱스인 "3"이 첫번째 자리로 위치하게 됨
            int currentIdx = (int) (k / factorial);
            
            // 리스트에서 꺼내 결과 배열에 담기
            // remove()를 통해 사용한 숫자는 리스트에서 제거
            // "3"이 첫번째에 고정되면 2,3번째 자리에서는 "3"이 나올 수 없기 때문
            answer[idx++] = list.remove(currentIdx);
            
            // 다음 자릿수를 구하기 위해 k를 나머지 값으로 갱신
            // n 감소 => while 조건 처리를 위함
            k %= factorial;
            n--;
        }

        return answer;
    }
}
