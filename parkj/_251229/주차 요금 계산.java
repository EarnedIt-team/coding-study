import java.util.*;

class Solution {
    public int[] solution(int[] fees, String[] records) {
        // 주차장 입-출차 기록이 제공되고, 차량별로 주차 요금을 계산하려고 한다. 
        // 기본 시간 / 요금 : fees[0], fees[1] 
        // 추가 시간 / 요금 : fees[2], fees[3] 
        // 계산하는 시간이 단위 시간으로 나누어 떨어지지 않으면 올림 처리 (24분 -> 30분) 
        // 만약, 입차후에 기록이 없으면 23:59분에 출차된 것으로 간주
        /// 하나 주의할 점은 "누적 주차 시간"을 기준으로 일괄 정산하기에,
        /// OUT 나온다고 매번 계산하면 기본 요금이 계속 부과되는 등 계산 오차가 발생
        
        int index = 0; // 차량 index
        int carCurrentTime = -1; // 입차 시간
        ArrayList<Integer> answer = new ArrayList<>();
        ArrayList<Integer> totalTimes = new ArrayList<>(); // 차량별 누적 시간

        // 차량번호 기준 정렬
        Arrays.sort(records, (a, b) -> {
            String numA = a.split(" ")[1];
            String numB = b.split(" ")[1];
            return numA.compareTo(numB);
        });

        // 첫 차량
        String carNum = records[0].split(" ")[1];
        answer.add(0); // 첫 차량의 요금은 0원
        totalTimes.add(0); // 첫 차량의 누적시간은 0분

        for (String record : records) {
            String recordTime = record.split(" ")[0]; // 시간
            String recordCar = record.split(" ")[1]; // 차량번호
            String recordAction = record.split(" ")[2]; // 입출차

            // 다른 차량이 들어왔을 때
            if (!carNum.equals(recordCar)) {
                // 이전 차량이 입차 상태면 23:59 기준으로 처리
                if (carCurrentTime != -1) {
                    totalTimes.set(index, totalTimes.get(index) + (1439 - carCurrentTime));
                    carCurrentTime = -1;
                }

                carNum = recordCar;
                index++;
                answer.add(0);
                totalTimes.add(0);
            }
            
            // 시간 String -> Int로 변환 (분)
            int time = Integer.parseInt(recordTime.substring(0, 2)) * 60
                     + Integer.parseInt(recordTime.substring(3));
            
            // 입차
            if (recordAction.equals("IN")) {
                carCurrentTime = time;
            } else {
                // 출차
                totalTimes.set(index, totalTimes.get(index) + (time - carCurrentTime));
                carCurrentTime = -1;
            }
        }

        // 남은 차량이 존재한다면 (즉, 입차하고 출차를 안함)
        if (carCurrentTime != -1) {
            totalTimes.set(index, totalTimes.get(index) + (1439 - carCurrentTime));
        }

        // 요금 일괄 정산
        for (int i = 0; i < totalTimes.size(); i++) {
            answer.set(i, calcFee(totalTimes.get(i), fees));
        }

        return answer.stream().mapToInt(Integer::intValue).toArray();
    }

    // 요금 계산
    private int calcFee(int totalTime, int[] fees) {
        int totalMoney = fees[1]; // 기본 요금

        // 기본 시간을 초과했을 때
        if (totalTime > fees[0]) {
            int extraTime = totalTime - fees[0];
            int unit = (extraTime + fees[2] - 1) / fees[2];
            totalMoney += unit * fees[3];
        }

        return totalMoney;
    }
}
