package MyHuluSort;

import java.util.ArrayList;
import java.util.Collections;

public class HuluSort {
	private ArrayList<HuluBoy> Hulubrothers;
	
	public HuluSort() {
		 Hulubrothers = new ArrayList<HuluBoy>();
	}
	
	public void add(int r, String n, String c, int cw) {		//add an HuluBoy
		HuluBoy newboy = new HuluBoy(r, n, c, cw);
		Hulubrothers.add(newboy);
	}
	
	public void report_AllBoy(String ch) {						//Show all names or colors of HuluBoys
		if(ch == "name")
			System.out.print("葫芦娃们报名:");
		else if(ch == "color")
			System.out.print("葫芦娃们报颜色:");
		for(int i=0;i<Hulubrothers.size();i++)
			System.out.print(Hulubrothers.get(i).report_Boy(ch)+"！ ");
		System.out.print("\n\n");
	}
	
	public ArrayList<HuluBoy> random_the_Boy() {				//get an random HuluBoys list
		ArrayList<HuluBoy> templist = new ArrayList <HuluBoy>();
		for(int i=0;i<Hulubrothers.size();i++)
			templist.add(Hulubrothers.get(i));
		Collections.shuffle(templist);
		return templist;
	}
	
	public void getrandom(ArrayList<HuluBoy> r){				//get an random HuluBoys list
		System.out.println("葫芦娃们随机站！");
		Hulubrothers = r;
	}
	
	public void Sort_Progress_Output(int index, int position1, int position2) {		//Output one step in the sort
		System.out.println(Hulubrothers.get(index).report_Boy("name")+": "+ position1 +" -> "+ position2);
	}
	
	public void exchange(int position1, int position2) {		//exchange two HuluBoys
		HuluBoy temp = Hulubrothers.get(position1);
		Hulubrothers.set(position1, Hulubrothers.get(position2));
		Hulubrothers.set(position2, temp);
	}
	
	public void BubbleSort_AllBoy(){							//Bubble Sort the HuluBoys
		System.out.println("葫芦娃们按名次冒泡排序！");
		System.out.println("葫芦娃们排序中。。。");
		for(int i=0;i<Hulubrothers.size()-1;i++)
			for(int j=0;j<Hulubrothers.size()-i-1;j++) {
				if(Hulubrothers.get(j).get_rank()>Hulubrothers.get(j+1).get_rank()){
					Sort_Progress_Output(j, j, j + 1);
					Sort_Progress_Output(j+1, j+1, j);
					exchange(j, j + 1);
				}
			}
		System.out.println("排序完了！");
	}
	
	public void DichotomySort_AllBoy() {						//Dichotomy Sort the HuluBoys
		System.out.println("葫芦娃们按颜色二分法排序！");
		System.out.println("葫芦娃们排序中。。。");
		for(int i=1;i<Hulubrothers.size();i++) {
			int startpos = 0;
			int endpos = i-1;
			int middlepos = 0;
			HuluBoy temp = Hulubrothers.get(i);
			while(startpos <= endpos) {
				middlepos = (startpos + endpos)/2;
				if(Hulubrothers.get(middlepos).get_colorweight() > temp.get_colorweight())
					endpos = middlepos - 1;
				else startpos = middlepos + 1;
			}
			if(i != (endpos+1))
				Sort_Progress_Output(i, i, endpos + 1);
			for(int j = i-1;j > endpos;j--) {
				Sort_Progress_Output(j, j, j+1);
				Hulubrothers.set(j+1, Hulubrothers.get(j));
			}
			Hulubrothers.set(endpos + 1, temp);
		}
		System.out.println("排序完了！");
	}
}
