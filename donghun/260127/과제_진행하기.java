import java.util.*;

class Solution {
    public String[] solution(String[][] plans) {
        // List 이용?
        // 작업 우선순위는 가장 최근에 멈춘 작업
        
        List<String> result = new ArrayList<>();
        
        // 시작 시간 순 정렬
        sort(plans);
        // 시간 정렬 확인
        // printArray(plans);
        
        과제처리(plans, result);
        
        return result.toArray(new String[0]);
    }
        
    class Task {
        String name;
        int remain;
        
        Task(String name, int remain) {
            this.name = name;
            this.remain = remain;
        }
    }
    
    // hh:mm -> 정수형 변환
    int timeConvert(String time) {
        String[] split = time.split(":");
        int hour = Integer.parseInt(split[0]) * 60;
        int minute = Integer.parseInt(split[1]);
        
        return (hour+minute);
    }
    
    void sort(String[][] plans) {
        Arrays.sort(plans, (a, b) -> {
            int timeA = timeConvert(a[1]);
            int timeB = timeConvert(b[1]);
            return timeA - timeB;
        });
    }
    
    void printArray(String[][] plans) {
        for(int i = 0; i < plans.length; i++) {
            System.out.println(plans[i][1]);
        }
    } 
    
    void 과제처리(String[][] plans, List<String> result) {
        Stack<Task> st = new Stack<>();
        
        for(int i = 0; i < plans.length; i++) {
            String name = plans[i][0];
            int start = timeConvert(plans[i][1]);
            int duration = Integer.parseInt(plans[i][2]);
            
            int endTime = start+duration;
            int nextStart = (i < plans.length-1) // 인덱스 방어조건 넣은 다음 시작 시간 미리 가져오기
                ? timeConvert(plans[i+1][1]) 
                : Integer.MAX_VALUE;
            
            // 다음 작업 시작 전에 끝남 (정답 배열 추가)
            if(endTime <= nextStart) {
                result.add(name);
                int currentTime = endTime;
                
                // 스택에 값이 존재하면서, task의 남은시간을 더한 값이 다음 시작 시간 전인 동안 반복
                while(!st.isEmpty() && currentTime < nextStart) {
                    Task task = st.pop();
                    
                    // 현재 시간+잔여시간 <= 다음 작업 시작시간
                    if(currentTime+task.remain <= nextStart) {
                        currentTime += task.remain;
                        result.add(task.name);
                    } else { // 현재 시간+잔여시간 > 다음 작업 시작시간
                        task.remain -= (nextStart - currentTime); // 잔여시간 업데이트
                        st.push(task); // 다시 멈춘 과제에 추가
                        break;
                    }
                }
            } else { // 다음 작업 시간을 초과했을 때 (멈춘 과제에 추가해야함)
                // 실제로 작업한 시간 = nextStart - start
                int workedTime = nextStart - start;
                st.push(new Task(name, duration - workedTime));
            }
        }
        
        // 남은 잔업들 
        while (!st.isEmpty()) {
            result.add(st.pop().name);
        }
    }
}