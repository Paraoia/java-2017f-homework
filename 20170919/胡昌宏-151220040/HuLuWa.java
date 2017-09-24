
public class HuLuWa {
	 int rank;
     String name;
     String color;
    
    HuLuWa(int r, String n, String c){
        rank = r;
        name = n;
        color = c;
    }
    
    public void OutInfo(){
        System.out.println(rank + " ," + name + " ," + color);
    }
     
    public void out_name(){
        System.out.print(name + "  ");
    }
    
    public void out_color() {
    	System.out.print(color + "  ");
    }
}
