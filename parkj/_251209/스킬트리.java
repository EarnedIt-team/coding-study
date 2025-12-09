class Solution {
    public int solution(String skill, String[] skill_trees) {
        int answer = 0;

        for (String name : skill_trees) {
            String getSkill = ""; // 트리마다 초기화
            boolean isValid = true; // 가능한 스킬트리인가?

            // name 문자 단위로 순차적 검사
            for (int i = 0; i < name.length(); i++) {
                char current = name.charAt(i);

                // 스킬에 포함된 경우만 체크
                if (skill.contains(String.valueOf(current))) {
                    // 아직 배운 스킬이 없다면
                    if (getSkill.isEmpty()) {
                        if (current == skill.charAt(0)) {
                            getSkill += current;
                        } else {
                            isValid = false;
                            break;
                        }
                    }
                    // 이미 배운 스킬이 있다면 다음 순서인지 확인 
                    else {
                        if (current == skill.charAt(getSkill.length())) {
                            getSkill += current;
                        } else {
                            isValid = false;
                            break;
                        }
                    }
                }
            }

            if (isValid) {
                answer++;
            }
        }

        return answer;
    }
}
