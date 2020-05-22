package Lv2;

/*
 * 스킬트리 - 문자열 비교
 * https://programmers.co.kr/learn/courses/30/lessons/49993
 */

public class Level_2_15 {
	
	static public int solution(String skill, String[] skill_trees) {
        int answer = 0;
        
        for(int i=0; i<skill_trees.length; i++) {
        	boolean flag = true;
        	int cnt =0;
        	String[] skillTreeArr = skill_trees[i].split(""); 
        	
        	for(int j=0; j<skillTreeArr.length; j++){
        		int nowSkill = skill.indexOf(skillTreeArr[j]); // 스킬트리 중 현재 탐색중인 스킬이 단계상 몇번째인지
                if(cnt < nowSkill){ // 현재 탐색중인 스킬의 순서가 완료한 스킬 갯수를 넘으면 탐색 중지
                    flag = false;
                    break;
                }else if(cnt == nowSkill) { // 현재 탐색중인 스킬의 순서가 완료한 스킬 갯수와 같으면 다음 스킬 탐색
                    cnt++;
                }
            }

            if(flag){ // 위의 단계를 true로 통과했으면 정답
                answer++;
            }
        }
        System.out.println(answer);
        
        return answer;
    }
	
	public static void main(String[] args) {
		String[] s = {"BACDE", "CBADF", "AECB", "BDA"};
		solution("CBD", s);
	}
}
