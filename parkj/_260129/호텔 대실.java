import java.util.*;

class Solution {
    public int solution(String[][] book_time) {
        int[][] times = new int[book_time.length][2]; // 수정된 book_time
        List<Integer> rooms = new ArrayList<>(); // 현재 이용중인 방
        
        // 기존 book_time + 청소 시간 포함
        // String -> Int로 변환 (분 단위)
        for (int i = 0; i < book_time.length; i++) {
            times[i][0] = changeTime(book_time[i][0]);
            times[i][1] = changeTime(book_time[i][1]) + 10; // 청소 시간 포함
        }
        
        // 시간이 빠른 순서대로 정렬
        Arrays.sort(times, (a, b) -> a[0] - b[0]);
        
        // 예약된 시간 순서대로 처리
        for (int[] time : times) {
            boolean isCheckIn = false;

            // 지금 이용가능한 방이 있는가?
            for (int i = 0; i < rooms.size(); i++) {
                // 해당 방의 퇴실 시간이 다른 사람의 입장시간과 같거나, 이미 시간을 넘겼다면(= 작다면) 
                if (rooms.get(i) <= time[0]) {
                    rooms.set(i, time[1]); // 퇴실 시간 갱신
                    isCheckIn = true;
                    break;
                }
            }

            // 방이 없다면 새로운 방 추가
            if (!isCheckIn) rooms.add(time[1]);
        }

        return rooms.size();
    }

    // String -> Int 변환
    int changeTime(String time) {
        String[] split = time.split(":");
        return Integer.parseInt(split[0]) * 60 + Integer.parseInt(split[1]);
    }
}
