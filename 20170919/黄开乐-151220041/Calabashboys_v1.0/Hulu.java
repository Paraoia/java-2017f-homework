
public class Hulu {
	public final static int NULL =0;
	public final static int Red =1;
	public final static int Orange =2;
	public final static int Yellow =3;
	public final static int Green =4;
	public final static int Cyan =5;
	public final static int Blue =6;
	public final static int Purple=7;
private
	int color;
	int rank;
public
	Hulu(){
		color = NULL;
		rank = NULL;
	}
	
	Hulu(int col, int r){
		color = col;
		rank = r;
	}
	
	void Set(int col, int r) {
		color = col;
		rank = r;
	}
	
	int Report_col() {
		return color;
	}
	
	int Report_rank() {
		return rank;
	}
	
	String Report_rank_s() {
		String r = "ºùÂ«ÍŞ";
		switch(rank) {
			case 1:		r = "´óÍŞ";break;
			case 2:		r = "¶şÍŞ";break;
			case 3:		r = "ÈıÍŞ";break;
			case 4:		r = "ËÄÍŞ";break;
			case 5:		r = "ÎåÍŞ";break;
			case 6:		r = "ÁùÍŞ";break;
			case 7:		r = "ÆßÍŞ";break;
		}
		return r;
	}
	
	String Report_color_s() {
		String r = "ºùÂ«ÍŞ";
		switch(rank) {
			case 1:		r = "³à";break;
			case 2:		r = "³È";break;
			case 3:		r = "»Æ";break;
			case 4:		r = "ÂÌ";break;
			case 5:		r = "Çà";break;
			case 6:		r = "À¶";break;
			case 7:		r = "×Ï";break;
		}
		return r;
	}
}
