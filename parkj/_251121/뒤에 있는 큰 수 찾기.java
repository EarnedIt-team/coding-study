import java.util.*;

class Solution {
    public int[] solution(int[] numbers) {
        int n = numbers.length;
        int[] answer = new int[n];
        Arrays.fill(answer, -1); // 모든 값을 임시적으로 -1 처리

        Stack<Integer> stack = new Stack<>(); // 인덱스를 저장

        // stack에 들어있는 숫자(index)를 이용해서 처리
        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && numbers[stack.peek()] < numbers[i]) {
                answer[stack.pop()] = numbers[i];
            }
            stack.push(i);
        }

        return answer;
    }
}
