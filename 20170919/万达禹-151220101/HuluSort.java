package HuluSort;
import java.util.*;
import java.util.ArrayList;

class HuluBoy{
	private int rank;
	private String name;
	private String color;
	private int colorweight;
	
	public HuluBoy(int r, String n, String c, int cw) {
		this.rank = r;
		this.name = n;
		this.color = c;
		this.colorweight = cw;
	}
	
	public int get_rank() {
		return this.rank;
	}
	
	public int get_colorweight() {
		return this.colorweight;
	}
	
	public String report_Boy(String ch) {
		if(ch == "name")
			return this.name;
		else if(ch == "color")
			return this.color;
		else return "false";
	}
}

public class HuluSort {
	private HuluBoy Hulubrothers[];
	
	public HuluSort() {
		Hulubrothers = new HuluBoy[7];
		Hulubrothers[0] = new HuluBoy(1,"大娃","赤",1);
		Hulubrothers[1] = new HuluBoy(2,"二娃","橙",2);
		Hulubrothers[2] = new HuluBoy(3,"三娃","黄",3);
		Hulubrothers[3] = new HuluBoy(4,"四娃","绿",4);
		Hulubrothers[4] = new HuluBoy(5,"五娃","青",5);
		Hulubrothers[5] = new HuluBoy(6,"六娃","蓝",6);
		Hulubrothers[6] = new HuluBoy(7,"七娃","紫",7);
	}
	
	public void report_AllBoy(String ch) {
		if(ch == "name")
			System.out.print("葫芦娃们报名:");
		else if(ch == "color")
			System.out.print("葫芦娃们报颜色:");
		for(HuluBoy boy : Hulubrothers)
			System.out.print(boy.report_Boy(ch)+"！ ");
		System.out.print("\n\n");
	}
	
	public HuluBoy[] random_the_Boy() {
		HuluBoy random_BoyArr[] = new HuluBoy[Hulubrothers.length];
		List templist = new ArrayList <HuluBoy>();
		for(int i=0;i<Hulubrothers.length;i++)
			templist.add(Hulubrothers[i]);
		Collections.shuffle(templist);
		templist.toArray(random_BoyArr);
		return random_BoyArr;
	}
	
	public void getrandom(HuluBoy r[]){
		System.out.println("葫芦娃们随机站！");
		Hulubrothers = r;
	}
	
	public void BubbleSort_AllBoy(){
		System.out.println("葫芦娃们按名次冒泡排序！");
		System.out.println("葫芦娃们排序中。。。");
		for(int i=0;i<Hulubrothers.length-1;i++)
			for(int j=0;j<Hulubrothers.length-i-1;j++) {
				if(Hulubrothers[j].get_rank()>Hulubrothers[j+1].get_rank()){
					System.out.println(Hulubrothers[j].report_Boy("name")+": "+j+" -> "+(j+1));
					System.out.println(Hulubrothers[j+1].report_Boy("name")+": "+(j+1)+" -> "+j);
					HuluBoy temp = Hulubrothers[j];
					Hulubrothers[j] = Hulubrothers[j+1];
					Hulubrothers[j+1] = temp;
				}
			}
		System.out.println("排序完了！");
	}
	
	public void DichotomySort_AllBoy() {
		System.out.println("葫芦娃们按颜色二分法排序！");
		System.out.println("葫芦娃们排序中。。。");
		for(int i=1;i<Hulubrothers.length;i++) {
			int startpos = 0;
			int endpos = i-1;
			int middlepos = 0;
			HuluBoy temp = Hulubrothers[i];
			while(startpos <= endpos) {
				middlepos = (startpos + endpos)/2;
				if(Hulubrothers[middlepos].get_colorweight() > temp.get_colorweight())
					endpos = middlepos - 1;
				else startpos = middlepos + 1;
			}
			for(int j = i-1;j > endpos;j--) {
				System.out.println(Hulubrothers[j].report_Boy("name")+": "+j+" -> "+(j+1));
				Hulubrothers[j+1] = Hulubrothers[j];
			}
			System.out.println(temp.report_Boy("name")+": "+i+" -> "+(endpos+1));
			Hulubrothers[endpos+1] = temp;
		}
		System.out.println("排序完了！");
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
			HuluSort mysort = new HuluSort();
			mysort.getrandom(mysort.random_the_Boy());
			mysort.report_AllBoy("name");
			mysort.BubbleSort_AllBoy();
			mysort.report_AllBoy("name");
			mysort.getrandom(mysort.random_the_Boy());
			mysort.report_AllBoy("color");
			mysort.DichotomySort_AllBoy();
			mysort.report_AllBoy("color");
	}

}
