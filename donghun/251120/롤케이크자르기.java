import java.util.*;

class Solution {
    public int solution(int[] topping) {
        
        // 롤케이크를 공평하게 잘라야함
        // 토핑의 가짓수만 같으면 공평하게 자른것
        
        int answer = 0;
        int len = topping.length;
    
        int[] left = new int[len];
        int[] right = new int[len];
        
        HashSet<Integer> set = new HashSet<>();
        
        for(int i = 0; i < len; i++) {
            set.add(topping[i]);
            left[i] = set.size();
        }

        set.clear(); 
        
        for(int i = len-1; i >= 0; i--) {
            set.add(topping[i]);
            right[i] = set.size();
        } 
        
        for(int i = 0; i < len - 1; i++) {
            if(left[i] == right[i+1]) answer++;
        }
        
        return answer;
    }
}