
package huluwa3;
import java.util.Random;
public class Queue {
	
	private Position[] positions;
	private Creature[] creatures;
	
	public Queue(Creature[] creaturesToSet)//初始化队伍和生物
	{
		this.creatures=creaturesToSet;
		this.positions=new Position[creatures.length];//设定队伍长度
		
		for (int i=0;i<creatures.length;i++)
		{
			positions[i]=new Position(i,0);
			creatures[i].setPosition(positions[i]);
			
		}
		
	}
	public Position[] getPositions()
	{
		return positions;
	}
	
	public void queueReport()
	{
		for (int i=0;i<positions.length;i++)
		{
			positions[i].getHolder().report();
			System.out.print(" ");
		}
		System.out.println();
	}
	
	public void shuffle()
	{
		 Random random = new Random();
	     for (int i = creatures.length - 1; i >= 0; i--) {
	            int index = random.nextInt(i + 1);
	            Position position = creatures[index].getPosition();
	            creatures[index].setPosition(creatures[i].getPosition());
	            creatures[i].setPosition(position);
	        }
	     
	}
		
	public void setFirst(Position pos)
	{
		creatures[0].setPosition(pos);
	}
	
	public Creature[] getCreatures()
	{
		return creatures;
	}
	
	/*
	public static void main(String[] args)
	{
		//System.out.print(COLOR.values()[4]);
		Huluwa[] brothers=new Huluwa[7];
		 for (int i = 0; i < brothers.length; i++) {
			 
	            brothers[i]=new Huluwa(COLOR.values()[i], NUMBER.values()[i]);
	        }
		 
		 Queue huluQueue=new Queue(brothers);
		 huluQueue.queueReport();
		 
		 huluQueue.shuffle();
		 huluQueue.queueReport();
		 
		 Sorter bubble=new BubbleSorter();
		 bubble.Sort(huluQueue);
		 huluQueue.queueReport();
		 
		 huluQueue.shuffle();
		 huluQueue.queueReport();
		 
		 Sorter quick=new QuickSorter();
		 quick.Sort(huluQueue);
		 huluQueue.queueReport();
		
	}
*/
}
