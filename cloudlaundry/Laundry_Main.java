package cloudlaundry;

import java.util.Scanner;

class GameObject {
	int cloudNum; // ���� ��
	int pollutLev; // ����������(���������� �޶���)
	int gameTime; // ������ ������ �ð�
	String player; // ����� �̸�

	void gamestart(int level) {
		switch (level) {
		case 1:
			cloudNum = 7;
			pollutLev = 5;
			gameTime = 30 * 1000;// 30��
			System.out.println("���ӽ���!");
			Cloud.makeCloud();
			break;
		case 2:
			break;
		case 3:
			break;
		}
	}

	
	public GameObject(String choice) {
		if(choice.equals("����")) gamestart(1);
		else if(choice.equals("���")) HowToPlay.guide();
	}
}

class HowToPlay{  //���ӹ��
	public static void guide(){
		System.out.println("���ӹ�� ������ . . . ");
	}
}

class Canvas {

}// GUI

class Human {

}

class Cloud  {
	public static void makeCloud() {
		System.out.println("������ü����");
		// �����޼��� �����
		// ���⼭ ȣ���ϱ�
		// ������ġ�� ����
	}
}

class ScoreView {
	public ScoreView(){
		System.out.println("DB�� ����� ������ �����ش� \nex)_ _ _ ������ ���� : 0 ");
	}
}

public class Laundry_Main {
	public static void main(String[] args) {
		GameObject go = null ; //������ �������� ��� 
		
		Scanner scan = new Scanner(System.in);
		System.out.println("�޴��� �������ּ���");
		System.out.println("1 ���ӽ���");
		System.out.println("2 ���ӹ��");
		System.out.println("3 ��ŷ����");
		System.out.println("4 �����ϱ�");
		int choice = scan.nextInt();
		
		switch (choice) {
		case 1: go = new GameObject("����"); break; //�̸��Է� -> ���ӽ���ȭ��             // * �ش� Ŭ������ �ٲ��ֱ� 
		case 2: go = new GameObject("���"); break; //���ӹ��ȭ�� -> ���ӽ���ȭ�� 
		case 3: ScoreView sd = new ScoreView(); break; //��ŷȭ�� -> �ٽ� �޴��� ������ ȭ�� 
		case 4: System.out.println("�����մϴ�"); return;
		default:
			System.out.println("������ �߸��Ǿ����ϴ�");
		}

	}
}