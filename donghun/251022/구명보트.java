import java.util.*;

class Solution {
    public int solution(int[] people, int limit) {
        
        // 오름차순 정렬
        Arrays.sort(people);
        
        int left = 0;
        int right = people.length-1;
        int count = 0;
        
        while(left <= right) {
            if(people[left] + people[right] <= limit) {
                left++; // 그 다음 가벼운 사람
            }
            right--;
            count++;
        }
        
        return count;
    }
}