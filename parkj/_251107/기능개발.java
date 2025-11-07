import java.util.*;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        ArrayList<Integer> answer = new ArrayList<>();
        
        int day = 0; // 작업하는데 걸린 일 수
        int amount = 0;
        
        for(int i=0; i<progresses.length; i++) {
            // 배포가 가능하다면 (100% 작업)
            // == 앞에 있는 기능이 개발되는 동안(day) 뒤에 있는 기능이 개발이 완료되었다면
            if (progresses[i] + (speeds[i] * day) >= 100) {
                amount++;
                continue;
            // 배포가 안된다면 (100% 미만 작업)
            } else {
                // 이전까지 가능한 작업들 모두 배포
                if (amount != 0) {
                    answer.add(amount);
                    amount = 0;
                }
                // 작업
                while (progresses[i] + (speeds[i] * day) < 100) {
                    day++;
                }
                amount++;
            }
        }
        
        // 마지막으로 배포가 가능한 작업들이 있는지 체크
        if (amount != 0) {
            answer.add(amount);
        }
        
        return answer.stream().mapToInt(i -> i).toArray();
    }
}
