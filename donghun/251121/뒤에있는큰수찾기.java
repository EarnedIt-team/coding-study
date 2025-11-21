import java.util.*;

class Solution {
    public int[] solution(int[] numbers) {
        
        int len = numbers.length;
        int[] answer = new int[len];
        Arrays.fill(answer, -1);
        
        Stack<Integer> st = new Stack<>();
        
        for(int i = 0; i < len; i++) {
            // 스택의 인덱스에 해당하는 값들보다 큰 값이 나왔을 때, 스택에 저장된 인덱스에 큰 값으로 모두 삽입
            while(!st.isEmpty() && (numbers[st.peek()] < numbers[i])) {
                int idx = st.pop();
                answer[idx] = numbers[i];
            } 
            st.push(i);
        }
        
        // i = 0 : st [0], answer {-1, -1, -1, -1}
        // i = 1 : st [0], answer {-1, -1, -1, -1}
        // st.peek() = 0, numbers[0] < numbers[1] ->  answer {3, -1, -1, -1}
        // i = 2 : st [1], answer {3, -1, -1, -1}
        // i = 3 : st [2, 1], answer {3, -1, -1, -1}
        // st.peek() = 2, numbers[2] < numbers[3] -> answer {3, -1, 5, -1}
        // st.peek() = 1, numbers[1] < numbers[3] -> answer {3, 5, 5, -1}
        
        return answer;
    }
}