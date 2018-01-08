
public class Position {// 每个生物占据一个位置
	/*
	 * point 该位置在二维空间的坐标 
	 * holder 占据该位置的生物
	 */

	private Point point;
	private Creature holder;

	public Creature getHolder() {
		return holder;
	}

	public void setHolder(Creature holder) {
		this.holder = holder;
	}

	public void clearHolder() {
		this.holder = null;
	}

	public Point getPoint() {
		return point;
	}

	public void setPoint(Point point) {
		this.point = point;
	}
}
