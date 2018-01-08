package huluwa;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class SecondDimension {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Creature grandfather = new Creature("Grandpa", true, State.WATCHER);
		Creature snack = new Creature("Snack", false, State.WATCHER);
		Creature scorpion = new Creature("Scorption", false, State.LEADER);

		Creature[] huluwa = new HuLuWa[7];
		huluwa[0] = new HuLuWa(1, Color.RED);
		huluwa[1] = new HuLuWa(2, Color.ORANGE);
		huluwa[2] = new HuLuWa(3, Color.YELLOW);
		huluwa[3] = new HuLuWa(4, Color.GREEN);
		huluwa[4] = new HuLuWa(5, Color.CYAN);
		huluwa[5] = new HuLuWa(6, Color.BLUE);
		huluwa[6] = new HuLuWa(7, Color.PURPLE);
		
		// 对初始7个兄弟进行打乱操作
		// 先从葫芦娃数组创建一个数组列表
		ArrayList<Creature> list=new ArrayList<>(Arrays.asList(huluwa));
		// 利用Collections里的shuffle()函数对葫芦娃进行打乱
		Collections.shuffle(list);
		// 将从葫芦娃数组列表创建一个数组并将内容复制回原数组 
		list.toArray(huluwa);
		
		Creature[] goblins = new Goblin[6];
		goblins[0]=new Goblin(Number.ONE);
		goblins[1]=new Goblin(Number.TWO);
		goblins[2]=new Goblin(Number.THREE);
		goblins[3]=new Goblin(Number.FOUR);
		goblins[4]=new Goblin(Number.FIVE);
		goblins[5]=new Goblin(Number.SIX);

		SecondDimension queue = new SecondDimension(11);
		queue.seizeHuLuWaSeat(huluwa);
		queue.seizeGoblinSeat(goblins, Formation.GOOSE);
		queue.seizeOthersSeat(grandfather);
		queue.seizeOthersSeat(snack);
		queue.seizeOthersSeat(scorpion);
		queue.printPositions();
	}

	private Position[][] positions;

	public SecondDimension() {

	}

	public SecondDimension(int dimension) {
		positions = new Position[dimension][dimension];
		for (int i = 0; i < positions.length; i++) {
			for (int j = 0; j < positions[0].length; j++) {
				positions[i][j] = new Position();
			}
		}
	}

	public void seizeHuLuWaSeat(Creature[] creature) {
		if (creature instanceof HuLuWa[]) {
			positions[0][8].holder = creature[0];
			positions[1][8].holder = creature[1];
			positions[2][8].holder = creature[2];
			positions[3][8].holder = creature[3];
			positions[4][8].holder = creature[4];
			positions[5][8].holder = creature[5];
			positions[6][8].holder = creature[6];
		} else
			return;
	}

	public void seizeGoblinSeat(Creature[] creature, Formation formation) {
		if (creature instanceof Goblin[]) {
			if (formation == Formation.GOOSE) {
				for (int i = 0; i < 6; i++) {
					positions[i][6 - i].holder = creature[i];
				}
			} else if (formation == Formation.RUT) {
				for (int i = 0; i < 5; i += 2) {
					positions[i][4].holder = creature[i];
				}
				for (int i = 1; i < 6; i += 2) {
					positions[i][5].holder = creature[i];
				}
			}
		}
	}

	public void seizeOthersSeat(Creature creature) {
		if (creature.getName() == "Grandpa")
			positions[3][9].holder = creature;
		if (creature.getName() == "Snack")
			positions[3][0].holder = creature;
		if (creature.getName() == "Scorption")
			positions[3][7].holder = creature;
	}

	public void printPositions() {
		for (int i = 0; i < positions.length; i++) {
			for (int j = 0; j < positions[0].length; j++) {
				if (positions[i][j].holder != null)
					System.out.printf("%10s", positions[i][j].holder.reportActivity());
				else
					System.out.printf("%10s","          ");
			}
			System.out.println();
		}
	}
}

class Position{
	Creature holder;
	public Position() {
		holder=null;
	}
}

// 阵型，这里实现了两者(雁型和车辙型)
enum Formation {
	GOOSE,RUT;
}