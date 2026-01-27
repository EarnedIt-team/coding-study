import java.util.*;

class Solution {
    public String[] solution(String[][] plans) {
        // 진행중이던 과제
        // 가장 최근에 멈춘 과제부터 시작하기에, 후입선출인 Stack 사용
        Stack<String[]> tasks = new Stack<>(); // [과제이름, 남은시간]
        List<String> answer = new ArrayList<>();
        
        // 시간순으로 정렬
        Arrays.sort(plans, (a, b) -> changeTime(a[1]) - changeTime(b[1]));
        
        // 과제 계획 진행
        for (int i = 0; i < plans.length; i++) {
            String name = plans[i][0]; // 과제 이름
            
            // 마지막 과제인 경우
            if (i == plans.length - 1) {
                answer.add(name);
                break;
            }
            
            int start = changeTime(plans[i][1]); // 시작 시간
            int playtime = Integer.parseInt(plans[i][2]); // 수행 시간
            int nexttime = changeTime(plans[i + 1][1]); // 다음 과제 시작 시간
            
            // 1-1. 시작 시간 + 수행 시간이 다음에 오는 과제 전에 끝낼 수 있는가?
            if (start + playtime <= nexttime) {
                answer.add(name); // 과제 완료
                int currentTime = start + playtime; // 완료하고 현재 시간
                
                // 2. 진행중이던 과제가 남아 있는가?
                while (tasks.size() > 0) {
                    String[] task = tasks.pop(); // 꺼내옴
                    int getRemainTime = Integer.parseInt(task[1]); // 남은 시간 가져오기
                    
                    // 3-1. 다음 과제 시작 전에 진행 중이던 과제를 처리할 수 있는가?
                    if (currentTime + getRemainTime <= nexttime) {
                        answer.add(task[0]);
                        currentTime += getRemainTime;
                    } else {
                        // 3-2. 시간 부족, 잔여 시간은 다시 조정해서 Stack에 추가
                        pushToStack(tasks, task[0], getRemainTime - (nexttime - currentTime));
                        break;
                    }
                }
            } else {
                // 1-2. 현재 과제를 처리하기에는 시간 부족, Stack에 추가
                pushToStack(tasks, name, playtime - (nexttime - start));
            }
        }
        
        // 남은 잔업 후처리
        while (tasks.size() > 0) answer.add(tasks.pop()[0]);
        
        return answer.toArray(new String[0]);
    }
    
    // 시간 String -> Int로 변환
    int changeTime(String time) {
        String[] split = time.split(":");
        return Integer.parseInt(split[0]) * 60 + Integer.parseInt(split[1]);
    }
    
    // 잔여 작업 Stack에 추가
    void pushToStack(Stack<String[]> stack, String name, int remainTime) {
        stack.push(new String[]{name, String.valueOf(remainTime)});
    }
}
