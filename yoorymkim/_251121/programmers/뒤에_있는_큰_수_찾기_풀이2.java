package _251121.programmers;

import java.util.*;

public class 뒤에_있는_큰_수_찾기_풀이2 {

    class Solution {
        public int[] solution(int[] numbers) {
            // 자신보다 뒤에 있는 숫자 + 자신보다 큼 + 가장 가까이 있는 수
            // 2중 for문 해결방안 : 해시맵 x / 해시셋 x / 리스트 x / 스택 -> 유력 / 큐 -> 스택보단 덜? / ...
            // 2중 서치를 완전히 피할 수는 없다, 하나 잡고 뒷쪽거를 서치해야하니 .. 대신 내부 for문 부하 줄이기 !!!

            // 정렬 사용 ??!!!!!!! <- 기존 index저장 필요 !
            // val : [9, 1, 5, 3, 6, 2] -> [1, 2, 3, 5, 6, 9]
            // ind : [0, 1, 2, 3, 4, 5] -> [1, 5, 3, 2, 4, 0]
            // 위치 뒷쪽에서 본인보단크고ind+가장작은ind를 가진 수 반환하면 됨 <- 본래풀이보다 나은점이 없는 ...? 머리야

            // 스택의 장점 : 조건하에 넣어두고, 나중에 가장먼저 확인가능 & pop으로 이미 쓴애는 아예 삭제 가능
            // 적합한 부분은 뭔가 : 조건 중 가장 근접한 애를 찾기에 효율적인 느낌

            // 스택에 뭘 넣을 것인가 : 1회턴마다 안되는 애들 ?
            // 스택에서 빼는 시점은 언제인가 : 쓸때 ?
            // 주의할거 : st에서 쓰면 완전 사라짐, 중복뒷큰수 처리불가. st에 중복없는 ind 삽입?

            int len = numbers.length;
            int[] answer = new int[len];
            Arrays.fill(answer, -1); // 각각 못 찾은걸로 초기화

            Stack<Integer> st = new Stack<>();
            for(int i = 0; i < len; i++) {
                while(!st.isEmpty() && numbers[st.peek()] < numbers[i]) {
                    answer[st.pop()] = numbers[i];
                }
                st.push(i);
            }

            return answer;
        }
    }
}
