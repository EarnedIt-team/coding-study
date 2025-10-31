package _251031.programmers;

import java.util.*;

public class 푸드_파이트_대회__풀이2 {

    class Solution {
        public String solution(int[] food) {
            // food index:칼로리(0은 물), val:개수(/2하여 대칭배치사용)
            StringBuilder sb = new StringBuilder();

            for (int i = 1; i < food.length; i++) { // 물(0)제외
                for (int j = 0; j < food[i]/2; j++) {
                    sb.append(i); // + "" 안해도 잘 추가됨(실행속도개선)
                }
            }

            String rev = new StringBuilder(sb).reverse().toString();

            return sb.append(0).append(rev).toString();
        }
    }
}
