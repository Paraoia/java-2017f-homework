
public class Group {
	private Creature supportor;
	private Creature[] creatures;
	private int camp;
	
	public Group(Creature[] creatures,Creature supportor,Field field,int camp){
		java.util.Random r = new java.util.Random();
		this.supportor = supportor;
		this.creatures = creatures;
		this.camp = camp;
		this.supportor.setFieldPos(field.getFieldPos(7, this.camp*14));
		for(int i=0;i<creatures.length;i++){
			int x = r.nextInt(15);
			int y = r.nextInt(7) + this.camp*7;
			creatures[i].setFieldPos(field.getFieldPos(x, y));
		}
	}
	public int getCamp(){
		return camp;
	}
	
	public Creature getSupportor(){
		return this.supportor;
	}
	
	public Creature[] getCreatures(){
		return this.creatures;
	}
	
/*	public void transFormationChangShe(Field field){
		FieldPos basement = field.getFieldPos(3, this.camp*7+3);
		for(int i = 0;i < creatures.length;i++){
			creatures[i].getFieldPos().setHolder(null);
		}
		
		boolean reverse = this.camp==0?false:true;
		
		new FormationChangShe().setFormation(creatures,basement,field,reverse);
	}*/
	
/*	public void transFormationHengE(Field field){
		FieldPos basement = field.getFieldPos(3, this.camp*7+3);
		for(int i = 0;i < creatures.length;i++){
			creatures[i].getFieldPos().setHolder(null);
		}
		
		boolean reverse = this.camp==0?false:true;
		
		new FormationHengE().setFormation(creatures,basement,field,reverse);
	}*/
	
/*	public void transFormationHeYi(Field field){
		FieldPos basement = field.getFieldPos(7, this.camp*2 + 6);
		for(int i = 0;i < creatures.length;i++){
			creatures[i].getFieldPos().setHolder(null);
		}
		
		boolean reverse = this.camp==0?false:true;
		
		new FormationHeYi().setFormation(creatures,basement,field,reverse);
	}*/
	
/*	public void transFormationYanXing(Field field){
		FieldPos basement = field.getFieldPos(3, this.camp*14);
		for(int i = 0;i < creatures.length;i++){
			creatures[i].getFieldPos().setHolder(null);
		}
		
		boolean reverse = this.camp==0?false:true;
		
		new FormationYanXing().setFormation(creatures,basement,field,reverse);
	}*/
}
