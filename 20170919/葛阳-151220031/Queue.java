//package pack;

public class Queue {

	
	Seat[] seats=new Seat[7];//7张椅子，1...7
	Seat empty=new Seat(0);//空椅子用于交换位置时临时使用
	
	//初始化葫芦娃和椅子
	void initQue(Hulu[] bro)
	{
		for (int i=0;i<7;i++)
		{	
			bro[i]=new Hulu();
			bro[i].setHulu(i);
			seats[i]=new Seat(i+1);
		}
		
		//葫芦娃乱序坐到椅子上
		seats[0].holder=bro[2];
		seats[1].holder=bro[1];
		seats[2].holder=bro[3];
		seats[3].holder=bro[4];
		seats[4].holder=bro[0];
		seats[5].holder=bro[6];
		seats[6].holder=bro[5];
		
		
	}
	//从前往后报号
	void Number()
	{
		for (int i=0;i<7;i++)
		{
			seats[i].holder.tellNum();
		}
		System.out.println();
	}
	//从前往后报颜色
	void Color()
	{
		for (int i=0;i<7;i++)
		{
			seats[i].holder.tellCol();
		}
		System.out.println();
	}
	//按排行排序
	void sortByNum() {
		for(int i=0; i< 7; i++) {
			int min=i;
			for (int j=i+1;j<7;j++)
			{
				if(seats[j].holder.getRankOrd()<seats[min].holder.getRankOrd())
					min=j;					
			}
			if (min!=i)
			{	
				seats[i].holder.gotoSeat(seats[i],empty);//先坐上空椅子
				seats[min].holder.gotoSeat(seats[min],seats[i]);		
				empty.holder.gotoSeat(empty,seats[min]);
				
			}
			}
	}
	
	//按颜色快速排序
		int partition(int low,int high)
		{
			seats[low].holder.gotoSeat(seats[low], empty);

			while(low<high)
			{
				
				while (low<high&&seats[high].holder.getColOrd()>=empty.holder.getColOrd()) high--;
				if(low<high)
				{
					seats[high].holder.gotoSeat(seats[high], seats[low]);
				
				}
				while (low<high&&seats[low].holder.getColOrd()<=empty.holder.getColOrd()) low++;
				if (low<high)
				{
					seats[low].holder.gotoSeat(seats[low], seats[high]);
				
				}
			}		
			empty.holder.gotoSeat(empty, seats[low]);
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
		void sortByCol() {
			QuickSort(0,6);
		}
		
			
}

