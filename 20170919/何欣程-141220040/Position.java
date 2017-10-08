
/*======描述一个坑的属性和行为========*/
public class Position {
	
	private int id;//第几号坑
	private boolean is_empty;//坑里有没有人
	private int dollid;//蹲在坑里的葫芦娃
	
	public Position(){
		id=-1;
		dollid=-1;
		is_empty=true;
	}
	
	public Position(int i){
		id=i;
		dollid=-1;
		is_empty=true;
	}
	
	//葫芦娃进坑
	public void addDoll(int newdoll){
		dollid=newdoll;
		is_empty=false;
	}
	
	//坑是否为空
	public boolean is_pos_empty(){
		return (is_empty==true);
	}
	
	public int get_dollid(){
		return dollid;
	}
}
