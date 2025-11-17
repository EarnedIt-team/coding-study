package _251117.programmers;

import java.util.*;

public class 튜플_풀이 {

    class Solution {
        public int[] solution(String s) {
            // ??? 중복이 불가능했었다 ???????? 문제조건 잘 읽자......
            // 아니근데 튜플이 1 2 3 5 인지 5 2 3 1 인지 어떻게 알지 ......

            // (2, 1, 3, 4) 이면 {{2}, {2, 1}, {2, 1, 3}, {2, 1, 3, 4}}로 순서대로 주는거 ?!
            // 이런 조건은 문제에 적어줬어야하는거 아니냐 ㅠ .....

            s = s.substring(2, s.length() - 2);
            String[] arr = s.split("},\\{"); // 각 집합만 잘라서 배열에 string저장

            // string 길이순 정렬
            Arrays.sort(arr, Comparator.comparingInt(String::length));

            HashSet<Integer> set = new HashSet<>();
            int[] answer = new int[arr.length]; // 1개씩 늘어나므로 배열개수 == 튜플원소개수
            int i = 0;

            for (String str : arr) {
                StringTokenizer st = new StringTokenizer(str, ",");
                while (st.hasMoreTokens()) {
                    int num = Integer.parseInt(st.nextToken());
                    if (!set.contains(num)) {
                        set.add(num);
                        answer[i++] = num;
                    }
                }
            }
            return answer;
        }
    }
}
