import java.util.*;

class Solution {
    public String solution(int[] numbers) {
        
        // 6 vs 10 -> 610 vs 106 (610 win) 6이 우선
        // 6 vs 2 -> 62 vs 26 (62 win) 6이 우선
        // 10 vs 2 -> 102 vs 210 (210 win) 2가 우선
        // 6, 2, 10 순서로 정렬
        
        // 3 vs 30 -> 330 vs 303 (330) 3이 우선
        // 30 vs 34 -> 3034 vs 3430 (3430) 34가 우선
        // ...
        // 9, 5, 34, 3, 30 
        
        String[] str_nums = new String[numbers.length];
        
        for(int i = 0; i < numbers.length; i++) {
            str_nums[i] = String.valueOf(numbers[i]);
        }
        
        // 두 문자열을 합쳤을 때 내림차순 정렬로 정렬되도록 함
        Arrays.sort(str_nums, (s1, s2) -> (s2 + s1).compareTo(s1 + s2));
        
        // 만약 numbers의 원소가 모두 0일때
        if(str_nums[0].equals("0")) {
            return "0";
        }
        
        // StringBuilder를 사용하여 이어 붙이기
        StringBuilder sb = new StringBuilder();
        for (String s : str_nums) {
            sb.append(s);
        }
        
        return sb.toString();
    }
}