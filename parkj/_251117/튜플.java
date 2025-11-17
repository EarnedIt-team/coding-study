import java.util.*;

class Solution {
    public int[] solution(String s) {
        // {, } 제거
        String[] strArr = s.substring(2, s.length() - 2).split("},\\{");

        // 작은 원소대로 정렬 "1", "1,2" ...
        Arrays.sort(strArr, (a, b) -> a.length() - b.length());

        // 중복되지 않는 값들을 저장하는 공간
        Set<Integer> set = new HashSet<>();
        int[] result = new int[strArr.length];
        int index = 0;

        for (String str : strArr) {
            for (String n : str.split(",")) {
                int num = Integer.parseInt(n);
                // set에 처음 넣는 값이라면 배열에 추가
                if (!set.contains(num)) {
                    set.add(num);
                    result[index++] = num;
                } 
            }
        }
        return result;
    }
}
