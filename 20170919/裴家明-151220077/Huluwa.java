package javaH2;

public class Huluwa {

	private String name;
	private String color;
	private int ID;
	public Huluwa() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Huluwa(String name, String color) {
		super();
		this.name = name;
		this.color = color;
		switch (color)
		{
		case "赤":
			ID=0;
			break;
		case "橙":
			ID=1;
			break;
		case "黄":
			ID=2;
			break;
		case "绿":
			ID=3;
			break;
		case "青":
			ID=4;
			break;
		case "蓝":
			ID=5;
			break;
		case "紫":
			ID=6;
			break;
		default:
			System.out.println("建议百度搜索“葫芦娃有哪几种颜色”");
			ID=7;
			break;
			
		}
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getcolor() {
		return color;
	}

	public void setcolor(String color) {
		this.color = color;
	}
	
	public int getID()
	{
		return ID;
	}
	
	public void setID(int ID)
	{
		this.ID=ID;
	}
	
	public int solo(Huluwa A)
	{
		if(A.getID()==this.ID) return 0;
		else if(this.ID>A.getID()) return 1;
		else return -1;
		
	}
	public void report(int i,int j)
	{
		System.out.println(this.name+":"+(i+1)+"->"+(j+1));
	}
	public void go(Huluwa[] list,int i)
	{
		list[i]=this;
	}
	public void swap(Huluwa A,Huluwa[] list)
	{
		int i=0;
		int j=0;
		for (int j2 = 0; j2 < list.length-1; j2++) {
			if(this.solo(list[j2])==0) i=j2;
			else if(A.solo(list[j2])==0) j=j2;
			else;
		}
		this.go(list,7);
		report(i,7);
		A.go(list,i);
		A.report(j, i);
		list[7].go(list, j);
		list[7].report(7, j);
		
	}
	
}
