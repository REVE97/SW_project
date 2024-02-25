package basic.lesson.gisa;

import java.util.ArrayList;

public class Solution {
	
	public String solveQuestion2(ArrayList<Student> list) {
		String answer = null;
		// 지역 코드가 B인 자료에 대하여 (국어 점수 + 영어 점수 ) 중 가장 큰값 구하기
		// ArrayList 지식
		// max 알고리즘
		// 기본 문법 (변수, 제어문)
		// 객체의 기본 사용법
		int max = 0;
		for(Student st : list) {
			if(st.getLocCode().equals("B")){
				if(max<(st.getKor()+st.getEng())) {
					max = st.getKor() + st.getEng();
				}
			}
		}
		
		
		System.out.println("문제 출시");
		answer = String.valueOf(max);
		return answer;
	}
}
