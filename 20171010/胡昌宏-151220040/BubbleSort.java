
public class BubbleSort implements Sorter{
	public void sort(Map map, Creature []creature, int x, int y) {
		Creature temp;
		for (int i = 0; i < creature.length - 1; i++) {
			for (int j = 0; j < creature.length - 1 - i; j++) {
				if (((Comparable) (map.positions[x+j][y].getHolder())).biggerThan((Comparable) (map.positions[x+j+1][y].getHolder()))) {
					temp = map.positions[x+j][y].getHolder();
					map.positions[x+j][y].setHolder(map.positions[x+j+1][y].getHolder());
					map.positions[x+j+1][y].setHolder(temp);
					}
				}
			}
	}
}
