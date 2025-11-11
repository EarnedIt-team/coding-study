package _251111.programmers;

import java.util.*;

public class 더_맵게__풀이4 {

    class Solution {
        public int solution(int[] scoville, int K) {
            Arrays.sort(scoville);
            int n = scoville.length;
            int answer = 0;
            int start = 0; // 현재 최소 인덱스(소비된 개수)

            while (start < n - 1 && scoville[start] < K) {
                int newVal = scoville[start] + scoville[start + 1] * 2;
                answer++;
                // 두 개 소비했으니 start를 두 칸 앞으로 옮겨야 할 것 같지만,
                // 두 번째 자리에 newVal을 덮어쓰고 start만 1 증가시키는 기존 패턴을 그대로 유지
                scoville[start + 1] = newVal; // 새 값이 start+1에 있음
                start++;

                // [start .. n) 구간은 정렬 상태인데, scoville[start] 하나만 제자리일 수 있음
                // 이 값을 [start+1 .. n) 사이에서 이진탐색으로 위치 찾아 넣기
                int val = scoville[start];

                int insert = Arrays.binarySearch(scoville, start + 1, n, val);
                if (insert < 0) insert = -insert - 1;

                // [start+1 .. insert) 를 한 칸 왼쪽으로 땡기고, insert-1 위치에 val 삽입
                // (길이가 0일 수 있으니 길이 체크)
                int len = insert - (start + 1);
                if (len > 0) {
                    System.arraycopy(scoville, start + 1, scoville, start, len);
                }
                scoville[insert - 1] = val;
            }

            return scoville[start] < K ? -1 : answer;
        }
    }
}
