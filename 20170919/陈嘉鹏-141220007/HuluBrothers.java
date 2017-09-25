import java.util.Random;

public class HuluBrothers {

	public static void main(String[] args) {

		HuluBrothers hulus = new HuluBrothers(7);
		hulus.shuttle();
		hulus.sortByRank();
		hulus.ReportRank();
		System.out.println("\n");
		hulus.shuttle();
		hulus.sortByColor();
		hulus.ReportColor();
		
	}
	
	HuluBrother[] brothers;
	public HuluBrothers(Integer num){
		brothers = new HuluBrother[num];
		for(int i = 0; i < num; i ++){
			brothers[i] = new HuluBrother(i+1, i+1);
		}
	}
	
	public void shuttle() {
		HuluBrother[] OoO = new HuluBrother[brothers.length];
		Integer Oidx = 0, ilimit = brothers.length;
		Random rand = new Random();
		do {
			Integer rposition = rand.nextInt(ilimit--);
			Integer r = brothers.length - Oidx;
			OoO[Oidx++] = brothers[rposition];
			brothers[rposition] = brothers[r-1];
			
		} while (Oidx < brothers.length);
		
		brothers = OoO;
	}
	public void ReportRank() {
		for(int i = 0; i < brothers.length; i ++){
			System.out.println(brothers[i].reportRank());
		}
	}
	public void ReportColor() {
		for(int i = 0; i < brothers.length; i ++){
			System.out.println(brothers[i].reportColor());
		}
	}
	public void sortByRank() {
		for(int i = 0; i < brothers.length; i ++){
			for(int j = 0; j < brothers.length - i - 1; j ++){
				if (! brothers[j].cmpRank(brothers[j + 1])) {
					exchange(j, j+1);
				}
			}
		}
	}
	
	public void sortByColor() {
		int low, mid, high;
		int left = 0, right = brothers.length - 1;
		HuluBrother tmp;
		for(int i = left+1; i <= right; i++){
			tmp = brothers[i];
			low = left;
			high = i - 1;
			while(low <= high){
				mid = (low + high)/2;
				if (!brothers[i].cmpColor(brothers[mid])) {
					low = mid + 1;
				}
				else {
					high = mid - 1;
				}
			}
			
			for (int j = i-1; j >= low; j--) {
				replace(j+1, j);
			}
			brothers[low] = tmp;
			System.out.println(brothers[i].reportRank() + ": " + i + "->" + low);
		}
	}
	public void replace(int j, int i) {
		System.out.println(brothers[i].reportRank() + ": " + i + "->" + j);
		brothers[j] = brothers[i];
	}
	public void exchange(int i, int j) {
		HuluBrother tmp;
		System.out.println(brothers[i].reportRank() + ": " + i + "->" + j);
		tmp = brothers[i];
		brothers[i] = brothers[j];
		brothers[j] = tmp;
	}
	
}


class HuluBrother{
	BrotherRank rank;
	BrotherColor color;
	public HuluBrother(Integer r, Integer c) {
		this.rank = new BrotherRank(r);
		this.color = new BrotherColor(c);
	}
	public Integer getRank() {
		return rank.rank;
	}
	public BrotherColor getColor(){
		return color;
	}
	public boolean cmpRank(HuluBrother one) {
		return this.rank.greater(one.rank);
	}
	public boolean cmpColor(HuluBrother one) {
		return this.color.greater(one.color);
	}
	
	public String reportRank() {
		return rank.toStr();
	}
	public String reportColor() {
		return color.toStr();
	}
}






class BrotherRank{
	final Integer R_FIRST = 1;
	final Integer R_SECOND = 2;
	final Integer R_THIRD = 3;
	final Integer R_FOURTH = 4;
	final Integer R_FIFTH = 5;
	final Integer R_SIXTH = 6;
	final Integer R_SEVENTH = 7;
	final String str[] = {
			"老大",
			"老二",
			"老三",
			"老四",
			"老五",
			"老六",
			"老七"
	};
	Integer rank;
	public BrotherRank(Integer r) {
		this.rank = r;
	}
	public boolean greater(BrotherRank src) {
		return this.rank < src.rank;
	}
	public boolean less(BrotherRank src) {
		return this.rank > src.rank;
	}
	public Integer rank(BrotherRank r) {
		return r.rank;
	}
	
	public String toStr() {
		return str[rank-1];
	}
}




class BrotherColor{
	final Integer C_RED = 1;
	final Integer C_ORANGE = 2;
	final Integer C_YELLOW = 3;
	final Integer C_GREEN = 4;
	final Integer C_CYAN = 5;
	final Integer C_BLUE = 6;
	final Integer C_PURPLE = 7;
	final String str[] = {
			"红色",
			"橙色",
			"黄色",
			"绿色",
			"青色",
			"蓝色",
			"紫色"
	};
	
	Integer color;
	
	public BrotherColor(Integer c) {
		this.color = c;
	}
	
	public boolean greater(BrotherColor src) {
		return this.color < src.color;
	}
	public boolean less(BrotherColor src) {
		return this.color > src.color;
	}
	public Integer rank(BrotherColor c) {
		return c.color;
	}
	
	public String toStr() {
		return str[color-1];
	}
}
