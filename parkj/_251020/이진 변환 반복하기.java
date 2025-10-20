class Solution {
    public int[] solution(String s) {
        int[] answer = new int[2]; // {이진 변환 횟수, 제거된 0의 개수}

        String binaryCon = s;

        // 1이 될 때까지 무한 반복
        while (!binaryCon.equals("1")) {
            int len = binaryCon.length();

            binaryCon = binaryCon.replaceAll("0", ""); // 0 제거

            answer[1] += (len - binaryCon.length()); // 제거된 0의 개수 증가

            // 문자열의 길이를 이진 변환 ("1111" -> "4" -> "100")
            int nextNum = binaryCon.length();
            // Integer.toBinaryString : 10진수를 2진수로 변환하는 정적 메서드
            binaryCon = Integer.toBinaryString(nextNum);

            // 이진 변환 횟수 증가
            answer[0] += 1;
        }

        return answer;
    }
}
