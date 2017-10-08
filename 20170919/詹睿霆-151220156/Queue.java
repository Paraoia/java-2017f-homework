import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Queue{
	public Position[] positions;
	
    public Queue() {
        positions = new Position[7];
        for (int i = 0; i < positions.length; i++) {
            positions[i] = new Position();
            positions[i].index = i+1;
            positions[i].holder = null;
        }
    }
    
    public void QueueByRandom(CalabashBro[] Huluwas){
        if (Huluwas.length > this.positions.length)
            return; 
        List list=Arrays.asList(0,1,2,3,4,5,6);
        Collections.shuffle(list);
        for(int i=0;i<7;i++)
        	positions[i].holder=Huluwas[(int) list.get(i)];
        System.out.print("现在的位置：");
        for(int i=0;i<7;i++)
        	System.out.print(positions[i].holder.name+" ");
        System.out.println();
    }
    
    public void swap(int i,int j){
		System.out.print(positions[i].holder.name+":我和"+positions[j].holder.name+"换 ");
		System.out.println(positions[i].index+"->"+positions[j].index);
		System.out.print(positions[j].holder.name+":行，那我和"+positions[i].holder.name+"换吧 ");
		System.out.println(positions[j].index+"->"+positions[i].index);
		CalabashBro temp=positions[i].holder;
		positions[i].holder=positions[j].holder;
		positions[j].holder=temp;
    }
    
    public void QueueBySeniority(){
    	for(int i=0;i<7;i++){
    		for(int j=0;j<6-i;j++){
    			if(positions[j].holder.seniority>positions[j+1].holder.seniority){
    				swap(j,j+1);
    			}
    		}
    	}
    	System.out.print("现在的位置：");
        for(int i=0;i<7;i++)
        	System.out.print(positions[i].holder.name+" ");
        System.out.println();
    }
    
    public void QueueByColor(){
    	QuickSort(0,6);
    	System.out.print("现在的位置：");
        for(int i=0;i<7;i++)
        	System.out.print(positions[i].holder.name+" ");
        System.out.println();
    }
    
    public void QuickSort(int low,int high){
		if(low>=high)
			return;
		int i = low,j = high;
		CalabashBro pivot=positions[i].holder;
		System.out.println(pivot.name+": 我先从"+positions[i].index+"位站开，你们看着办");
		while(i<j){
			while (i < j&& positions[j].holder.color.compareTo(pivot.color)>=0)
				j--;
			positions[i].holder=positions[j].holder;
			System.out.println(positions[i].holder.name+": 现在该我在"+positions[j].index+"位 ");
			while (i < j &&positions[i].holder.color.compareTo(pivot.color)<=0)
				i++;
			positions[j].holder=positions[i].holder;
			System.out.println(positions[j].holder.name+": 现在该我在"+positions[i].index+"位 ");
		}
		positions[i].holder = pivot;
		System.out.println(pivot.name+": 那我就在"+positions[i].index+"位吧");
		QuickSort(low, i - 1);
		QuickSort(i + 1, high);
    }
}

class Position {
    public int index;
    public CalabashBro holder;
}