import java.util.*;

class Solution {
    public int solution(String dartResult) {
        // 3번 기회를 제공 (0점 ~ 10점)
        // S -> x1 / D -> x2 / T -> x3
        // * -> 받은 점수 x2, 이전 점수 x2 (다만, 처음에 나오면 받은 점수만 x2)
        // # -> -(받은 점수)
        // * 과 # 은 중첩 될 수 있으며, 이 경우 -(x2)
        
        // 숫자 / 타입 .. 이게 기본인데
        // 다음 숫자가 오기전에 * 혹은 #가 올 수도 있다.
        
        int answer = 0;
        int index = -1;
        ArrayList<Integer> list = new ArrayList<>();
        
        for (int i = 0; i < dartResult.length(); i++) {
            char c = dartResult.charAt(i);
            
            // 숫자
            if (Character.isDigit(c)) {
                index++; // 현재 몇번째 기회인지 기억
                // 다음에 오는 숫자를 조합해서 '10'이 되는지 판별
                if (c == '1' && dartResult.charAt(i+1) == '0') {
                    list.add(10);
                    i++;
                } else {
                    list.add(c - '0');   
                }
            } else {
                // 보너스 (알파벳)
                if (Character.isLetter(c)) {
                    int num = list.get(index);
                    num = c == 'S' ? num : c == 'D' ? num*num : num*num*num;
                    list.set(index, num);
                    // 옵션 (*, #)
                } else {
                    if (c == '*') {
                        // 이전에 받은 점수가 존재한다면,
                        if (index > 0) list.set(index-1, list.get(index-1)*2);
                        list.set(index, list.get(index)*2);
                    } else {
                        list.set(index, -(list.get(index)));
                    }
                }
            }
        }
        
        // 모든 기회에서 받은 점수 합계
        for (int i = 0; i < list.size(); i++) {
            answer += list.get(i);
        }
        
        return answer;
    }
}
