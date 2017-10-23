package HuluTeam;

import java.util.ArrayList;
import java.util.Collections;

public class HuluBrothers implements Creatures{
	
	protected ArrayList<HuluBoy> hulubrothers;
	
	public HuluBrothers() {
		hulubrothers = new ArrayList<HuluBoy>();
	}
	
	@Override
	public void add(String n) {
		HuluBoy a = new HuluBoy(n);
		hulubrothers.add(a);
	}
	
	@Override
	public void show() {
		for(int i=0;i<hulubrothers.size();i++)
			hulubrothers.get(i).report();
		System.out.print("\n");
	}
	
	@Override
	public Creature getCreature(int n) {
		return hulubrothers.get(n);
	}
	
	@Override
	public int getnumber() {
		return hulubrothers.size();
	}
	
	public ArrayList<HuluBoy> random_the_Boy() {			
		ArrayList<HuluBoy> templist = new ArrayList <HuluBoy>();
		for(int i=0;i<hulubrothers.size();i++)
			templist.add(hulubrothers.get(i));
		Collections.shuffle(templist);
		return templist;
	}
	
	public void getrandom(ArrayList<HuluBoy> r){			
		System.out.println("葫芦娃们随机站！");
		hulubrothers = r;
	}
	
//	public void Sort_Progress_Output(int index, int position1, int position2) {	
//		System.out.println(hulubrothers.get(index).toString()+": "+ position1 +" -> "+ position2);
//	}
	
	public void exchange(int position1, int position2) {		
		HuluBoy temp = hulubrothers.get(position1);
		hulubrothers.set(position1, hulubrothers.get(position2));
		hulubrothers.set(position2, temp);
	}
	
	public void BubbleSort_AllBoy(){						
		System.out.println("葫芦娃们按名次冒泡排序！");
		System.out.println("葫芦娃们排序中。。。");
		for(int i=0;i<hulubrothers.size()-1;i++)
			for(int j=0;j<hulubrothers.size()-i-1;j++) {
				if(hulubrothers.get(j).get_rank()>hulubrothers.get(j+1).get_rank()){
//					Sort_Progress_Output(j, j, j + 1);
//					Sort_Progress_Output(j+1, j+1, j);
					exchange(j, j + 1);
				}
			}
		System.out.println("排序完了！");
	}
	
}
