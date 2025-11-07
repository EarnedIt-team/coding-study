import java.util.*;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        // day를 거듭해가며 각자 speed만큼 작업을 완료할 수 있음.
        // 예시 1, [93, 30, 55] [1, 30, 5] 
        // 93은 1씩 7일, 30은 30씩 3일째에 완성 (하지만 앞에 7일째에 함께 꺼내짐)
        // 55는 5씩 9일
        // 결국 for문 돌며 각각의 임계점에 대한 계산이 되고 있어야하고, 앞의 블록이 꺼내질 때 뒤 블록도 조건이 맞다면
        // 함께 꺼내지도록 (스택에서) 
        
        // 정답 리스트
        List<Integer> list = new ArrayList<>();
        
        int len = speeds.length;
        // 작업 진도와 작업 속도 합친 배열
        int[][] process = new int[len][2];
        
        // 값 삽입
        for(int i = 0; i < len; i++) {
            process[i][0] = progresses[i];
            process[i][1] = speeds[i];
        }
        
        // 담을 스택 (역순으로 담아야 함)
        Stack<int[]> stack = new Stack<>();
        for(int i = len-1; i >= 0; i--) {
            stack.push(process[i]);
        }
        
        int day = 0;
        
        // 각각 작업 진도 증가
        while(!stack.isEmpty()) {
            day++;
            // 모든 작업 각각의 진도만큼 진척도 증가
            for(int i = 0; i < len; i++) {
                process[i][0] += process[i][1];
            }
            
            // 스택에서 꺼낸 개수 카운트
            int count = 0;
            // stack에 값이 있고, top을 꺼냈을 때 0번째 인덱스가 100을 넘는 동안 계속 꺼냄
            while (!stack.isEmpty() && stack.peek()[0] >= 100) {
                int[] done = stack.pop(); // 스택의 맨 위 요소 가져오기
                // System.out.println(Arrays.toString(done));
                count++;
            }
            
            if(count != 0) list.add(count);
        }
        
        return list.stream().mapToInt(Integer::intValue).toArray();
    }
}