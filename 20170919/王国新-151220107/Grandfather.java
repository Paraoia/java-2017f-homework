import java.util.Random;

class Grandfather{

	public static void main(String args[]){
		Grandfather grandfather = new Grandfather();
		CalabashBoys[] boys = new CalabashBoys[7];
		
		grandfather.Initialize(boys);
		System.out.print("before BubbleSort: ");
		grandfather.RandomScheduling(boys);
		grandfather.OrderOfName(boys);
		grandfather.BubbleSort(boys);
		System.out.printf("%nafter BubbleSort: ");
		grandfather.OrderOfName(boys);

		System.out.printf("%nbefore BinarySort: ");
		grandfather.RandomScheduling(boys);
		grandfather.OrderOfColor(boys);
		grandfather.BinarySort(boys);
		System.out.printf("%nafter BinarySort: ");		
		grandfather.OrderOfColor(boys);
	}

	//关于葫芦娃的类
	class CalabashBoys{
		int order;
		String name;
		String color;

		CalabashBoys(int order,String color,String name){
			this.order = order;
			this.color = color;
			this.name = name;
		}
		
		int GetOrder(){
			return order;
		}
		//报颜色
		void SayName(){
			System.out.printf("%s ",this.name);
		}
		//报颜色
		void SayColor(){
			System.out.printf("%s ",this.color);
		}
		//报位置交换
		void SayLocation(int pre,int after){
			System.out.printf("%s:%d->%d ",this.name,pre,after);
		}
	}
	
	//葫芦娃的诞生
	void Initialize(CalabashBoys[] boys){
		boys[0] = new CalabashBoys(1,"红色","老大");
		boys[1] = new CalabashBoys(2,"橙色","老二");
		boys[2] = new CalabashBoys(3,"黄色","老三");
		boys[3] = new CalabashBoys(4,"绿色","老四");
		boys[4] = new CalabashBoys(5,"青色","老五");
		boys[5] = new CalabashBoys(6,"蓝色","老六");
		boys[6] = new CalabashBoys(7,"紫色","老七");
	}

	//用于生成随机数
	boolean IsEaqul(int randomSeq[],int n){
		for(int i=0;i<n;i++){
			if(randomSeq[n]==randomSeq[i])
				return false;
		}
		return true;
	}

	//给葫芦娃随机排队
	void RandomScheduling(CalabashBoys[] boys){
		int[] randomSeq = {-1,-1,-1,-1,-1,-1,-1};
		Random r = new Random();
		for(int i=0;i<randomSeq.length;i++){
			
			do{
				randomSeq[i]=r.nextInt(7);		
			}while(!IsEaqul(randomSeq,i));
		}
		CalabashBoys[] temp = new CalabashBoys[7];
		for(int i=0;i<randomSeq.length;i++){
			temp[i]=boys[randomSeq[i]];
		}
		for(int i=0;i<boys.length;i++){
			boys[i]=temp[i];
		}
	}

	//交换位置
	void Swap(CalabashBoys boys[],int m,int n){
		CalabashBoys temp = boys[m];
		boys[m]=boys[n];
		boys[n]=temp;		
	}
	
	//冒泡排序
	void BubbleSort(CalabashBoys boys[]){
		System.out.println("------------BubbleSort Begin------------");
		for(int i=0;i<boys.length-1;i++){
			for(int j=i;j<boys.length;j++){
				if(boys[i].GetOrder()>boys[j].GetOrder())
				{
					Swap(boys,i,j);
					boys[i].SayLocation(j+1,i+1);
					boys[j].SayLocation(i+1,j+1);
				}
			}
		}
		System.out.println();
	}

	//二分查找
	int BinarySearch(CalabashBoys boys[],int index,int low,int high){
	    if (high <= low)
	        return (boys[index].GetOrder() > boys[low].GetOrder())?  (low + 1): low;

	    int mid = (low + high)/2;

	    if(boys[index].GetOrder() > boys[mid].GetOrder())
	        return BinarySearch(boys, index, mid+1, high);
	    return BinarySearch(boys, index, low, mid-1);
	}

	//二分插入排序
	void BinarySort(CalabashBoys boys[]){
		System.out.println("------------BinarySort Begin------------");
		for(int i=1;i<boys.length;i++){
			int index = BinarySearch(boys,i,0,i-1);
			if(index == i)
				continue;
			CalabashBoys temp = boys[i];
			for(int j=i;j>index;j--){
				boys[j]=boys[j-1];
				boys[j-1].SayLocation(j,j+1);
			}
			boys[index]=temp;
			boys[index].SayLocation(i+1,index+1);
		}
		System.out.println();
	}

	//名字的顺序
	void OrderOfName(CalabashBoys boys[]){
		for(int i=0;i<boys.length;i++){
			boys[i].SayName();
		}
		System.out.println();
	}

	//颜色的顺序
	void OrderOfColor(CalabashBoys boys[]){
		for(int i=0;i<boys.length;i++){
			boys[i].SayColor();
		}
		System.out.println();
	}
}
