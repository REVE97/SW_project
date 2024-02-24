package basic.lesson.gisa;

import java.util.ArrayList;
import java.util.Collections;

public class Solution {
	
	public String solveQuestion1(ArrayList<Student> data) {
		
		String answer = null;
		ArrayList<Student> temp = new ArrayList<Student>();
		for(Student student : data) {
			if(student.getLocCode().equals("B")) {
				temp.add(student);
			}
		}
		
		Collections.sort(temp,new GisaComparator());
		
		this.printTemp(temp, 0, 10);
		int stdNo = temp.get(4).getStdNo();
		answer= String.valueOf(stdNo);
		
		return answer;
	}
	
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
		
		System.out.println("문제 풀이");
		answer = String.valueOf(max);
		return answer;
	}
	
	public String solveQuestion3(ArrayList<Student> data) {
		int sum = 0;
		int count =0;
		for(Student student : data) {
			int point = 0;
			if(student.getEng()+student.getMath()>=120) {
				if(student.getAccCode().equals("A")) {
					point = 5;
				} else if(student.getAccCode().equals("B")) {
					point = 15;
				} else if(student.getAccCode().equals("C")) {
					point = 20;
				}
				count++;
				sum = sum + student.getTotal()+point;
			}
		}
		System.out.println("문제 풀이");
		System.out.println("count:" + count);
		return String.valueOf(sum);
	}
	
	public String solveQuestion4(ArrayList<Student> data) {
		
		String answer = null;
		int count = 0;
		for(Student student : data) {
			int point = 0;
			if(student.getAccCode().equals("A")
					||student.getAccCode().equals("B")) {
				if(student.getLocCode().equals("A")) {
					point = 5;
				}
				else if(student.getLocCode().equals("B")) {
					point =10;
				} else {
					point = 15;
				}
				if(student.getKor()+point >=50) {
					count++;
				}
			}
		}
		
		System.out.println("문제 풀이");
		answer = String.valueOf(count);
		return answer;
	}
	
	public void printTemp(ArrayList<Student> temp,int start, int end) {
		for(int i=start;i<end;i++) {
			System.out.println(temp.get(i));
		}
	}
}
