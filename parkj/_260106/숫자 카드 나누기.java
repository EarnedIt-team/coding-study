class Solution {
    public int solution(int[] arrayA, int[] arrayB) {
        int answer = 0; // 두 조건에 만족하지 못하면 0으로 리턴하기 위해 0으로 설정
        int gcdA = arrayA[0]; // arrayA 에서 나올 수 있는 최대공약수
        int gcdB = arrayB[0]; // arrayB 에서 나올 수 있는 최대공약수
        
        // 각 배열의 최대공약수 구하기
        for(int i =1; i< arrayA.length; i++){
            gcdA = euclidean(gcdA, arrayA[i]);
            gcdB = euclidean(gcdB, arrayB[i]);
        }

        /// 두 조건 중 하나를 만족하는 가장 큰 양의 정수를 리턴하기 위한 if
        /// Math.max = "가장 큰 양의 정수" 이기에, arrayA 기준 숫자가 나와도,
        /// arrayB 기준 더 큰 숫자가 나올 수 있기 때문에
        
        // gcdA가 arrayB의 모든 원소를 나누지 못하는지 확인
        if (notDiv(arrayB, gcdA)) answer = Math.max(answer, gcdA);

        // gcdB가 arrayA의 모든 원소를 나누지 못하는지 확인
        if (notDiv(arrayA, gcdB)) answer = Math.max(answer, gcdB);

        return answer;
    }

    // 유클리드 호제법 (두 수의 최대공약수)
    int euclidean(int a, int b) {
        while (b != 0) {
            int r = a % b;
            a = b;
            b = r;
        }
        return a;
    }

    // 상대쪽 최대공약수로 나누어 떨어질 수 있는지 검사
    boolean notDiv(int[] array, int gcd) {
        for (int num : array) {
            if (num % gcd == 0) return false; // 하나라도 나누어 떨어지면 탈락
        }
        return true;
    }
}
