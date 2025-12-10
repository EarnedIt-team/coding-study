package _251210.programmers;

import java.util.*;

public class 스킬트리 {

    class Solution {
        public int solution(String skill, String[] skill_trees) {
            // 스킬트리에서 순서 정해진 스킬들을 제외한 나머지는 깍두기임

            // linked! 해시맵 : 입력순으로 순서가 정해진 해시맵
            Map<Character, Boolean> map = new LinkedHashMap<>(); // key:스킬 , val:나왔는가
            for (char c : skill.toCharArray()) {
                map.put(c, false);
            }

            int answer = 0;
            for (String s : skill_trees) {
                for (char k : map.keySet()) map.put(k, false); // map val 초기화

                for (char c : s.toCharArray()) {
                    if (map.containsKey(c)) { // 깍두기 아닌거만 따지기

                        // c 기준으로 앞쪽 스킬중 하나라도 false이면 안됨
                        boolean frontAllTrue = true;
                        for (char key : map.keySet()) {
                            if (key == c) break; // c 전까지만 확인
                            if (!map.get(key)) { // 앞스킬 안배움
                                frontAllTrue = false;
                                break;
                            }
                        }

                        if (frontAllTrue) map.put(c, true); // 가능트리
                        else { answer--; break; } // 불가능트리
                    }
                }

                answer++;
            }
            return answer;
        }
    }

}
