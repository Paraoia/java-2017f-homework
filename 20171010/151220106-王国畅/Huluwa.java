
public class Huluwa implements Creature {
	private COLOR color;
	private RANK rank;
	private FieldPos fieldpos;
	
	public COLOR getColor(){
		return this.color;
	}
	
	public RANK getRank(){
		return this.rank;
	}
	
	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return this.rank.toString();
	}

	@Override
	public void setFieldPos(FieldPos fieldpos) {
		// TODO Auto-generated method stub
		this.fieldpos = fieldpos;
		fieldpos.setHolder(this);
	}

	@Override
	public FieldPos getFieldPos() {
		// TODO Auto-generated method stub
		return this.fieldpos;
	}

	public Huluwa(COLOR color, RANK rank){
		this.color = color;
		this.rank = rank;
		this.fieldpos = null;
	}
}

enum COLOR {

    赤, 橙, 黄, 绿, 青, 蓝, 紫

}

enum RANK {

    一, 二, 三, 四, 五, 六, 七

}