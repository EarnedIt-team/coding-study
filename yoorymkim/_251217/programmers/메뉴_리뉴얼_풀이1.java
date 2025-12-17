package _251217.programmers;

import java.util.*;

public class 메뉴_리뉴얼_풀이1 {

    class Solution {

        Map<String, Integer> map = new HashMap<>(); // key:메뉴조합, val:빈도수

        public String[] solution(String[] orders, int[] course) {
            // 사전 순으로 오름차순 정렬해서 return. 배열의 각 원소에 저장된 문자열 또한 알파벳 오름차순으로 정렬
            // orders개수만큼 set필요. set끼리 교집합 따져서 모든 교집합들 하나에 따로 저장 ?
            // course에 맞춰서 가공 ? 크기 큰 교집합은 요구에 맞춰서 잘라서 여러개로 나누기 가능
            // """가장 많이""" 함께 주문한 단품메뉴

            ArrayList<Set<Character>> oList = new ArrayList<>();
            for (String s : orders) {
                Set<Character> set = new HashSet<>();
                for (char c : s.toCharArray()) {
                    set.add(c);
                }
                oList.add(set);
            }

            for (int i = 0; i < oList.size()-1; i++) {
                for (int j = i+1; j < oList.size(); j++) {
                    Set<Character> set = new HashSet<>(oList.get(i));
                    set.retainAll(oList.get(j));

                    if (set.size() < 2) continue; // 교집합 1개이하

                    List<Character> chars = new ArrayList<>(set);
                    Collections.sort(chars); // 내부사전순

                    // 가능 조합 다 뽑아서 map에 저장
                    for (int c : course) {
                        if (chars.size() >= c) {
                            comb(chars, 0, c, new StringBuilder());
                        }
                    }
                }
            }

            ArrayList<String> ansList = new ArrayList<>();
            for (int num : course) {
                int max = 0;
                for (String key : map.keySet()) {
                    if (key.length() == num) {
                        max = Math.max(max, map.get(key));
                    }
                }
                if (max < 2) continue; // 2번 이상 주문된 것만

                for (String key : map.keySet()) {
                    if (key.length() == num && map.get(key) == max) {
                        ansList.add(key);
                    }
                }
            }

            Collections.sort(ansList); // 전체 사전순

            return ansList.toArray(new String[0]);
        }

        void comb(List<Character> arr, int idx, int len, StringBuilder sb) {

            if (sb.length() == len) {
                String key = sb.toString();
                map.put(key, map.getOrDefault(key, 0) + 1);
                return;
            }

            for (int i = idx; i < arr.size(); i++) {
                sb.append(arr.get(i));
                comb(arr, i + 1, len, sb);
                sb.deleteCharAt(sb.length() - 1);
            }
        }
    }

}
