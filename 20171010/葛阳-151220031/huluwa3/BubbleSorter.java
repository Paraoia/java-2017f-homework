package huluwa3;

public class BubbleSorter implements Sorter{

	
	@Override
	public void Sort(Queue queue)
	{
		Position[] positions=queue.getPositions();
		
		for(int i=0; i< positions.length; i++) {
			int min=i;
			for (int j=i+1;j<7;j++)
			{
				if (positions[j].getHolder().smallerThan(positions[min].getHolder(), 1))
					min=j;					
			}
			if (min!=i)
			{	
				Creature temp=positions[i].getHolder();
				positions[min].getHolder().tellMove(positions[min],positions[i]);
				positions[i].getHolder().tellMove(positions[i],positions[min]);
				positions[min].getHolder().setPosition(temp.getPosition());		
				temp.setPosition(positions[min]);
				
			}
			}
	}
	
}
