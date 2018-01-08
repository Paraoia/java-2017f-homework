package huluwa3;

public class QuickSorter implements Sorter{
	Position[] positions;
	@Override 
	public void Sort(Queue queue)
	{
		positions=queue.getPositions();
		QuickSort(0,positions.length-1);
	}
	
	int partition(int low,int high)
	{
	
		Creature partition=positions[low].getHolder();
		while(low<high)
		{
			
			while (low<high&&partition.smallerThan(positions[high].getHolder(), 0)) high--;
			if(low<high)
			{
				positions[high].getHolder().tellMove(positions[high], positions[low]);
				positions[high].getHolder().setPosition(positions[low]);
				
				partition.tellMove(partition.getPosition(), positions[high]);
				partition.setPosition(positions[high]);
				
			}
			while (low<high&&positions[low].getHolder().smallerThan(partition, 0)) low++;
			if (low<high)
			{
				positions[low].getHolder().tellMove(positions[low], positions[high]);
				positions[low].getHolder().setPosition(positions[high]);
				partition.tellMove(partition.getPosition(), positions[low]);
				partition.setPosition(positions[low]);
				
				
			}
		}		
		
		return low;
	}
	
	void QuickSort(int low,int high)
	{
		if(low<high)
		{
			int pivot=partition(low,high);
			QuickSort(low,pivot-1);
			QuickSort(pivot+1,high);
		}
		return ;
	}
	

}
