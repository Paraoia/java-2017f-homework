package sorting_Calabashboys;

//这是一个葫芦娃的类
public class Calabash_boy {
	public final static int NULL =0;
	
private
	//葫芦娃的私有成员

	Color color;
	int rank;
	
protected	
	//以下函数用于返回私有信息，不对用户开放，只对派生类开放

	//让葫芦娃返回自己的颜色
	Color Return_col() {
		return color;
	}
	
	//让葫芦娃返回自己的排行
	int Return_rank() {
		return rank;
	}
	
	
public
	//用户接口

	//构造函数
	Calabash_boy(){
		color = Color.Null;
		rank = NULL;
	}
	
	//给定颜色和排行的构造函数
	Calabash_boy(Color col, int r){
		color = col;
		rank = r;
	}
	
	//设定一个葫芦娃的颜色并依此设定排行
	void Set_color(Color col) {
		color = col;
		rank = col.ordinal();
	}
	
	//设定一个葫芦娃的颜色和排行
	void Set_color_rank(Color col, int r) {
		color = col;
		rank = r;
	}
	
	
	//让葫芦娃报告自己排行
	String Report_rank_string() {
		String r = "葫芦娃";
		switch(color.ordinal()) {
			case 1:		r = "大娃";break;
			case 2:		r = "二娃";break;
			case 3:		r = "三娃";break;
			case 4:		r = "四娃";break;
			case 5:		r = "五娃";break;
			case 6:		r = "六娃";break;
			case 7:		r = "七娃";break;
			default:	r = "没有设置排行";break;
		}
		return r;
	}
	
	//让葫芦娃报告自己颜色
	String Report_color_string() {
		String r = "葫芦娃";
		switch(rank) {
			case 1:		r = "赤";break;
			case 2:		r = "橙";break;
			case 3:		r = "黄";break;
			case 4:		r = "绿";break;
			case 5:		r = "青";break;
			case 6:		r = "蓝";break;
			case 7:		r = "紫";break;
			default: 	r = "没有设置颜色";break;
		}
		return r;
	}
	

}

