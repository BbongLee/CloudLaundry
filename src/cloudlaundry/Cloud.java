package cloudlaundry;

class GameObject {
	public int[] level = { 7, 13, 21 }; // 내려올 구름 갯수!
	public int[] speed = { 100, 50, 30 }; // 레벨에 따른 sleep time!!
	int lev = 0; // 레벨 0 - 1 - 2 setLev로 바꿀 예정입니당!

	public int[] getLevel() {
		return level;
	}

	public void setLevel(int[] level) {
		this.level = level;
	}

	public int getLev() {
		return lev;
	}

	public void setLev(int lev) {
		this.lev = lev;
	}

}

class Cloud extends GameObject {
	private int x, y;
	private int speed = 0; // y좌표에 추가해서 구름 내려가기
	int pollut = 17;
	private int wait = 0;
	boolean check = true; // 다쓴 구름인가?
	private int clickNum = 0;

	public Cloud() {
		x = (int) (Math.random() * 506); // X좌표 (처음생성되는 위치)
		y = 0; // Y좌표
		speed = (int) (Math.random() * 20) + 5; // 떨어지는 값
		wait = (int) (Math.random() * 20) + 30; // 대기값을 주어서 0이 될때까지 구름객체가 나오지 않게 하는 방법!
		clickNum = 17;// 클릭해야할 오염도
	}

	public int getWait() {
		return wait;
	}

	public void setCh(boolean ch) {
		this.check = ch;
	}

	public boolean getCh() {
		return check;
	}

	public void setWait(int wait) {
		this.wait = wait;
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public int getSpeed() {
		return speed;
	}

	public void setSpeed(int speed) {
		this.speed = speed;
	}

	public int getPollut() {
		return pollut;
	}

	public void setPollut(int pollut) {
		this.pollut = pollut;
	}

	public int getClickNum() {
		return clickNum;
	}

	public void setClickNum(int clickNum) {
		this.clickNum = clickNum;
	}

}// cloud