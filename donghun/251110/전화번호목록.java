// 풀이 1
import java.util.*;

class Solution {
    public boolean solution(String[] phone_book) {
        // 사전 순으로 정렬
        Arrays.sort(phone_book);
        
        // 정렬된 문자열을 인접 문자열과 비교
        for(int i = 0; i < phone_book.length - 1; i++) {
            if(phone_book[i+1].startsWith(phone_book[i])) return false;
        }
        
        return true;
    }
}