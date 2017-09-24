package HuLuBro;

public class Sort {
	public Sort(){
		
	}
	public void BubbleSort(HuLuFamily hlf){
		int count=hlf.getCount();
		for(int i=0;i<count;i++){
			for(int j=0;j<count-i-1;j++){
				if(hlf.getHuLu(j)>hlf.getHuLu(j+1))
					hlf.exchange(j, j+1,true);
			}
		}
	}
	public void DivideSort(HuLuFamily hlf){
		int count=hlf.getCount();
		for(int i=0;i<count;i++){
			
			int begin=0;
			int end=i-1;
			int mid=(begin+end)/2;
			while(begin<=end){
				mid=(begin+end)/2;
				if(hlf.getHuLu(i)>=hlf.getHuLu(mid)){
					begin=mid+1;
					
				}
				else{		
						end=mid-1;
					
				}
			}
			for(int j=i;j>end+1;j--){
				hlf.exchange(j, j-1,true);
			}
				
		}
	}
}
