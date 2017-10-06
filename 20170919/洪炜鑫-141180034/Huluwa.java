/**************************************************
	> File Name:   Huluwa.java
	> Author:      Leuckart
	> Time:        2017-10-05  21:54
**************************************************/

import java.util.*;

/* PUBLIC METHODS
*** Huluwa.Huluwa(String s);
*** Huluwa.toString();
*** Huluwa.getName();
*** Huluwa.getColor();
*** Huluwa.getPos();
*/

public class Huluwa
{
	private enum Rank
	{
		ONE("老大","红色"),TWO("老二","橙色"),THREE("老三","黄色"),FOUR("老四","绿色"),FIVE("老五","青色"),SIX("老六","蓝色"),SEVEN("老七","紫色");
		private String name,color;
		private Rank(String name,String color) { this.name=name; this.color=color; }
	}

	private Rank ID;

	public Huluwa(String s)
	{
		switch(s)
		{
			case "ONE":
				ID=Rank.ONE;
				break;
			case "TWO":
				ID=Rank.TWO;
				break;
			case "THREE":
				ID=Rank.THREE;
				break;
			case "FOUR":
				ID=Rank.FOUR;
				break;
			case "FIVE":
				ID=Rank.FIVE;
				break;
			case "SIX":
				ID=Rank.SIX;
				break;
			case "SEVEN":
				ID=Rank.SEVEN;
				break;
			default:
				break;
		}
	}

	public String toString()
	{
		return ID.name+"("+ID.color+")";
	}

	public String getName() { return ID.name; }

	public String getColor() { return ID.color; }

	public int getPos() { return ID.ordinal(); }
}
