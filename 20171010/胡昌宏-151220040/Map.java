
public class Map {
	private static final int N = 20;
	public Position [][]positions;
	public Map() {
		positions = new Position[N][N];
		for(int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++)
				positions[i][j] = new Position(i, j);
		}
	}
	public void putCreature(Creature creature, int x, int y) { //将一个生物放入地图中
		positions[creature.getPosition().getX()+x][creature.getPosition().getY()+y].setHolder(creature);
	}
	
	public void putCreatures(Creature []creature, int x, int y) {  //将一群生物放入地图中
		for(int i = 0; i < creature.length; i++) {
			putCreature(creature[i], x, y);
		}
	}
	
	public void outCreature(Creature creature, int x, int y) {  //一个生物从地图中出去
		positions[creature.getPosition().getX()+x][creature.getPosition().getY()+y].setHolder(null);
		positions[creature.getPosition().getX()+x][creature.getPosition().getY()+y].OutPos();
	}
	
	public void outCreatures(Creature []creature, int x, int y) {  //一群生物从地图中出去
		for(int i = 0; i < creature.length; i++)
			outCreature(creature[i], x, y);
	}
	
	public void ClearMap() {  //清空整个地图
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < N; j++) {
				if(positions[i][j].Is_empty() != true) {
					positions[i][j].setHolder(null);
					positions[i][j].OutPos();
				}
			}
		}
	}
	
	public void show() {  //打印地图
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < N; j++) {
				
				if(positions[i][j].Is_empty() != true)
					positions[i][j].getHolder().report();
				else
					System.out.print("\t");
			}
			System.out.print("\n");
		}
	}
}
