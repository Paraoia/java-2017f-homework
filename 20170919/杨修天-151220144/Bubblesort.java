package Huluwa;

public class Bubblesort implements Sorter{
	@Override 
	public void sort(Quene q)
	{
		Position[]duilie=q.getpositios();
		for(int i=0;i<duilie.length;i++)
			for(int j=0;j<duilie.length-i-1;j++)
			{if(((Compare)(duilie[j].getpeople())).bigger((Compare)(duilie[j+1].getpeople())))
				{	duilie[j].reportpeo();
					System.out.println(":"+j+"->"+(j+1));
					duilie[j+1].reportpeo();
					System.out.println(":"+(j+1)+"->"+j);
					Huluwa temp=duilie[j].getpeople();
					duilie[j].setpeople(duilie[j+1].getpeople());
					duilie[j+1].setpeople(temp);
					
					
				}
			}
	}
}
