class Solution {
    public String solution(int[] food) {
        StringBuilder sb = new StringBuilder();
        
        // 기준점이 되는 부분만 만들기 ("1122"02211)
        for (int i = 1; i < food.length; i++) {
            int count = food[i] / 2; // 절반만 사용
            for (int j = 0; j < count; j++) {
                sb.append(i);
            }
        }

        // 중앙의 물(0)을 넣어서 완성 (기준점을 뒤집어서 붙이기)
        return sb.toString() + "0" + new StringBuilder(sb).reverse().toString();
    }
}
