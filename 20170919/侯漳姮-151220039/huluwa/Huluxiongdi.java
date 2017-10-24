package huluwa;
public class Huluxiongdi {
	final int COUNT=7;
	int color;
	int name;
	int seat;
	public Huluxiongdi(int colors,int names,int seats)
	{
		color=colors;
		name=names;
		seat=seats;
	}
	public int getcount(){
		return COUNT;
	}
	public void change_sit(int i,int j)
	{
		String name=getname();
		System.out.println(name+":"+i+"->"+j);		
			
	}
	public String getcolor()
	{
		String ans;
		 switch(color){
  
         case 1:
             ans="红色";
             break;
         case 2:
        	 ans="橙色";
             break;
         case 3:
        	 ans="黄色";
             break;
         case 4:
        	 ans="绿色";
             break;
         case 5:
        	 ans="青色";
             break;
         case 6:
        	 ans="蓝色";
             break;
         case 7:
        	 ans="紫色";
             break;
         default:
        	 ans="没有这个颜色";
             break;
        }
		 return ans;
	}
	public String getname()
	{
		String ans;
		 switch(this.name){
       
         case 1:
        	 ans="老大";
             break;
         case 2:
        	 ans="老二";
             break;
         case 3:
        	 ans="老三";
             break;
         case 4:
        	 ans="老四";
             break;
         case 5:
        	 ans="老五";
             break;
         case 6:
        	 ans="老六";
             break;
         case 7:
        	 ans="老七";
             break;
           default:
        	 ans="没有这个葫芦娃";
             break;
        }
		 return ans;
	}
}
