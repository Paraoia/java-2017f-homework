package HuLu;

public class Louluo extends Creature {
	static int no=1;
	public Louluo(){
		super("à¶†ª"+String.valueOf(no));
		no++;
	}
	@Override
	public void report() {
		// TODO Auto-generated method stub
		System.out.print(this.getName());

	}

}
