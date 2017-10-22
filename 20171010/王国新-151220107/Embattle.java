
public class Embattle {
	public void embattle(Creature[] creatures, FORMATION formation, Point leaderpoint, DIRECTION direction) {
		switch (formation) {
		case 长蛇:
			Changshe(creatures, leaderpoint, direction);
			break;
		case 鹤翼:
			Heyi(creatures, leaderpoint, direction);
			break;
		case 衡轭:
			Henge(creatures, leaderpoint, direction);
			break;
		default:
			break;
		}
	}

	private void Changshe(Creature[] creatures, Point leaderpoint, DIRECTION direction) {

		creatures[0].setPosition(new Position());
		creatures[0].getPosition().setPoint(leaderpoint);
		for (int i = 1; i < creatures.length; i++) {
			int x = 0, y = 0;
			switch (direction) {
			case 东:
				x = leaderpoint.getX();
				y = leaderpoint.getY() - i;
				break;
			case 西:
				x = leaderpoint.getX();
				y = leaderpoint.getY() + i;
				break;
			case 南:
				x = leaderpoint.getX() - i;
				y = leaderpoint.getY();
				break;
			case 北:
				x = leaderpoint.getX() + i;
				y = leaderpoint.getY();
				break;
			default:
				break;
			}
			creatures[i].setPosition(new Position());
			creatures[i].getPosition().setPoint(new Point(x,y));
		}
	}

	private void Heyi(Creature[] creatures, Point leaderpoint, DIRECTION direction) {
		creatures[0].setPosition(new Position());
		creatures[0].getPosition().setPoint(leaderpoint);
		for (int i = 1; i < creatures.length; i++) {
			int x = 0, y = 0;
			int a = (i + 1) / 2;
			int b = (int) Math.pow(-1, i);
			switch (direction) {
			case 东:
				x = leaderpoint.getX() + a * b;
				y = leaderpoint.getY() - a;
				break;
			case 西:
				x = leaderpoint.getX() + a * b;
				y = leaderpoint.getY() + a;
				break;
			case 南:
				x = leaderpoint.getX() - a;
				y = leaderpoint.getY() + a * b;
				break;
			case 北:
				x = leaderpoint.getX() + a;
				y = leaderpoint.getY() + a * b;
				break;
			default:
				break;
			}
			creatures[i].setPosition(new Position());
			creatures[i].getPosition().setPoint(new Point(x,y));
		}
	}
	private void Henge(Creature[] creatures, Point leaderpoint, DIRECTION direction) {
		creatures[0].setPosition(new Position());
		creatures[0].getPosition().setPoint(leaderpoint);
		for (int i = 1; i < creatures.length; i++) {
			int x = 0, y = 0;
			switch (direction) {
			case 东:
				x = leaderpoint.getX() + (i % 2)*2;
				y = leaderpoint.getY() - i;
				break;
			case 西:
				x = leaderpoint.getX() + (i % 2)*2;
				y = leaderpoint.getY() + i;
				break;
			case 南:
				x = leaderpoint.getX() - i;
				y = leaderpoint.getY() + (i % 2)*2;
				break;
			case 北:
				x = leaderpoint.getX() + i;
				y = leaderpoint.getY() + (i % 2)*2;
				break;
			default:
				break;
			}
			creatures[i].setPosition(new Position());
			creatures[i].getPosition().setPoint(new Point(x,y));
		}
	}
}

enum FORMATION {
	鹤翼, 雁行, 衡轭, 长蛇, 鱼鳞, 方圆, 偃月, 锋矢
}

enum DIRECTION {
	东, 西, 南, 北
}