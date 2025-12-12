import java.util.*;

class Solution {
    public String[] solution(String[] record) {
        Map<String, String> uidMap = new HashMap<>();     // uid -> 닉네임
        ArrayList<String[]> chatData = new ArrayList<>();  // {"Enter"/"Leave", uid}
        
        for (String data : record) {
            String[] list = data.split(" ");

            // Enter
            if (list[0].equals("Enter")) {
                uidMap.put(list[1], list[2]); // uid, 닉네임
                chatData.add(new String[]{"Enter", list[1]});
            // Leave
            } else if (list[0].equals("Leave")) {
                chatData.add(new String[]{"Leave", list[1]});
            // Change
            } else {
                uidMap.put(list[1], list[2]);
            }
        }
        
        String[] answer = new String[chatData.size()]; // 실제 출력될 채팅
        for (int i = 0; i < chatData.size(); i++) {
            String[] arr = chatData.get(i);

            answer[i] = arr[0].equals("Enter") ?
                        uidMap.get(arr[1]) + "님이 들어왔습니다."
                        : uidMap.get(arr[1]) + "님이 나갔습니다.";
        }

        return answer;
    }
}
