import java.util.Random;

class Huluwa{
	public static void main(String args[]){
		Hulu hulus = new Hulu();

		hulus.Born();             //葫芦娃从葫芦里诞生
		System.out.print("before BubbleSort: ");
		hulus.RandomScheduling(); //葫芦娃随机选择葫芦坐下
		hulus.OrderOfName();      //当前按序的葫芦娃的名字
		hulus.BubbleSort();		  //根据冒泡排序给葫芦娃找到正确的葫芦
		System.out.printf("%nafter BubbleSort: ");
		hulus.OrderOfName();      //当前按序的葫芦娃的名字

		System.out.printf("%nbefore BinarySort: ");
		hulus.RandomScheduling(); //葫芦娃随机选择葫芦坐下
		hulus.OrderOfColor();	  //当前按序的葫芦娃的颜色
		hulus.BinarySort();		  //根据二分查找排序给葫芦娃找到正确的葫芦
		System.out.printf("%nafter BinarySort: ");		
		hulus.OrderOfColor();	  //当前按序的葫芦娃的颜色
	}
}

//关于葫芦娃的类
class CalabashBoys{
	private int order;    
	private	String name;   
	private	String color;

	//构造函数
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

//关于葫芦的类
class Hulu{
	CalabashBoys[] boys = new CalabashBoys[7];

	//葫芦娃的诞生
	public void Born(){
		boys[0] = new CalabashBoys(1,"红色","老大");
		boys[1] = new CalabashBoys(2,"橙色","老二");
		boys[2] = new CalabashBoys(3,"黄色","老三");
		boys[3] = new CalabashBoys(4,"绿色","老四");
		boys[4] = new CalabashBoys(5,"青色","老五");
		boys[5] = new CalabashBoys(6,"蓝色","老六");
		boys[6] = new CalabashBoys(7,"紫色","老七");
	}

	//判断生成的随机数是否重复
	public boolean IsEaqul(int randomSeq[],int n){
		for(int i=0;i<n;i++){
			if(randomSeq[n]==randomSeq[i])
				return false;
		}
		return true;
	}

	//给葫芦娃随机排队
	public void RandomScheduling(){
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
	public void Swap(int m,int n){
		CalabashBoys temp = boys[m];
		boys[m]=boys[n];
		boys[n]=temp;		
	}
	
	//冒泡排序
	public void BubbleSort(){
		System.out.println("------------BubbleSort Begin------------");
		for(int i=0;i<boys.length-1;i++){
			for(int j=i;j<boys.length;j++){
				if(boys[i].GetOrder()>boys[j].GetOrder())
				{
					Swap(i,j);
					boys[i].SayLocation(j+1,i+1);
					boys[j].SayLocation(i+1,j+1);
				}
			}
		}
		System.out.println();
	}

	//二分查找
	public int BinarySearch(int index,int low,int high){
	    if (high <= low)
	        return (boys[index].GetOrder() > boys[low].GetOrder())?  (low + 1): low;

	    int mid = (low + high)/2;

	    if(boys[index].GetOrder() > boys[mid].GetOrder())
	        return BinarySearch(index, mid+1, high);
	    return BinarySearch(index, low, mid-1);
	}

	//二分插入排序
	public void BinarySort(){
		System.out.println("------------BinarySort Begin------------");
		for(int i=1;i<boys.length;i++){
			int index = BinarySearch(i,0,i-1);
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
	public void OrderOfName(){
		for(int i=0;i<boys.length;i++){
			boys[i].SayName();
		}
		System.out.println();
	}

	//颜色的顺序
	void OrderOfColor(){
		for(int i=0;i<boys.length;i++){
			boys[i].SayColor();
		}
		System.out.println();
	}
}