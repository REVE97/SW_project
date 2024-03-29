package basic.lesson.gisa;

import java.util.ArrayList;

public class LessonMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LessonMain start = new LessonMain();
		start.startLesson();
	}
	
	// startLesson 메소드이름 기본 메소드 생성 
	
	public void startLesson() {
		System.out.println("startLesson");
		this.testStart();
	}
	
	public void testStart() {
		// 데이터 파일 생성
		ArrayList<Student> list = this.makeData();
		// 로직클래스에게 데이터 전달
		Solution solution = new Solution();
		String answer = solution.solveQuestion2(list);
		// 정답받아서 답안지 작성
		this.writeAnswer(answer);
	}
	
	public ArrayList<Student> makeData(){
		ArrayList<Student> list = null;
		System.out.println("데이터를 생성하여 전달");
		// 파일 연결
		// 파일 안의 1000개의 라인에 각각 접근하여 --> 스트림 처리 (IO)
		// 각 라인을 11개의 데이터로 분리하여 --> String 분리
		// Student 객체로 생성한 다음 List 에 저장  --> ArrayList 
		return list;
	}
	
	public void writeAnswer(String answer) {
		System.out.println("정답을 받아서 답안지 작성");
		// 파일 생성
		// 파일 접근
		// 파일 쓰기
		// --> 스트림 지식
	}
}
