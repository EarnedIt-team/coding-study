package _251113.programmers;

import java.util.*;

public class 주식가격 {


    class Solution {
        public int[] solution(int[] prices) {
            // 자신보다 낮은게 나오면 그때 기록 or date카운팅을 멈춰야 함
            // stack -> 상승-유지세일때 저장 & 하락세일때 하나씩 빼기
            // 1 2 3 5  3 3 4 6   2 1 1 < val
            // 0 1 2 3  4 5 6 7   8 9 10 < ind

            int[] lasting = new int[prices.length];
            Stack<Integer> st = new Stack<>(); // 인덱스 스택

            for (int i = 0; i < prices.length; i++) {
                while (!st.isEmpty() && prices[i] < prices[st.peek()]) { // 하락세
                    int index = st.pop();
                    lasting[index] = i - index; // 지속된 기간 기록
                }
                st.push(i);
            }

            // 끝까지 하락안한 index처리
            while (!st.isEmpty()) {
                int index = st.pop();
                lasting[index] = prices.length - 1 - index;
            }

            return lasting;
        }
    }


// prices -> map / key : price / val : index(arrayList) ? 효율망할듯
}
