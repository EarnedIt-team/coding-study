import java.util.*;

class Solution {
    public String solution(String m, String[] musicinfos) {
        // 유사도 측정?
        // 조건이 일치하는 음악이 여러 개일 때에는 "라디오에서 재생된 시간이 제일 긴 음악 제목"을 반환 
        // 재생된 시간도 같을 경우 먼저 입력된 음악 제목을 반환
        // 음악이 00:00를 넘겨서까지 재생되는 일은 없다. 
        
        // 조건이 일치하는 음악이 없을 때에는 “(None)”을 반환
        
        String answer = "(None)";
        
        int maxPlayTime = -1; // 재생시간 비교 변수
        m = convert(m); // 치환해놓기
        
        for(String s : musicinfos) {
            String[] musicInfo = s.split(",");
            int start = timeConvert(musicInfo[0]);
            int end = timeConvert(musicInfo[1]);

            int playtime = end-start;
            
            String name = musicInfo[2];
            
            String musicSheet = convert(musicInfo[3]);
            StringBuilder fullSheet = new StringBuilder();
            
            // playtime만큼의 악보 추출
            for(int i = 0; i < playtime; i++) {
                fullSheet.append(String.valueOf(musicSheet.charAt(i % musicSheet.length())));
            }
            // System.out.println(fullSheet.toString());
            
            // 네오가 기억한 멜로디가 포함되어있는지 확인 후 정답 업데이트
            // 해당 문자열이 포함되고, 재생시간 비교도 필요
            if (fullSheet.toString().contains(m)) {
                if (playtime > maxPlayTime) {
                    maxPlayTime = playtime;
                    answer = name;
                }
            }
        }
        
        return answer;
    }
    
    // hh:mm -> 정수형 변환
    int timeConvert(String time) {
        String[] split = time.split(":");
        int hour = Integer.parseInt(split[0]) * 60;
        int minute = Integer.parseInt(split[1]);
        
        return (hour+minute);
    }
    
    // 치환함수
    String convert(String s) {
        return s.replace("C#", "c")
            .replace("D#", "d")
            .replace("F#", "f")
            .replace("G#", "g")
            .replace("A#", "a")
            .replace("B#", "b");
    }
}