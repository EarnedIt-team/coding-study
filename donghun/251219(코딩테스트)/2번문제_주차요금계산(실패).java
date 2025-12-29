import java.util.*;

class Solution {
    public int[] solution(int[] fees, String[] records) {
        // 출차가 기록되지 않은 경우 당일 23:59 출차한것
        
        int 기본시간 = fees[0]; int 기본요금 = fees[1];
        int 단위시간 = fees[2]; int 단위요금 = fees[3];
        
        Map<String, String[]> map = new HashMap<>();
        List<Integer> result = new ArrayList<>(); 
        
        for(String s : records) {
            String[] record = s.split(" ");
            String time = record[0];
            String carNum = record[1];
            String InOut = record[2];
            
            // 최초 IN이라면 map에 해당 번호의 입차시간 등록
            if(map.get(carNum) == null && InOut.equals("IN")) {
                map.put(carNum, new String[]{time, "IN", "0"});
            } else if(map.get(carNum) != null && InOut.equals("IN")){ 
                map.put(carNum, new String[]{time, "IN", map.get(carNum)[2]});
            }
            
            // map에 등록된 입차시간과 현재 출차 시간을 이용해 요금 계산
            if(InOut.equals("OUT")) {
                // 요금 계산 로직
                int out = timeToInteger(time);
                int in = timeToInteger(map.get(carNum)[0]);
                int diff = out - in;
                map.put(carNum, new String[]{time, "OUT", ""+diff});
            }
        }
        
        // 오름차순 정렬
        List<String> carNums = new ArrayList<>(map.keySet());
        Collections.sort(carNums); 
        
        for(String carNum : carNums) {
            String[] info = map.get(carNum);
            int totalTime;
            
            if (info[1].equals("IN")) {
                int current_diff = Integer.parseInt(info[2]);
                totalTime = current_diff + (timeToInteger("23:59") - timeToInteger(info[0]));
            } else {
                totalTime = Integer.parseInt(info[2]);
            }
            
            result.add(요금계산(totalTime, 기본시간, 기본요금, 단위시간, 단위요금));
        }
        
//         for(Map.Entry<String, String[]> entry : map.entrySet()){
//             // 마지막 기록이 IN 상태일 때 
//             if(entry.getValue()[1].equals("IN")) {
//                 int current_diff = Integer.parseInt(entry.getValue()[2]);
        
            
//                 int time_diff = timeToInteger("23:59") - timeToInteger(entry.getValue()[0]);
//                 result.add(요금계산((time_diff+current_diff), 기본시간, 기본요금, 단위시간, 단위요금));
                
//             } else {
//                 int 누적주차시간 = Integer.parseInt(entry.getValue()[2]);
//                 result.add(요금계산(누적주차시간, 기본시간 ,기본요금, 단위시간, 단위요금));
//             }
//         }
        
        // 정답 출력
        int[] answer = new int[result.size()];
        for(int i = 0; i < answer.length; i++) {
            answer[i] = result.get(i);
        }

        return answer;
    }
    
    // 시간 계산 메서드
    private int timeToInteger(String time) {
        String[] split = time.split(":");
        int hour = Integer.parseInt(split[0]) * 60;
        int min = Integer.parseInt(split[1]);
        
        return hour+min;
    }
    
    // 요금 계산 메서드
    private int 요금계산(int 누적주차시간, int 기본시간, int 기본요금, int 단위시간, int 단위요금) {
        if(누적주차시간 <= 기본시간) {
            return 기본요금;
        }
        int 초과 = 누적주차시간-기본시간;
        int 단위횟수 = 초과 / 단위시간;
        
        if(초과 % 단위시간 != 0) 단위횟수++;
        
        return 기본요금 + (단위횟수 * 단위요금);
    }
}

          
               