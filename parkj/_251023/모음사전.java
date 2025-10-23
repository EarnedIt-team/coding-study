import java.util.*;

class Solution {
    List<String> wordList; // 사전
    String[] words = {"A", "E", "I", "O", "U"};

    public int solution(String word) {
        int answer = 0;
        wordList = new ArrayList<>();
        dfs("", 0); // 사전에 모든 단어 수록

        // 몇번째 위치에 있는지 탐색
        for (int i = 0; i < wordList.size(); i++) {
            if (wordList.get(i).equals(word)) {
                answer = i;
                break;
            }
        }
        return answer;
    }
    
    // 완전탐색 (DFS, 깊이 우선 탐색)
    void dfs(String str, int depth) {
        wordList.add(str);
        if(depth == 5) return; // 길이가 5 라면, 생성을 중단

        // 5개 모음 각각 붙여 재귀적으로 단어 생성
        for (int i = 0; i < 5; i++) {
            dfs(str + words[i], depth + 1); // dfs(A, 1), dfs(AA, 2) ....
        }
    }
}
