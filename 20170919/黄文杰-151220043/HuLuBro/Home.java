package HuLuBro;
import java.util.*;
public class Home {
	Chair []chair;
	
	final int HULUCOUNT=7;
	public Home(HuLuWa []huluwa){
		chair=new Chair[HULUCOUNT+1];
		
		for(int i=0;i<HULUCOUNT+1;i++){
			chair[i]=new Chair();
		}
		chair[0].holder=huluwa[4];
		chair[1].holder=huluwa[2];
		chair[2].holder=huluwa[0];
		chair[3].holder=huluwa[6];
		chair[4].holder=huluwa[1];
		chair[5].holder=huluwa[3];
		chair[6].holder=huluwa[5];
		
	}
	void messUp(){
		Random random = new Random();
		
		for(int i=0;i<HULUCOUNT;i++){
			int j=Math.abs(random.nextInt())%7;
			changeChair(i, HULUCOUNT,false);
			changeChair(j,i,false);
			changeChair(HULUCOUNT,j,false);
		}
	}
	void changeChair(int from,int to,boolean show){//把from位置上的葫芦娃放到to位置上
		if(show)
			chair[from].holder.shout(from, to);
		chair[to]=chair[from];
		chair[from]=null;
	}
	public void outName(){//按顺序报名字
		for(int i=0;i<HULUCOUNT;i++){
			System.out.print(chair[i].holder.getName()+' ');
		}
		System.out.println("");
	}
	public void outColor(){//按顺序报颜色
		for(int i=0;i<HULUCOUNT;i++){
			String colorName=new String("");
			switch(chair[i].holder.getColor()){
			case RED:colorName="红色";break;
			case ORANGE:colorName="橙色";break;
			case YELLOW:colorName="黄色";break;
			case GREEN:colorName="绿色";break;
			case CHING:colorName="青色";break;
			case BLUE:colorName="蓝色";break;
			case PURPLE:colorName="紫色";break;
			}
			System.out.print(colorName+' ');
		}
		System.out.println("");
	}
	public void bubbleSort(){//冒泡排序
		int count=HULUCOUNT;
		for(int i=0;i<count;i++){
			for(int j=0;j<count-i-1;j++){
				if(chair[j].holder.getRank()>chair[j+1].holder.getRank()){//用第七个位置作为临时中转进行交换
					changeChair(j,HULUCOUNT,true);
					changeChair(j+1,j,true);
					changeChair(HULUCOUNT,j+1,true);
				}
			}
		}
	}
	public void divideSort(){//二分排序
		int count=HULUCOUNT;
		for(int i=0;i<count;i++){
			
			int begin=0;
			int end=i-1;
			int mid=(begin+end)/2;
			while(begin<=end){
				mid=(begin+end)/2;
				if(chair[i].holder.getColor().compareTo(chair[mid].holder.getColor())>0){
					begin=mid+1;
					
				}
				else{		
						end=mid-1;
					
				}
			}
			for(int j=i;j>end+1;j--){
				
				changeChair(j,HULUCOUNT,true);
				changeChair(j-1,j,true);
				changeChair(HULUCOUNT,j-1,true);
			}
				
		}
	}
}

class Chair{
	HuLuWa holder;//凳子上坐的葫芦娃
}