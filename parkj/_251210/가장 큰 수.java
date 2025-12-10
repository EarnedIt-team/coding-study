import java.util.*;
import java.util.stream.Collectors;

class Solution {
    public String solution(int[] numbers) {
        String[] arr = new String[numbers.length];
        
        // 정답이 클 수 있기에, 문자열로 바꿔서 처리
        for (int i = 0; i < numbers.length; i++) {
            arr[i] = String.valueOf(numbers[i]);
        }
        
        // A compareTo B : A가 B보다 크면 ~~
        // Arrays.sort로 인해 계속 비교하면서 순서 정렬
        // b + a로 한 이유 : 내림차순, 작은 수가 앞으로 가기 때문
        Arrays.sort(arr, (a, b) -> (b + a).compareTo(a + b));

        // 정렬했지만, 가장 큰 값이 0이라면 그냥 "0"으로 리턴 ("000..." 되는 이슈 해결)
        // Collectors.joining : 문자열들을 이어붙여, 하나의 String으로 만들기
        return arr[0].equals("0") ? "0" : Arrays.stream(arr).collect(Collectors.joining());
    }
}
