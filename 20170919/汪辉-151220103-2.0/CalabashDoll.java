public class CalabashDoll {
	public enum Color{Red,Orange,Yellow,Green,Blue,Indigo,Violet}
	public enum Rank{BigBrother,SecBrother,ThirdBrother,ForthBrother,FifthBrother,SixBrother,SevenBrother}
	private Color colour;
	private Rank rank;
	private int position; 
	CalabashDoll(int i)
	{
		switch(i) {
		case 0:colour=Color.Red;rank=Rank.BigBrother;break;
		case 1:colour=Color.Orange;rank=Rank.SecBrother;break;
		case 2:colour=Color.Yellow;rank=Rank.ThirdBrother;break;
		case 3:colour=Color.Green;rank=Rank.ForthBrother;break;
		case 4:colour=Color.Blue;rank=Rank.FifthBrother;break;
		case 5:colour=Color.Indigo;rank=Rank.SixBrother;break;
		case 6:colour=Color.Violet;rank=Rank.SevenBrother;break;
		}
	}
	
	CalabashDoll() {
		colour=null;
		rank=null;
		position=-1;
	}

	public void printBrother(){
		System.out.print(colour.toString()+"  ");
	    System.out.print(rank.toString());
	}
	
	public String getName() {
		return rank.toString();
	}
	
	public void setPosition(int i) {
		position=i;
	}
	
	public int colorCompare(CalabashDoll b) {
		return colour.compareTo(b.colour);
	}
	
	public int RankCompare(CalabashDoll B) {
		return rank.compareTo(B.rank);
	}
	
	public int getposition() {
		return position;
	}
	public String getColor() {
		return colour.toString();
	}
	public void ChangeBoy(CalabashDoll B) {
		System.out.print(this.rank.toString()+": "+this.colour.toString()+": from "+this.position+" to "+B.position+" ;  ");
		System.out.print(B.rank.toString()+": "+B.colour.toString()+": from "+B.position+" to "+this.position+" ;  ");
		CalabashDoll temp=new CalabashDoll();
		temp.colour=this.colour;
		temp.rank=this.rank;
		temp.position=this.position;
		this.colour=B.colour;
		this.rank=B.rank;
		this.position=B.position;
		B.colour=temp.colour;
		B.rank=temp.rank;
		B.position=temp.position;
	}
}
