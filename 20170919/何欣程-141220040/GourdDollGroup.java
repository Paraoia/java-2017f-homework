import java.util.Random;

/*=====描述一群葫芦娃和一群坑的互动=====*/
public class GourdDollGroup {
	
	private GourdDoll[] brothers;//数组保存葫芦娃兄弟
	private Position[] position;//数组保存1-7号坑情况
	private boolean[] is_empty;//辅助变量，记录坑占用情况
	
	public GourdDollGroup(){
		brothers=new GourdDoll[8];//葫芦娃序号1-7
		position=new Position[8];//位置序号1-7
		is_empty=new boolean[8];
		/*===初始坑号，且全部没人====*/
		for(int i=1;i<8;i++){
			position[i]=new Position(i);
			is_empty[i]=true;
		}
	}

	/*====一个葫芦娃诞生，葫芦娃序列里加入这个葫芦娃,并安排葫芦娃入坑====*/
	public void AddDoll(String cname,Order corder,Color ccolor,int ccur,int id){
		brothers[id]=new GourdDoll(cname,corder,ccolor,ccur);
		position[ccur].addDoll(id);
		//is_empty[ccur]=false;
	}
	
	/*=====所有葫芦娃诞生，并随机入坑===*/
	public void DollsBorn(){
		for(int i=1;i<=7;i++)
			is_empty[i]=true;
		int []randnum=new int[8];
		Random random = new Random();
		/*=======给每个葫芦娃分发随机数，存储在randnum数组中===*/
		for(int i=1;i<=7;i++){
			int rand=random.nextInt(8);
			while(rand==0||is_empty[rand]==false)
				rand=random.nextInt(8);
			randnum[i]=rand;
			is_empty[rand]=false;
		}
		/*======葫芦娃入坑=======*/
		AddDoll("红娃",Order.ONE,Color.RED,randnum[1],1);
		AddDoll("橙娃",Order.TWO,Color.ORANGE,randnum[2],2);
		AddDoll("黄娃",Order.THREE,Color.YELLOW,randnum[3],3);
		AddDoll("绿娃",Order.FOUR,Color.GREEN,randnum[4],4);
		AddDoll("青娃",Order.FIVE,Color.CYAN,randnum[5],5);
		AddDoll("蓝娃",Order.SIX,Color.BULE,randnum[6],6);
		AddDoll("紫娃",Order.SEVNE,Color.PURPLE,randnum[7],7);
	}
	
	/*========按排行冒泡排序====*/
	public void BubbleSort(){
		int p1,p2,d1,d2;
		for(int i=7;i>1;i--)
			for(int j=1;j<i;j++){
				if(brothers[position[j].get_dollid()].get_order().ordinal()>brothers[position[j+1].get_dollid()].get_order().ordinal()){			
					d1=position[j].get_dollid();
					d2=position[j+1].get_dollid();
					p1=brothers[d1].get_pos();
					p2=brothers[d2].get_pos();
					//葫芦娃更新坑号
					brothers[d1].change_pos(p2);
					brothers[d2].change_pos(p1);	
					//坑更新葫芦娃
					position[p1].addDoll(d2);
					position[p2].addDoll(d1);
				}
					
			}
	}
	
	/*===============按颜色快速排序========================*/
	public void quickSort(){
	    qsort(1, 7);
	}
	public void qsort(int low, int high){
	    if (low < high){
	        int pivot=partition(low, high);        //将数组分为两部分
	        qsort(low, pivot-1);                   //递归排序左子数组
	        qsort(pivot+1, high);                  //递归排序右子数组
	    }
	}
	public int partition(int low, int high){
	    int pivot = brothers[position[low].get_dollid()].get_color().ordinal();     //枢轴记录
	    int preid=position[low].get_dollid();
	    while (low<high){
	        while (low<high && brothers[position[high].get_dollid()].get_color().ordinal()>=pivot) --high;
            //交换比枢轴小的记录到左端
	        position[low].addDoll(position[high].get_dollid());
	        brothers[position[high].get_dollid()].change_pos(low);
	        while (low<high && brothers[position[low].get_dollid()].get_color().ordinal()<=pivot) ++low;
           //交换比枢轴小的记录到右端
	        position[high].addDoll(position[low].get_dollid());
	        brothers[position[high].get_dollid()].change_pos(high);
	    }
	    //扫描完成，枢轴到位
	    position[low].addDoll(preid);
	    brothers[preid].change_pos(low);
	    //返回的是枢轴的位置
	    return low;
	}

	
	/*======1-7号坑里的葫芦娃依次报数======*/
	public void SayOrder(){
		for(int i=1;i<=7;i++){
			brothers[position[i].get_dollid()].say_order();
		}
	}
	public void SayColor(){
		for(int i=1;i<=7;i++){
			brothers[position[i].get_dollid()].say_color();
		}
	}
}
	
	

