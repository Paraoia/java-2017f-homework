//package pack;

public class World {

	public static void main(String[] args)
	{
		
	Hulu[] bro=new Hulu[7];//有7个葫芦娃	
	Queue que = new Queue();//有一个队列
	
	
	que.initQue(bro);//初始化队列
	que.sortByNum();//按编号冒泡排序
	que.Number();//报号
	que.initQue(bro);//初始化队列
	que.sortByCol();//按颜色快速排序
	que.Color();//报颜色
	}
	
}
