package _251029.programmers;

import java.util.*;

public class 문자열_내_마음대로_정렬하기 {
    class Solution {
        public String[] solution(String[] strings, int n) {

            Map<Character, List<String>> map = new HashMap<>(); // key:알파벳, val:단어리스트

            for (String s : strings) {
                char c = s.charAt(n);
                if (!map.containsKey(c)) {
                    map.put(c, new ArrayList<>());
                }
                map.get(c).add(s);
            }

            for (List<String> list : map.values()) {
                Collections.sort(list);
            }

            String[] ans = new String[strings.length];
            int idx = 0;
            for (char ch = 'a'; ch <= 'z'; ch++) {
                if (map.containsKey(ch)) {
                    for (String word : map.get(ch)) {
                        ans[idx++] = word;
                    }
                }
            }

            return ans;
        }
    }
}
