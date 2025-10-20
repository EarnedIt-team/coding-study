class Solution {
    public int[] solution(String s) {
        
        int zero_count = 0;
        int count = 0;
        int[] answer = new int[2];
        
        while(true) {
            count++;
            // for 문을 돌면서 0의 개수를 체크
            for(int i = 0; i < s.length(); i++) {
                // 0의 개수 카운팅
                if(s.charAt(i) == '0') zero_count++; 
            }
            s = s.replaceAll("0", ""); // 로직 1 (0 제거)
            
            // 로직 2 (길이를 2진법으로 표현)
            s = Integer.toBinaryString(s.length()); // 숫자 -> 이진법 문자열로 변환
            
            if(s.equals("1")) break;
        }
        
        answer[0] = count;
        answer[1] = zero_count;
        
        return answer;
    }
}