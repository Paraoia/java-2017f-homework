package com.gxs;

public class Story {
	
	public static void main(String[] args)
	{
		Creature[] cala=CalaBro.getAcess();
		Creature snake=Snake.getAcess(),
				scorpion=Scorpion.getAcess(),
				grandpa=Grandpa.getAcess();
		Creature[] Monsters=new Creature[30];
		Monsters[0]=scorpion;
		for(int i=1;i<30;i++)
			Monsters[i]=new Monster("菜鸟");
	
		Space map=Space.getMap();

		//葫芦娃与鹤翼形的敌人对峙
		map.embattle(cala,Dir.LEFT,new Position(20,10),Shape.Line);
		map.embattle(Monsters,Dir.UP,new Position(30,20), Shape.Wing);
		map.setCreature(snake,Dir.UP,new Position(27,20));
		map.setCreature(grandpa,Dir.UP, new Position(23,20));
		map.draw();
		map.wipe();
		
		//葫芦娃与弯月形的敌人对峙
		map.embattle(cala, Dir.UP,new Position(20,10),Shape.Line);
		map.embattle(Monsters, Dir.LEFT, new Position(20,40),Shape.Moon);
		map.setCreature(grandpa, Dir.RIGHT, new Position(35,10));
		map.setCreature(snake, Dir.LEFT, new Position(35,40));
		map.draw();
		map.wipe();
	}

}
