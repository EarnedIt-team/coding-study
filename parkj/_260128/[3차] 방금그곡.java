class Solution {
    public String solution(String m, String[] musicinfos) {
        String[][] processedInfos = new String[musicinfos.length][3]; // 곡 정보 리마스터
        String answer = "(None)"; // 조건이 일치하는 음악이 없을 때 (None) 반환
        int maxDuration = -1; // 가장 긴 재생 시간
        
        // musicinfos 정보를 리마스터 하는 과정
        for (int i = 0; i < musicinfos.length; i++) {
            String[] info = musicinfos[i].split(",");
            int duration = getDuration(info[0], info[1]); // String -> Int
            processedInfos[i][0] = String.valueOf(duration); // 재생 시간(분)
            processedInfos[i][1] = info[2]; // 제목
            processedInfos[i][2] = info[3]; // 멜로디
        }
        
        // 기억하고 있는 멜로디 # 변환처리
        m = replaceSharp(m);

        // 노래 찾기
        for (int i = 0; i < processedInfos.length; i++) {
            int duration = Integer.parseInt(processedInfos[i][0]); // 재생 시간(분)
            String title = processedInfos[i][1]; // 제목
            String melody = replaceSharp(processedInfos[i][2]); // 멜로디 (# 변환처리)
            
            // 재생 시간에 맞춰 전체 멜로디 (반복해서 이어붙임)
            StringBuilder fullMelody = new StringBuilder();
            for (int j = 0; j < duration; j++) {
                fullMelody.append(melody.charAt(j % melody.length()));
            }
            
            // 일치하는 부분이 있는지 확인
            if (fullMelody.toString().contains(m)) {
                // 재생 시간이 더 긴 곡으로 갱신
                if (duration > maxDuration) {
                    maxDuration = duration;
                    answer = title;
                }
            }
        }
        
        return answer;
    }

    // #이 붙은 음계를 소문자로 치환
    String replaceSharp(String s) {
        return s.replace("C#", "c")
                .replace("D#", "d")
                .replace("F#", "f")
                .replace("G#", "g")
                .replace("A#", "a")
                .replace("B#", "b");
    }

    // hh:mm String 타입을 Int로 변환
    int getDuration(String start, String end) {
        String[] startParts = start.split(":");
        String[] endParts = end.split(":");
        int startTotalMin = Integer.parseInt(startParts[0]) * 60 + Integer.parseInt(startParts[1]);
        int endTotalMin = Integer.parseInt(endParts[0]) * 60 + Integer.parseInt(endParts[1]);
        return endTotalMin - startTotalMin;
    }
}
