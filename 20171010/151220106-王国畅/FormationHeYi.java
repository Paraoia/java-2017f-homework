
public class FormationHeYi implements Formation {

	@Override
	public void setFormation(Group group,Field field) {
		// TODO Auto-generated method stub
		int camp = group.getCamp();
		Creature[] creatures = group.getCreatures();
		FieldPos basepoint = field.getFieldPos(7, camp*2 + 6);
		for(int i = 0;i < creatures.length;i++){
			creatures[i].getFieldPos().setHolder(null);
		}
		
		boolean reverse = camp==0?false:true;
		int base_x = basepoint.getX();
		int base_y = basepoint.getY();
		int increase_x = 0,increase_y = 0,r = reverse==true?-1:1;
		for(int i = 0; i < creatures.length; i++){
			increase_x = increase_x + (-1+(i%2)*2)*i;
			increase_y = increase_y - (i%2)*r;
			creatures[i].setFieldPos(field.getFieldPos(base_x + increase_x, base_y + increase_y));
		}
	}

}
