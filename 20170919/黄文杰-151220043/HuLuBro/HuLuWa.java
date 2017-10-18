package HuLuBro;
enum Color{RED,ORANGE,YELLOW,GREEN,CHING,BLUE,PURPLE}
public class HuLuWa {
		Color color;
		String name;
		int rank;

		public HuLuWa(String name,Color color,int rank){
			this.color=color;
			this.name=name;
			this.rank=rank;
		}
		public String getName(){
			return name;
		}
		public int getRank(){
			return rank;
		}
		public Color getColor(){
			return color;
		}
		public void shout(int i,int j){
			System.out.println(name+":"+String.valueOf(i)+"->"+String.valueOf(j));
		}
}
