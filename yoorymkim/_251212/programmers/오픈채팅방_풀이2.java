package _251212.programmers;

import java.util.*;

public class 오픈채팅방_풀이2 {

    class Solution {
        public String[] solution(String[] record) {
            // 문 제 대 박 재 밋 다 !!! 대박대박하트

            ArrayList<String[]> result = new ArrayList<>(); // result 창 출력용
            Map<String, String> map = new HashMap<>(); // key:id, val:nickname

            for (String s : record) {
                StringTokenizer st = new StringTokenizer(s);
                String command = st.nextToken();
                String id = st.nextToken();

                if (command.equals("Enter")) {
                    String nickname = st.nextToken();
                    map.put(id, nickname);
                    result.add(new String[]{id, "님이 들어왔습니다."});
                }
                else if (command.equals("Leave")) {
                    result.add(new String[]{id, "님이 나갔습니다."});
                }
                else if (command.equals("Change")) {
                    String nickname = st.nextToken();
                    map.put(id, nickname);
                }
            }

            String[] answer = new String[result.size()];
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < result.size(); i++) {
                sb.append(map.get(result.get(i)[0])).append(result.get(i)[1]);
                answer[i] = sb.toString();
                sb.setLength(0);
            }

            return answer;
        }
    }

}
