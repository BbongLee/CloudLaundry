package cloudlaundry;

class GameObject{
	int cloudNum; //구름 수
	int pollutLev; //구름오염도(레벨에따라 달라짐)
	int gameTime; //게임을 진행할 시간
	void gamestart(int level){
		switch(level) {
		case 1 : 
			cloudNum=7;
			pollutLev=5; 
			gameTime=30*1000;//30초
			System.out.println("게임시작!");
			Cloud.makeCloud();
			break;
		case 2 :
			break;
		case 3:
			break;
		}
	};
}

class Canvas{
	
}//GUI

class Human extends GameObject{
	
}

class Cloud extends GameObject{
	Cloud[] cd = new Cloud[cloudNum];//구름 수만큼 객체 생성
	for(int i=0; i<cd.length;i++) {
		cd[i].
	}
	public static void makeCloud() {
		System.out.println("구르미생성!!");
		
	}
	
}

class ScoreDB{
	
}

public class Laundry_Main {
	public static void main(String[] args) {
		GameObject go = new GameObject();
		go.gamestart(1);
	}
}