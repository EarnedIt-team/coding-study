package _251120.programmers;

import java.util.*;

public class 롤케이크_자르기__풀이2 {

    class Solution {
        public int solution(int[] topping) {
            // 나눴을 때 숫자종류의 개수가 동일한 경우의 수 -> left/right카운트보다 누적합
            // -> 아 ... 중복이 있을 수 있으므로 1way 누적합은 안되겠구나 .... 그래도 아까우니 누적합 구현

            int len = topping.length;

            HashSet<Integer> set = new HashSet();
            int[] leftNu = new int[len];
            set.add(topping[0]);
            leftNu[0] = 1;
            for(int i = 1; i < len; i++) {
                if(!set.contains(topping[i])) { // new종류등장
                    set.add(topping[i]);
                    leftNu[i] = leftNu[i-1] + 1;
                }
                else leftNu[i] = leftNu[i-1]; // 기존종류
            }

            HashSet<Integer> set2 = new HashSet();
            int[] rightNu = new int[len];
            set2.add(topping[len-1]);
            rightNu[len-1] = 1;
            for(int i = len-2; i >= 0; i--) {
                if(!set2.contains(topping[i])) { // new종류등장
                    set2.add(topping[i]);
                    rightNu[i] = rightNu[i+1] + 1;
                }
                else rightNu[i] = rightNu[i+1]; // 기존종류
            }


            int answer = 0;
            boolean done = false;
            for(int i = 0; i < topping.length-1; i++) {
                if(leftNu[i] == rightNu[i+1]){
                    answer++;
                    done = true;
                }
                else { if(done) break; } // 공평 구간은 한번(연속ok) 나온 후엔 다신 안나옴
            }


            return answer;
        }
    }
}
