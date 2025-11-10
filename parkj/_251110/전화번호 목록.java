import java.util.*;

class Solution {
    public boolean solution(String[] phone_book) {
        // 접두사는 문자열 기준 인접한 위치에서 발생하기에 (즉, 이웃끼리)
        // 사전순으로 정렬시킨다.
        // ["119", "97674223", "1195524421"]
        // ["119", "1195524421", "97674223"]
        Arrays.sort(phone_book);

        int x = phone_book.length - 1;
        
        while (x-- > 0) {
            // A.startsWith(B) : B가 A의 접두사인가?
            if (phone_book[x + 1].startsWith(phone_book[x])) return false;
        }
        
        return true;
    }
}
