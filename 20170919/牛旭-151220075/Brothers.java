import java.util.ArrayList;
import java.util.Random;

public class Brothers {
	private ArrayList<HuLuWa> list = new ArrayList<HuLuWa>();
	public Brothers() {
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
	public ArrayList<HuLuWa> getList() {
		return list;
	}
	public void showPaiHang() {
		for(HuLuWa a : list) {
			System.out.print(a.getPaihang()+" ");
		}
		System.out.println();
	}
	public void showColor() {
		for(HuLuWa a : list) {
			System.out.print(a.getColor()+" ");
		}
		System.out.println();
	}
}
