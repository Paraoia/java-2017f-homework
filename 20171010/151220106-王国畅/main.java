
public class main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Field field = new Field();
		
		Huluwa[] brothers = new Huluwa[7];
		for(int i = 0; i < brothers.length;i++){
			brothers[i] = new Huluwa(COLOR.values()[i],RANK.values()[i]);
		}
		
		Laoyeye laoyeye = new Laoyeye();
		
		Creature[] monsters = new Creature[7];
		monsters[0] = new Xiezijing();
		for(int i = 1; i < monsters.length;i++){
			monsters[i] = new Louluo();
		}
		
		Shejing shejing = new Shejing();
		
		Group HuluFamily = new Group(brothers,laoyeye,field,0);
		Group MonsterFamily = new Group(monsters,shejing,field,1);
		
		field.printStatus();
		
		new FormationChangShe().setFormation(HuluFamily,field);
		new FormationYanXing().setFormation(MonsterFamily, field);
		
		field.printStatus();
		
		new FormationHengE().setFormation(HuluFamily, field);
		new FormationHeYi().setFormation(MonsterFamily, field);
		
		field.printStatus();
	}

}
