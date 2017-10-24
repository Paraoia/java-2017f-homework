public class Room {

	private Position[][] positions;

	public Room(int N, int M){
		positions = new Position[N][M];
		for(int i=0;i<N;i++)
			for(int j=0;j<M;j++){
				positions[i][j] = new Position(i,j);
				positions[i][j].setEmpty();
			}
	}

	public void clear(){
		for(int i=0;i<positions.length;i++)
			for(int j=0;j<positions[i].length;j++)
				if(!positions[i][j].getEmpty())
					positions[i][j].getHolder().getPosition().setEmpty();
	}

	public void printRoom(){
		for(int i=0;i<positions.length;i++){
			for(int j=0;j<positions[i].length;j++) {
				if (positions[i][j].getEmpty())
					System.out.print("   ");
				else
					positions[i][j].getHolder().report();
			}
			System.out.println();
		}
	}

	public void addQueue(Queue queue, int beginX, int beginY){
		Position[] queuePositions = queue.getQueuePositions();
		for(int i=0;i<queuePositions.length;i++)
			queuePositions[i].getHolder().setPosition(
					this.positions[beginX+queuePositions[i].getX()][beginY+queuePositions[i].getY()]);
	}

	public void addCreature(Creature creature, int x, int y){
		creature.setPosition(this.positions[x][y]);
	}

	public static void main(String []args){

		/* 生成葫芦七兄弟，并打乱顺序 */
		GourdBoy []brothers = new GourdBoy [7];
		for(int i=0;i<7;i++) {
			brothers[i] = new GourdBoy(Color.values()[i], Seniority.values()[i]);
		}
		Queue brothersQueue = new Queue(brothers);
		Sorter sorter = new RandomSorter();
		sorter.sort(brothersQueue);

		/* 将葫芦七兄弟按照老大至老七呈长蛇形列阵 */
		sorter = new BubbleSorter();
		sorter.sort(brothersQueue);
		Layout layout = new ChangsheLayout();
		layout.place(brothersQueue);

		/* 生成蝎子精和小喽啰，并让蝎子精带领5个小喽啰呈雁行列阵 */
		BadCharacter[] genies = new BadCharacter[6];
		genies[0] = new ScorpionGenie();
		for(int i=0;i<5;i++)
			genies[1+i] = new Goblin();
		Queue geniesQueue = new Queue(genies);
		layout = new YanxingLayout();
		layout.place(geniesQueue);

		/* 生成二维空间，并把葫芦兄弟和蝎子精小喽啰阵营放入二维空间对峙 */
		Room room = new Room(15,15);
		room.addQueue(brothersQueue, 0, 0);
		room.addQueue(geniesQueue, 0, 7);

		/* 生成老爷爷和蛇精，并将其放入空间中为各自一方加油助威 */
		Grandpa grandpa = new Grandpa();
		SnakeGenie snakeGenie = new SnakeGenie();
		room.addCreature(grandpa, 9, 0);
		room.addCreature(snakeGenie, 9, 9);

		/* 输出对峙局面 */
		room.printRoom();

		/* 蝎子精小喽啰阵营按鹤翼重新列阵 */
		layout = new HeyiLayout();
		layout.place(geniesQueue);

		/* 将原先所有角色移出二维空间，后重新将不同阵营角色放入二维空间，然后输出对峙局面 */
		System.out.println("--------------");
		room.clear();
		room.addQueue(brothersQueue, 0, 0);
		room.addQueue(geniesQueue, 0, 7);
		room.addCreature(grandpa, 9, 0);
		room.addCreature(snakeGenie, 9, 9);
		room.printRoom();

	}

}
