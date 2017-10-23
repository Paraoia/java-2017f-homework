enum Color {
    RED,ORANGE,YELLOW,GREEN,CYAN,BULE,PURPLE
}

enum Order{
	ONE,TWO,THREE,FOUR,FIVE,SIX,SEVNE
}

/*=====定义单个葫芦娃的属性和行为======*/
public class GourdDoll {
	private String name;//姓名
	private Order order;//排行
	private Color color;//颜色
	private int cur_pos;//当前位置
	//private int nex_pos;//下一个位置
	public GourdDoll(String cname,Order corder,Color ccolor,int ccur){
		name=cname;
		order=corder;
		color=ccolor;
		cur_pos=ccur;
		//nex_pos=cnex;
	}
	
	/*======方便输出中文=========*/
	public String order_to_chinese(Order order){
		int iorder=order.ordinal();
		String ret="";
		switch(iorder){
		case 0:
			ret="老大";
			break;
		case 1:
			ret="老二";
			break;
		case 2:
			ret="老三";
			break;
		case 3:
			ret="老四";
			break;
		case 4:
			ret="老五";
			break;
		case 5:
			ret="老六";
			break;
		case 6:
			ret="老七";
			break;
		}
		return ret;
	}
	/*======方便输出中文=========*/
	public String color_to_chinese(Color color){
		int icolor=color.ordinal();
		String ret="";
		switch(icolor){
		case 0:
			ret="红色";
			break;
		case 1:
			ret="橙色";
			break;
		case 2:
			ret="黄色";
			break;
		case 3:
			ret="绿色";
			break;
		case 4:
			ret="青色";
			break;
		case 5:
			ret="蓝色";
			break;
		case 6:
			ret="紫色";
			break;
		}
		return ret;
	}
	
	public void change_pos(int newpos){//挪动位置并报告
		System.out.println(order_to_chinese(order)+":"+cur_pos+"->"+newpos);
		cur_pos=newpos;
	}
	
	public void say_order(){//报告排行
		System.out.print(order_to_chinese(order)+"  ");
	}
	
	public void say_color(){//报告颜色
		System.out.print(color_to_chinese(color)+"  ");
	}	
	
	/*==对外传递成员===*/
	public String get_name(){
		return name;
	}
	public Order get_order(){
		return order;
	}
	public Color get_color(){
		return color;
	}
	public int get_pos(){
		return cur_pos;
	}
}
