public class CalabashDoll {
	public enum Color{Red,Orange,Yellow,Green,Blue,Indigo,Violet}
	public enum Rank{BigBrother,SecBrother,ThirdBrother,ForthBrother,FifthBrother,SixBrother,SevenBrother}
	private Color colour;
	private Rank rank;
	private String name; 
	CalabashDoll(int i)
	{
		switch(i) {
		case 0:colour=Color.Red;rank=Rank.BigBrother;name="大娃";break;
		case 1:colour=Color.Orange;rank=Rank.SecBrother;name="二娃";break;
		case 2:colour=Color.Yellow;rank=Rank.ThirdBrother;name="三娃";break;
		case 3:colour=Color.Green;rank=Rank.ForthBrother;name="四娃";break;
		case 4:colour=Color.Blue;rank=Rank.FifthBrother;name="五娃";break;
		case 5:colour=Color.Indigo;rank=Rank.SixBrother;name="六娃";break;
		case 6:colour=Color.Violet;rank=Rank.SevenBrother;name="七娃";break;
		}
	}
	
	public void printBrother(){
		System.out.print(colour.toString()+"  ");
	    System.out.print(rank.toString());
	}
	
	public int colorCompare(CalabashDoll b) {
		return colour.compareTo(b.colour);
	}
	
	public int RankCompare(CalabashDoll B) {
		return rank.compareTo(B.rank);
	}
	
	public String getname() {
		return name;
	}
	public String getColor() {
		return colour.toString();
	}
}
