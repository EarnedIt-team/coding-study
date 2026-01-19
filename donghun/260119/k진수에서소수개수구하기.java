import java.util.*;

class Solution {
    public int solution(int n, int k) {
        
        int answer = 0;
        
        // K진수로 변환해야함 toString(10진수, k진법)
        String convert = Integer.toString(n, k);
        
        // System.out.println(convert);
        
        // 앞에서부터 순차적으로 0이 아닌 수들을 검사
        for(int i = 0; i < convert.length(); i++) {
            
            if (convert.charAt(i) != '0') { // 소수 판별 시작 지점
                StringBuilder sb = new StringBuilder();
                int j = i;
                
                while (j < convert.length() && convert.charAt(j) != '0') {
                    sb.append(convert.charAt(j)); // 다음 문자 기록
                    j++;
                }
                
                long num = Long.parseLong(sb.toString());
                if(소수판별(num)) {
                    // System.out.println("num :" + num);
                    answer++;
                }
                i = j - 1;
            } 
        }
        
        return answer;
    }
    
    private boolean 소수판별(long n) {
        if(n < 2) return false;
        for(long i = 2; i <= Math.sqrt(n); i++) {
            if(n % i == 0) return false;
        }
        return true;
    }
}