
public class Laoyeye implements Creature {
	private FieldPos fieldpos;
	private String name;
	public Laoyeye(){
		this.fieldpos = null;
		this.name = "ү";
	}
	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return this.name;
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

}