package cloudlaundry;

class GameObject{
	int cloudNum; //���� ��
	int pollutLev; //����������(���������� �޶���)
	int gameTime; //������ ������ �ð�
	void gamestart(int level){
		switch(level) {
		case 1 : 
			cloudNum=7;
			pollutLev=5; 
			gameTime=30*1000;//30��
			System.out.println("���ӽ���!");
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
	Cloud[] cd = new Cloud[cloudNum];//���� ����ŭ ��ü ����
	for(int i=0; i<cd.length;i++) {
		cd[i].
	}
	public static void makeCloud() {
		System.out.println("�����̻���!!");
		
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