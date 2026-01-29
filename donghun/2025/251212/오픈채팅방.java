import java.util.*;

class Solution {
    public String[] solution(String[] record) {
        // 문자열 파싱을 통해 처리해야하는 듯
        // HashMap으로 해당 아이디(Key)의 채팅(Value)를 변경하는 식으로
        
        // uid1234 : Muzi -> Prodo 
        // uid4567 : Prodo -> Ryan
        
        // record 길이는 1 이상 100,000 이하이다.
        
        Map<String, String> map = new HashMap<>();
        List<String> answer_list = new ArrayList<>();
        
        for(int i = 0; i < record.length; i++) {
            String[] arr = record[i].split(" "); // 공백 기준으로 분리
            
            // 입장 시
            if(arr[0].equals("Enter")) {
                map.put(arr[1], arr[2]);
                answer_list.add(arr[1] + "님이 들어왔습니다.");
            }
            // 나갔을 시
            if(arr[0].equals("Leave")) {
                answer_list.add(arr[1] + "님이 나갔습니다.");
            }
            
            // 닉네임 변경 시
            if(arr[0].equals("Change")) {
                map.put(arr[1], arr[2]);
            }
        }
        
        for(int i = 0; i < answer_list.size(); i++) {
            // 해당 정답 배열에서 아이디가 일치하는 부분을 수정
            
            // "님" 위치 찾기
            int idx = answer_list.get(i).indexOf("님");
            // "님" 앞까지만 자르기
            String key = answer_list.get(i).substring(0, idx);
            String value = map.get(key);
            
            // 남은 부분
            String after = answer_list.get(i).substring(idx);
            
            // 데이터 갱신
            answer_list.set(i, value+after);
        }
        
        return answer_list.toArray(new String[0]);
    }
}