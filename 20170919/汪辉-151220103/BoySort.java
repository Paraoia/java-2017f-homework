import java.util.ArrayList;
import java.util.Iterator;
public class BoySort {
	private CalabashDoll []Boy=new CalabashDoll[7];
	BoySort() { 
		ArrayList<Integer> set=new ArrayList<Integer>();
	   while(set.size()<7) {
		   int num = (int) (Math.random() *(7-0));
		   if(set.contains(num)) continue;
		   set.add(num);
	   }
	   int i=0;
	   Iterator<Integer> iterator = set.iterator();  
       while (iterator.hasNext()) {  
          Boy[i]=new CalabashDoll(iterator.next()); 
          i++;
       }
	}
	public void SortByColor() {
	        for (int i = 1; i < Boy.length; i++) {
	        	CalabashDoll temp = Boy[i];
	            int right = i - 1;
	            int left = 0;
	            int mid;
	            while (left <= right) {
	                mid = (left + right) / 2;
	                if (Boy[mid].colorCompare(temp)>0) {
	                    right = mid - 1;
	                } else if (Boy[mid].colorCompare(temp)<0) {
	                    left = mid + 1;
	                }
	            }
	            for (int j = i; j > left; j--) {
	                Boy[j] = Boy[j - 1];
	            	System.out.print(Boy[j].getColor()+": "+(j-1)+"->"+j+"  ,");
	            }
	            Boy[left] = temp;
	            System.out.print(temp.getColor()+": "+i+"->"+left+"  ,");
	        }
	        System.out.println();
	}
	public void SortByRank() {
		for(int i=1;i<7;i++) {
			for(int j=0;j<7-i;j++)
			{
				if(Boy[j].colorCompare(Boy[j+1])>0){
					System.out.print(Boy[j].getname()+": "+j+"->"+(j+1)+"  ,");
					System.out.print(Boy[j+1].getname()+": "+(j+1)+"->"+j+"  ,");
					CalabashDoll temp=Boy[j];
					Boy[j]=Boy[j+1];
					Boy[j+1]=temp;
				}
			}
		}
		System.out.println();
	}
	public void BaoShu() {
		for(CalabashDoll b:Boy) {
			System.out.print(b.getname()+"  ");
		}
		System.out.println();
	}
	public void BaoColor() {
		for(CalabashDoll b:Boy) {
			System.out.print(b.getColor()+"  ");
		}
		System.out.println();
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("随机站队");
		BoySort A=new BoySort();
		A.BaoShu();
		System.out.println("按排行排序");
		A.SortByRank();
		System.out.println("排序结果");
		A.BaoShu();
		System.out.println("随机站队");
		BoySort B=new BoySort();
		B.BaoColor();
		System.out.println("按颜色排序");
		B.SortByColor();
		System.out.println("排序结果");
		B.BaoColor();
	}
}
