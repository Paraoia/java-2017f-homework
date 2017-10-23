enum Color{
    RED, ORANGE, YELLOW, GREEN, CYAN, BLUE, PURPLE;
}

enum Rank{
	ONE, TWO, THREE, FOUR, FIVE, SIX, SEVEN;
}

public class Huluwas implements Creature, Comparable{    //葫芦娃个体类
    private Color color;
    private Rank rank;
    private Position position;
    Huluwas(Rank r, Color c){
       rank = r;
       color = c;
   }
   
   public String Report_Color() {  //报自己的颜色
	   String color_to_chinese = "颜色";
	   switch(color) {
	   case RED:
		   color_to_chinese = "红"; break;
	   case ORANGE:
		   color_to_chinese = "橙"; break;
	   case YELLOW:
		   color_to_chinese = "黄"; break;
	   case GREEN:
		   color_to_chinese = "绿"; break;
	   case CYAN:
		   color_to_chinese = "青"; break;
	   case BLUE:
		   color_to_chinese = "蓝"; break;
	   case PURPLE:
		   color_to_chinese = "紫"; break;
	   default:
		   break;
	   }
	   return color_to_chinese;
   }
   
   public String Report_Rank() {   //报自己的排行
	  String rank_to_chinese = "待定";
	  switch(rank) {
	   case ONE:
		   rank_to_chinese = "大娃"; break;
	   case TWO:
		   rank_to_chinese = "二娃"; break;
	   case THREE:
		   rank_to_chinese = "三娃"; break;
	   case FOUR:
		   rank_to_chinese = "四娃"; break;
	   case FIVE:
		   rank_to_chinese = "五娃"; break;
	   case SIX:
		   rank_to_chinese = "六娃"; break;
	   case SEVEN:
		   rank_to_chinese = "七娃"; break;
	   default:
		   break;  
	  }
	  return rank_to_chinese;
   }
   
   public Color getColor() {
	   return color;
   }
   public Rank getRank() {
	   return rank;
   }
   
   public void report() {
	   System.out.print(Report_Rank()+Report_Color()+'\t');
   }
	public void setPosition(Position position) {
		this.position = position;
		position.setHolder(this);
		position.InPos();
	}
	public Position getPosition() {
		return this.position;
	}
	
	public boolean biggerThan(Comparable brother){
		if (brother instanceof  Huluwas)
            return this.getRank().ordinal()> ((Huluwas) brother).getRank().ordinal();
        else
            return false;
    }

}