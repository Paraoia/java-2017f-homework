/**************************************************
	> File Name:  God.java
	> Author:     Leuckart
	> Time:       2017-10-06 20:33
**************************************************/

public class God
{
	public static void main(String args[])
	{
		HuluBrothers hlb=HuluBrothers.getInstance();
		System.out.println("初始状态:\n"+hlb+"\n");
		
		hlb.shuffle();
		System.out.println("第一次随机站队:\n"+hlb+"\n交换动作如下:");

		hlb.bubbleSort();
		System.out.println("排序结果:");
		hlb.countOff("name");

		hlb.shuffle();
		System.out.println("\n第二次随机站队:\n"+hlb+"\n交换动作如下:");
		hlb.quickSort();
		hlb.countOff("color");		
	}
}
