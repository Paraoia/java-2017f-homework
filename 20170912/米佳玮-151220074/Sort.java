public class Sort {
        public static void main(String[] args) {
                int array[] = new int[]{6,5,4,8,7,2,67,24};
               
                for(int i=0;i<array.length-1;i++)
                {
			int smallest_index=i;
			for(int j=i+1;j<array.length;j++) 
                        {
                        	if (array[j]<array[smallest_index])
                                	smallest_index = j;
			}
			
			if(smallest_index!=i)
			{
				int temp=array[smallest_index];
				array[smallest_index]=array[i];
				array[i]=temp;
			}

                }
		
		for(int i=0;i<array.length;i++)
		{
                	System.out.println(array[i]);
                }
        }
}