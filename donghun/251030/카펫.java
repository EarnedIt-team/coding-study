import java.util.*;

class Solution {
    public int[] solution(int brown, int yellow) {
        
        // brown + yellow = 사각형의 넓이
        // yellow 면적 = 가로-2 * 세로-2
        
        // 모든 약수 구하기 
        // ex) 12 : 1, 2, 3, 4, 6, 12
        // ex) 9 : 1, 3, 9
        
        List<Integer> list = new ArrayList<>();
        int[] answer = new int[2];
        
        int area = brown + yellow;
        for(int i = 1; i <= area; i++) {
			// 약수 리스트에 추가
            if(area % i == 0) {
				list.add(i);
			}
		}
        
        // 뒤와 앞에서 쪼여옴
        int right = list.size()-1;
        int left = 0;
        
        // 약수들을 돌아가며 검사
        while(left <= right) {
            if ((list.get(left) - 2) * (list.get(right) - 2) == yellow) {
                answer[0] = list.get(right);
                answer[1] = list.get(left);
                break;   
            }
            left++;
            right--;
        }
        
        return answer;
    }
}