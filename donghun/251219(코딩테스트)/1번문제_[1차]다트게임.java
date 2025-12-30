class Solution {
    public int solution(String dartResult) {
        // 3번의 기회
        // 각각 0~10점
        // S,D,T (^1, ^2, ^3)
        // 스타상(*) : 해당 점수와 이전 점수를 2배
        // 아차상(#) : 해당 점수만큼 -
        // 스타상 중첩 가능
        // 스타상, 아차상은 존재하지 않을 수도 있음
        
        // 어떻게 접근할것인가
        // 숫자가 나왔다면 배열에 그 값을 저장 (check)
        // 이후 S,D,T 분기처리
        // 만약 * 또는 #이 있다면 그에 맞게 처리
        // 배열에 저장된 값들을 모두 합산
        
        // 문자열 3세트
        double[] arr = new double[3];
        int idx = 0;
        
        int len = dartResult.length();
        
        for(int i = 0; i < len; i++) {
            String s = String.valueOf(dartResult.charAt(i));
            
            // 숫자 삽입 로직 ----- start
            // 만약 '1'이라면 뒤에 문자까지 확인하여 '10'인지 확인
            if(i != len-1 && s.equals("1")) {
                String next = String.valueOf(dartResult.charAt(i+1));
    
                // '10'이라면 인덱스 점프
                if(next.equals("0")) {
                    i++; 
                    arr[idx] = 10;
                    idx++;
                    continue;
                }
                arr[idx] = 1;
                idx++;
                
            } else if(s.matches("^[0-9]$")) { // 0 ~ 9 삽입
                arr[idx] = Integer.parseInt(s);
                idx++;
            } 
            // 숫자 삽입 로직 ----- end
            
            // S, D, T 로직 ----- start
            double temp;
            if(s.equals("S")) {
                temp = arr[idx-1]; 
                arr[idx-1] = Math.pow(temp, 1);
            } else if(s.equals("D")) {
                temp = arr[idx-1];
                arr[idx-1] = Math.pow(temp, 2);
            } else if(s.equals("T")) {
                temp = arr[idx-1];
                arr[idx-1] = Math.pow(temp, 3);
            }
            // S, D, T 로직 ----- end
            
            // 스타상, 아차상 로직(*, #) --- start
            if(s.equals("*")) { // 해당 점수와 바로 전에 얻은 점수를 2배
                 // 현재 점수 2배
                arr[idx - 1] *= 2;
                // 이전 점수 존재 시, 그 점수도 2배
                if (idx - 2 >= 0) {
                    arr[idx - 2] *= 2;
                }
            } else if(s.equals("#")) {
                arr[idx-1] = arr[idx-1] * -1;
            }
            // 스타상, 아차상 로직(*, #) --- end
        }
        
        int answer = 0;
        for(int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
            answer+=arr[i];
        }
        
        return answer;
    }
}