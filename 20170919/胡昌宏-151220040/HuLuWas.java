enum Color{
    RED, ORANGE, YELLOW, GREEN, CYAN, BLUE, PURPLE;
}

public class HuLuWas {    //葫芦娃个体类
	int rank;
    Color color;
   
   HuLuWas(int r, Color c){
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
	   case 1:
		   rank_to_chinese = "老大"; break;
	   case 2:
		   rank_to_chinese = "老二"; break;
	   case 3:
		   rank_to_chinese = "老三"; break;
	   case 4:
		   rank_to_chinese = "老四"; break;
	   case 5:
		   rank_to_chinese = "老五"; break;
	   case 6:
		   rank_to_chinese = "老六"; break;
	   case 7:
		   rank_to_chinese = "老七"; break;
	   default:
		   break;  
	  }
	  return rank_to_chinese;
   }
}
