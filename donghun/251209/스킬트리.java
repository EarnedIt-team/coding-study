class Solution {
    public int solution(String skill, String[] skill_trees) {
        // C,B,D를 제외한 모든 문자를 제거 후, 시작 문자가 C인지 검사
        // replaceAll 사용
        
        int answer = 0;
        
        // skill_trees의 모든 원소에 replaceAll 
        for(int i = 0; i < skill_trees.length; i++) {
            String str = skill_trees[i];
            
            // except 배열의 원소를 제외하고 소거
            str = str.replaceAll("[^" + skill + "]", "");
            System.out.println("필터링 결과: " + str);
            
            boolean isVaild = true;
            
            // 조건 만족하는지 검사 (주어진 문자열 순서로 진행되지 않으면 실패)
            for(int j = 0; j < str.length(); j++) {
                if(str.charAt(j) != skill.charAt(j)) {
                    isVaild = false;
                    break;
                }
            }
            
            if(isVaild) answer++;
        }
        
        return answer;
    }
}