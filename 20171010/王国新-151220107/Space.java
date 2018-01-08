
public class Space {
	private static final int N = 20;
	private Position[][] battleground;

	public Space() {
		battleground = new Position[N][N];
	}
	
	/*	
	 * creatures 需要排成阵形的生物
	 * leaderpoint 领头者的坐标
	 * formation 需要排成的阵形
	 * direction 阵形朝向
	 */
	public void embattle(Queue queue, Point leaderpoint, FORMATION formation, DIRECTION direction) {
		new Embattle().embattle(queue.getCreatures(), formation, leaderpoint, direction);
		for (Creature creature : queue.getCreatures()) {
			setCreature(creature);
		}
	}

	public void setCreature(Creature creature) {
		int x = creature.getPosition().getPoint().getX();
		int y = creature.getPosition().getPoint().getY();
		Point point = creature.getPosition().getPoint();
		if (isOccupied(x, y)) {
			System.out.println("该位置已被占用！");
			return;
		}
		battleground[x][y] = new Position();
		battleground[x][y].setPoint(point);
		battleground[x][y].setHolder(creature);
	}

	public void clearQueue(Queue queue) {
		for (Creature creature : queue.getCreatures()) {
			clearOneCreatrue(creature);
		}
	}
	
	public void clearOneCreatrue(Creature creature) {
		int x = creature.getPosition().getPoint().getX();
		int y = creature.getPosition().getPoint().getY();
		if (!isOccupied(x, y)) {
			System.out.println("删除错误！");
			return;
		}
		battleground[x][y].clearHolder(); // clear操作应该与set操作对应
		battleground[x][y] = null;
	}

	public Boolean isOccupied(int x, int y) {
		return battleground[x][y] != null;
	}

	public void drawBattleground() {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (battleground[i][j] == null)
					System.out.print("  ");
				else
					battleground[i][j].getHolder().report();
			}
			System.out.println();
		}

	}

	public static void main(String[] args) {
		Huluwa[] brothers = new Huluwa[7];
		for (int i = 0; i < brothers.length; i++) {
			brothers[i] = new Huluwa(COLOR.values()[i], SENIORITY.values()[i]);
		}
		Creature[] demons = new Creature[7];
		demons[0] = new Scorpion();
		for (int i = 1; i < demons.length; i++) {
			demons[i] = new Minion();
		}
		Creature grandpa = new Grandfather();
		Creature snake = new Snake();

		Queue BrosQueue = new Queue(brothers);
		Queue DemonsQueue = new Queue(demons);
		Space space = new Space();
		//step1:初始乱序的七个兄弟按(老大至老七）站队
		BrosQueue.shuffle();
		new BubbleSort().sort(BrosQueue);
		
		//step2:将葫芦兄弟的长蛇阵营和蝎子精小喽啰阵营放置于二位空间中
		Point leaderPoint = new Point(8, 9);
		space.embattle(BrosQueue, leaderPoint, FORMATION.长蛇, DIRECTION.南);
		leaderPoint.setPoint(11, 9);
		space.embattle(DemonsQueue, leaderPoint, FORMATION.鹤翼, DIRECTION.北);

		//step3:将老爷爷和蛇精放置于空间中，为各自一方加油助威；
		snake.setPosition(new Position());
		snake.getPosition().setPoint(new Point(19,9));
		space.setCreature(snake);
		grandpa.setPosition(new Position());
		grandpa.getPosition().setPoint(new Point(0,9));
		space.setCreature(grandpa);
		
		//step4:将对峙局面打印输出
		System.out.println("---------葫芦娃(长蛇) VS 蝎子精(鹤翼)---------");
		space.drawBattleground();

		//step5:蝎子精小喽啰阵营变换成“衡轭”阵形
		space.clearQueue(DemonsQueue);
		space.embattle(DemonsQueue, leaderPoint, FORMATION.衡轭, DIRECTION.北);
		System.out.println("---------葫芦娃(长蛇) VS 蝎子精(衡轭)---------");
		space.drawBattleground();
	}
}
