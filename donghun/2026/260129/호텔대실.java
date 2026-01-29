import java.util.*;

class Solution {
    public int solution(String[][] book_time) {
        
        // 대실 가능한 방을 관리
        Map<Integer, int[]> room = new HashMap<>();
        int room_number = 1;
        
        // 대실 시작 시간 순서로 정렬
        sort(book_time);
        
        // 확인
        // printArray(book_time);
        
        // 대실 가능한 최소 객실 수 탐색
        for(int i = 0; i < book_time.length; i++) {
            String[] duration = book_time[i];
            int start = timeConvert(duration[0]);
            int end = timeConvert(duration[1]) + 10; // 10분의 청소 시간
            
            boolean check = false; // 새로운 객실을 추가해야하는지 여부
            int room_num = -1; // 기존의 방 기억
            
            // room의 객실 상태들 확인 후 대실 가능하다면 put
            for(Map.Entry<Integer, int[]> entry : room.entrySet()) {

                // 해당 객실 대여 시간이 겹치지 않는다면
                if(entry.getValue()[1] <= start) {
                    room_num = entry.getKey();
                    check = true;
                    break;
                } 
            }    
            
            if(check) {
                room.put(room_num, new int[]{start, end});
            } else {
                room.put(room_number++, new int[]{start, end});
            }
        }
        
        return room.size();
    }
    
    void sort(String[][] plans) {
        Arrays.sort(plans, (a, b) -> {
            int timeA = timeConvert(a[0]);
            int timeB = timeConvert(b[0]);
            return timeA - timeB;
        });
    }
    
    // hh:mm -> 정수형 변환
    int timeConvert(String time) {
        String[] split = time.split(":");
        int hour = Integer.parseInt(split[0]) * 60;
        int minute = Integer.parseInt(split[1]);
        
        return (hour+minute);
    }
    
    void printArray(String[][] book_time) {
        for(int i = 0; i < book_time.length; i++) {
            System.out.println("[" + book_time[i][0] + ", " + book_time[i][1] + "]");
        }
    } 
}