package _251128.programmers;

import java.util.*;

public class 택배상자__풀이2 {

    class Solution {
        public int solution(int[] order) {
            // 한 방향으로만 진행이 가능해서 벨트에 놓인 순서대로(1번 상자부터) 상자를 내릴 수 있습니다. <= for문, 배열?
            // 맨 앞에 놓인 상자가 현재 트럭에 실어야 하는 순서가 아니라면 -> 보조 컨테이너 벨트는 입구 외에 다른 면이 막혀 있어서 맨 앞의 상자만 뺄 수 있습니다 <= Stack
            // 보조 컨테이너 벨트를 이용해도 기사님이 원하는 순서대로 상자를 싣지 못 한다면, 더 이상 상자를 싣지 않습니다.

            Stack<Integer> st = new Stack<>();
            int answer = 0;
            int n = 1;
            for (int o : order) {
                // 원하는거 나올 때까지 일단 push
                while (n <= o) {
                    st.push(n);
                    n++;
                }
                // 스택 top이 원하는거여야함
                if (!st.isEmpty() && st.peek() == o) {st.pop(); answer++;}
                else break;
            }
            return answer;
        }
    }
}
