import java.util.Scanner;

public class Sort
{
	public enum Color
	{
		RED,ORANGE,YELLOW,GREEN,CYAN,BLUE,PURPLE;
		public void displayRank()
		{
			switch (ordinal())
			{
				case 0:
					System.out.println("老大");
					break;
				case 1:
					System.out.println("老二");
					break;
				case 2:
					System.out.println("老三");
					break;
				case 3:
					System.out.println("老四");
					break;
				case 4:
					System.out.println("老五");
					break;
				case 5:
					System.out.println("老六");
					break;
				case 6:
					System.out.println("老七");
			}
		}
		public void displayColor()
		{
			switch (toString())
			{
				case "RED":
					System.out.println("红色");
					break;
				case "ORANGE":
					System.out.println("橙色");
					break;
				case "YELLOW":
					System.out.println("黄色");
					break;
				case "GREEN":
					System.out.println("绿色");
					break;
				case "CYAN":
					System.out.println("青色");
					break;
				case "BLUE":
					System.out.println("蓝色");
					break;
				case "PURPLE":
					System.out.println("紫色");
			}
		}
	}
	public static void fix(Color[] member,int number)
	{
		for (int i = 0;i < number;i ++)
		{
			member[i] = Color.values()[(int)(Math.random() * number)];
			for (int j = 0;j < i;j ++)
				if (member[j] == member[i])
				{
					i --;
					break;
				}
		}
	}
	public static void bubble(Color[] member,int number)
	{
		boolean check;
		for (int i = 1;i < number;i ++)
		{
			check = true;
			for (int j = 0;j < number - i;j ++)
				if (member[j].compareTo(member[j + 1]) > 0)
				{
					check = false;
					Color t = member[j];
					member[j] = member[j + 1];
					member[j].displayRank();
					System.out.println(j + 1 + " -> " + j);
					member[j + 1] = t;
					member[j + 1].displayRank();
					System.out.println(j + " -> " + (j + 1));
				}
			if (check)
				break;
		}
	}
	public static void quick(Color[] member,int begin,int end)
	{
		if (begin >= end)
			return;
		int front = begin + 1,back = end;
		Color t;
		do
		{
			if (member[back].compareTo(member[begin]) < 0)
			{
				t = member[front];
				member[front] = member[back];
				member[front].displayRank();
				System.out.println(back + " -> " + front);
				member[back] = t;
				member[back].displayRank();
				System.out.println(front + " -> " + back);
				front ++;
			}
			else
				back --;
		} while (front <= back);
		t = member[back];
		member[back] = member[begin];
		member[begin] = t;
		quick(member,begin,back - 1);
		quick(member,front,end);
	}
	public static void main(String[] args)
	{
		final int NUMBER = 7;
		Color[] member = new Color[NUMBER];
		fix(member,NUMBER);
		System.out.println("To sort:");
		for (int i = 0;i < NUMBER;i ++)
			member[i].displayRank();
		System.out.println("Sorting:");
		bubble(member,NUMBER);
		System.out.println("Sorted:");
		for (int i = 0;i < NUMBER;i ++)
			member[i].displayRank();
		fix(member,NUMBER);
		System.out.println("To sort:");
		for (int i = 0;i < NUMBER;i ++)
			member[i].displayRank();
		System.out.println("Sorting:");
		quick(member,0,NUMBER -  1);
		System.out.println("Sorted:");
		for (int i = 0;i < NUMBER;i ++)
			member[i].displayRank();
	}
}
