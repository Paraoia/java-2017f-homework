package HuLu;
enum COLOR {
    赤, 橙, 黄, 绿, 青, 蓝, 紫
}

enum SENIORITY {
    一, 二, 三, 四, 五, 六, 七
}
public class Huluwa extends Creature implements Comparable{
	private COLOR color;
    private SENIORITY seniority;
    //private Position position;
    //private String name;
	Huluwa(COLOR color, SENIORITY seiority) {
		super("老"+seiority.toString());
        this.color = color;
        this.seniority = seiority;
       // this.name="老"+seiority.toString();
    }
	
	public COLOR getColor() {
        return color;
    }

    public SENIORITY getSeniority() {
        return seniority;
    }
    
//	public String getName(){
//		return name;
//	}
//	
//	@Override
//    public Position getPosition() {
//        return position;
//    }
//
//    @Override
//    public void setPosition(Position position) {
//        this.position = position;
//        position.setHolder(this);
//    }

    @Override
    public void report() {
        System.out.print(this.seniority.toString() + "(" + this.color.toString() + ")");
    }
    
    @Override
    public boolean isBiggerThan(Comparable another){

        if (another instanceof  Huluwa)
            return this.getSeniority().ordinal()> ((Huluwa) another).getSeniority().ordinal();
        else
            return false;
    }
}
