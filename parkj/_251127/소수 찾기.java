import java.util.*;

class Solution {
    Set<Integer> numSet = new HashSet<>(); // 중복되지 않은 숫자
    int[] visited; // 방문 여부

    public int solution(String numbers) {
        int answer = 0; // 소수 개수
        visited = new int[numbers.length()];
        dfs(numbers, "");
        
        // 소수 판별하기
        for (int num : numSet) {
            if (num < 2) continue;

            int i;
            for (i = 2; i * i <= num; i++) {
                if (num % i == 0) break; // 나누어 떨어지면 소수 아님
            }

            if (i * i > num) answer++; // 끝까지 나누어떨어지지 않았다면 소수
        }

        return answer;
    }

    // 모든 조합의 숫자 만들기
    void dfs(String numbers, String str) {
        // 초반 빈 공백은 제외하고 들어가게 처리
        if (!str.equals("")) numSet.add(Integer.parseInt(str));

        for (int i = 0; i < numbers.length(); i++) {
            // 아직 방문하지 않은 숫자라면
            if (visited[i] == 0) {
                visited[i] = 1;     // 방문 처리
                dfs(numbers, str + numbers.charAt(i)); // 해당 숫자를 문자열에 붙혀서 dfs
                visited[i] = 0;     // 백트래킹
            }
        }
    }
}
