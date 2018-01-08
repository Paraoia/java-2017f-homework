
public class FormationChangShe implements Formation {

	@Override
	public void setFormation(Group group,Field field) {
		// TODO Auto-generated method stub
		int camp = group.getCamp();
		Creature[] creatures = group.getCreatures();
		FieldPos basepoint = field.getFieldPos(3, camp*7+3);
		for(int i = 0;i < creatures.length;i++){
			creatures[i].getFieldPos().setHolder(null);
		}
		
		boolean reverse = camp==0?false:true;
		
		int base_x = basepoint.getX();
		int base_y = basepoint.getY();
		for(int i = 0; i < creatures.length; i++){
			creatures[i].setFieldPos(field.getFieldPos(base_x + i, base_y));
		}
	}

}