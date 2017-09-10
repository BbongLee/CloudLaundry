package cloudlaundry;

import java.util.Scanner;

class GameObject {
	int cloudNum; // 구름 수
	int pollutLev; // 구름오염도(레벨에따라 달라짐)
	int gameTime; // 게임을 진행할 시간
	String player; // 사용자 이름

	void gamestart(int level) {
		switch (level) {
		case 1:
			cloudNum = 7;
			pollutLev = 5;
			gameTime = 30 * 1000;// 30초
			System.out.println("게임시작!");
			Cloud.makeCloud();
			break;
		case 2:
			break;
		case 3:
			break;
		}
	}

	
	public GameObject(String choice) {
		if(choice.equals("시작")) gamestart(1);
		else if(choice.equals("방법")) HowToPlay.guide();
	}
}

class HowToPlay{  //게임방법
	public static void guide(){
		System.out.println("게임방법 설명중 . . . ");
	}
}

class Canvas {

}// GUI

class Human {

}

class Cloud  {
	public static void makeCloud() {
		System.out.println("구름객체생성");
		// 랜덤메서드 만들기
		// 여기서 호출하기
		// 랜덤위치에 생성
	}
}

class ScoreView {
	public ScoreView(){
		System.out.println("DB에 저장된 점수를 보여준다 \nex)_ _ _ 유저의 점수 : 0 ");
	}
}

public class Laundry_Main {
	public static void main(String[] args) {
		GameObject go = null ; //선택한 페이지로 고고링 
		
		Scanner scan = new Scanner(System.in);
		System.out.println("메뉴를 선택해주세요");
		System.out.println("1 게임시작");
		System.out.println("2 게임방법");
		System.out.println("3 랭킹보기");
		System.out.println("4 종료하기");
		int choice = scan.nextInt();
		
		switch (choice) {
		case 1: go = new GameObject("시작"); break; //이름입력 -> 게임시작화면             // * 해당 클래스로 바꿔주기 
		case 2: go = new GameObject("방법"); break; //게임방법화면 -> 게임시작화면 
		case 3: ScoreView sd = new ScoreView(); break; //랭킹화면 -> 다시 메뉴로 나오는 화면 
		case 4: System.out.println("종료합니다"); return;
		default:
			System.out.println("선택이 잘못되었습니다");
		}

	}
}