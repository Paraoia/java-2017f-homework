package HuLuBro;

public class HuLuFamily{
	final int HULUCOUNT=7;
	int []HuLuBro;
	public HuLuFamily(){
		HuLuBro=new int[HULUCOUNT];
		for(int i=1;i<=HULUCOUNT;i++)
			HuLuBro[i-1]=i;
	}
	public void exchange(int x,int y,boolean show){
		int temp=HuLuBro[x];
		HuLuBro[x]=HuLuBro[y];
		HuLuBro[y]=temp;
		if(show==true){
			System.out.println(getName(getHuLu(y))+":"+String.valueOf(x)+"->"+String.valueOf(y));
			System.out.println(getName(getHuLu(x))+":"+String.valueOf(y)+"->"+String.valueOf(x));
		}		
	}
	public int getHuLu(int x){
		return HuLuBro[x];
	}
	public int getCount(){
		return HULUCOUNT;
	}
	public String getName(int x){
		String s="";
		switch(x){
		case 1:s= "老大";break;
		case 2:s= "老二";break;
		case 3:s= "老三";break;
		case 4:s= "老四";break;
		case 5:s= "老五";break;
		case 6:s= "老六";break;
		case 7:s= "老七";break;
		}
		return s;
	}
	public String getColor(int x){
		String s="";
		switch(x){
		case 1:s= "红色";break;
		case 2:s= "橙色";break;
		case 3:s= "黄色";break;
		case 4:s= "绿色";break;
		case 5:s= "青色";break;
		case 6:s= "蓝色";break;
		case 7:s= "紫色";break;
		}
		return s;
	}
	

}
