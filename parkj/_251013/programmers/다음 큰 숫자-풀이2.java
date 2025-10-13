/// 결국 문제는 "1"의 개수가 동일하고, n보다 크지만 가장 작은 다음 수를 찾고 있다.
/// n+1 부터 시작해서 비트의 수가 동일한지만 검사하면 되는 문제였다.
/// 앞서 문제에서는 효율성으로 해결하지 못해서 검색해서 찾아보니 "bitCount"라는 메소드를 찾게 됨
/// 간단하게 "1"의 개수를 비교하고 찾을 수 있었다.

class Solution {
    public int solution(int n) {
        /// bitCount : 주어진 정수에서 true bit의 개수를 리턴 (0 = false / 1 = true)
        /// int & long 타입에서 사용이 가능
        int bit_Count = Integer.bitCount(n); // n의 2진수 "1"의 개수
        int number = n+1;
        
        while (true) {
            // 만약 "1"의 개수가 동일하다면 조건에 만족하는 가장 작은 수
            if (Integer.bitCount(number) == bit_Count) return number;
            number++;
        }
    }
}
