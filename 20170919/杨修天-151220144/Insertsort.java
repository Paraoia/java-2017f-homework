package Huluwa;


	public class Insertsort implements Sorter{
		@Override 
		public void sort(Quene q)
		{
			Position[]duilie=q.getpositios();
			for(int i=1;i<duilie.length;i++)
				for(int j=0;j<i;j++)
				{if(((Compare)(duilie[j].getpeople())).bigger((Compare)(duilie[i].getpeople())))
					{
						Huluwa temp=duilie[i].getpeople();
						for(int k=i;k>j;k--)
						{	duilie[k].reportpeo();
							System.out.println(":"+k+"->"+(k+1));
							
							
							duilie[k].setpeople(duilie[k-1].getpeople());
							
						}
						duilie[i].reportpeo();
						System.out.println(":"+i+"->"+j);
						
						duilie[j].setpeople(temp);
						}
				}
		}
	}


