package huluwa3;


public class Fight {
	
	private Queue huluQueue;
	private Queue scorpionQueue;
	private Position[][] positions;
	
	private int cols=50;
	private int rows=50;
	
	public Fight(Creature[] groupA,Creature[] groupB)
	{
		huluQueue=new Queue(groupA);
		scorpionQueue=new Queue(groupB);
		
		positions=new Position[rows][cols];
		for (int i=0;i<rows;i++)
			for (int j=0;j<cols;j++)
				positions[i][j]=new Position(i,j);//初始化位置
		
		huluQueue.setFirst(positions[2][10]);
		scorpionQueue.setFirst(positions[2][(cols-10)/2]);
		
		
		
	}
	
	public Position[][] getPositions()
	{
		return positions;
	}
	
	public Queue getQueue(int n)
	{
		if (n==0)
			return huluQueue;
		else
			return scorpionQueue;
	}
	
	
	public void setGrangpa(Grandpa grandpa)
	{
		grandpa.setPosition(positions[5][5]);
	}
	public void setSnake(Snake snake)
	{
		snake.setPosition(positions[5][cols-10]);
	}
	
	public void printFight()
	{
		for (int i=0;i<rows;i++)
		{
			for (int j=0;j<cols;j++)
			{
				positions[i][j].printHolder();
			}
			System.out.println();
		}
	}
	
	
	
	public static void main(String[] args)
	{
		Huluwa[] brothers=new Huluwa[7];
		for (int i=0;i<brothers.length;i++)
		{
			brothers[i]=new Huluwa(COLOR.values()[i],NUMBER.values()[i]);
		}

		Creature[] scorpionAndServants=new Creature[13];
		scorpionAndServants[0]=new Scorpion();
		
		for (int i=1;i<scorpionAndServants.length;i++)
		{
			scorpionAndServants[i]=new Servant();
		}
		Snake snake=new Snake();
		Grandpa grandpa=new Grandpa();
		
		Fight fight=new Fight(brothers,scorpionAndServants);
		
		
		positionSetter changSheSetter=new ChangShe();		
		changSheSetter.setPosition(fight.huluQueue,fight.getPositions());
		fight.getQueue(0).shuffle();
		
		
		positionSetter heyiSetter=new HeYi();
		heyiSetter.setPosition(fight.scorpionQueue,fight.getPositions());//阵法为鹤翼
		//双方形成对峙局面		
		fight.setGrangpa(grandpa);
		fight.setSnake(snake);//放置老爷爷和蛇精
		fight.printFight();//打印
		
		positionSetter fengShiSetter=new FengShi();
		fengShiSetter.setPosition(fight.scorpionQueue,fight.getPositions());//变换阵法为锋矢
		fight.setGrangpa(grandpa);
		fight.setSnake(snake);//放置老爷爷和蛇精
		fight.printFight();//打印
		
		
		
		
	}

}
