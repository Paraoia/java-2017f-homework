import java.util.ArrayList;
import java.util.Random;

public class ErFenFa {
	private ArrayList<HuLuWa> list = new ArrayList<HuLuWa>();
	public ErFenFa() {
		ArrayList<HuLuWa> temp = new ArrayList<HuLuWa>();
		for(int i=1; i<=7; i++) {
			HuLuWa huLu = new HuLuWa(i);
			temp.add(huLu);
		}
		while(!temp.isEmpty()) {
			int point = new Random().nextInt(temp.size());
			list.add(temp.get(point));
			temp.remove(point);
		}
	}
	public void sort() {
		for(int i=1 ; i<list.size() ; i++) {
			int left=0, right=i-1;
			HuLuWa num=list.get(i);
			while(left<=right) {
				int middle=(left+right)/2;
				if(num.getNumber()<list.get(middle).getNumber()) 
					right=middle-1;
				else
					left=middle+1;
			}
			for(int j=i-1; j>=left; j--) {
				System.out.println(list.get(j).getPaihang()+":"+j+"->"+(j+1));
				list.set(j+1, list.get(j));
			}
			System.out.println(num.getPaihang()+":"+i+"->"+left);
			list.set(left, num);
		}
	}
	public void show() {
		for(HuLuWa a : list) {
			System.out.print(a.getPaihang()+" ");
		}
		System.out.println();
	}
}