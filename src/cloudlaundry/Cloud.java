package cloudlaundry;

class GameObject {
	public int[] level = { 7, 13, 21 }; // ������ ���� ����!
	public int[] speed = { 100, 50, 30 }; // ������ ���� sleep time!!
	int lev = 0; // ���� 0 - 1 - 2 setLev�� �ٲ� �����Դϴ�!

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
	private int speed = 0; // y��ǥ�� �߰��ؼ� ���� ��������
	int pollut = 17;
	private int wait = 0;
	boolean check = true; // �پ� �����ΰ�?
	private int clickNum = 0;

	public Cloud() {
		x = (int) (Math.random() * 506); // X��ǥ (ó�������Ǵ� ��ġ)
		y = 0; // Y��ǥ
		speed = (int) (Math.random() * 20) + 5; // �������� ��
		wait = (int) (Math.random() * 20) + 30; // ��Ⱚ�� �־ 0�� �ɶ����� ������ü�� ������ �ʰ� �ϴ� ���!
		clickNum = 17;// Ŭ���ؾ��� ������
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