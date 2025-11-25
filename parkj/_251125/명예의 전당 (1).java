import java.util.*;

class Solution {
    public int[] solution(int k, int[] score) {
        int[] answer = new int[score.length];
        int[] numList = new int[score.length]; // 최대 score 길이만큼 확보

        for (int i = 0; i < score.length; i++) {
            numList[i] = score[i]; // 점수 추가

            // 현재까지의 점수들만 복사해서 정렬
            /// Arrays.copyOf(원본배열, 새배열길이)
            int[] temp = Arrays.copyOf(numList, i + 1);
            Arrays.sort(temp); // 오름차순 정렬
            
            // 아직 k개가 안 됐으면 전체 중 최솟값 (오름차순)
            if (i+1 < k) {
                answer[i] = temp[0];
            // k개 이상이면 k번째 큰 값 → 정렬 후 (length - k) 위치
            // k = 3 [1, 3, "25", 28, 100] (5 - k = 2)
            // [20] 추가
            // [1, 3, 20, "25", 28, 100] (6 - k = 3)
            // [27] 추가
            // [1, 3, 20, 25, "27", 28, 100] (7- k = 4)
            } else {
                answer[i] = temp[temp.length - k];
            }
        }

        return answer;
    }
}
