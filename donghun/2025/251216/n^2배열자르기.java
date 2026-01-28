import java.util.*;

class Solution {
    public int[] solution(int n, long left, long right) {
        // 주어진 left ~ right가 n으로 나뉜 몫은 행의 값
        // 주어진 left ~ right가 n으로 나눈 나머지는 열의 값
        // 행과 열의 값을 비교해서 더 큰값 +1 하면 해당 이차원배열의 데이터를 가져올 수 있음
        
        List<Integer> result = new ArrayList<>();
        
        for (long i = left; i <= right; i++) {
            long row = i / n;
            long col = i % n;
            result.add((int) (Math.max(row, col) + 1));
        }
        
        int[] answer = new int[(int)(right - left + 1)]
        
        int[] answer = new int[result.size()];
        
        for(int i = 0; i < answer.length; i++) {
            answer[i] = result.get(i);
        }
        
        return answer;
    }
}