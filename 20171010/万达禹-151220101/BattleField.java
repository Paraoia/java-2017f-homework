package HuluTeam;

import java.util.Random;

public class BattleField {
	
	private Position[] field;
	private int rownum;
	private Enemies a;
	private HuluBrothers b;
	
	public BattleField(int row) {
		field = new Position[row*row];
		int index=0;
		for(int j=0;j<row;j++)
			for(int k=0;k<row;k++) {
				field[index] = new Position(j,k);
				index++;
			}
		rownum = row;
	}
	
	public void addEnemies(Enemies a) {
		this.a = a;
	}
	
	public void addHuluBrothers(HuluBrothers b) {
		this.b = b;
	}
	
	public void addGrandfather() {
		Creature g = new Creature("Ò¯");
		this.setHolder(g,b.getCreature(b.getnumber()-1).getPosition().GetPositionX()-2 , 0);
	}
	
	public void addSnake() {
		Creature sn = new Creature("Éß");
		this.setHolder(sn,a.getCreature(a.getnumber()-1).getPosition().GetPositionX()-2, rownum-1);
	}
	
	public void random_and_sort() {
		b.getrandom(b.random_the_Boy());
		b.show();
		b.BubbleSort_AllBoy();
		b.show();
	}
	
	public void huluformation(int x,int y) {
		for(int i=0;i<b.getnumber();i++){
			this.setHolder(b.getCreature(i), x, y-i);
		}
	}
	
	public void Choose_A_Formation_For_Enemies(int x, int y) {
		this.CleanTheField();
		this.random_and_sort();
		this.huluformation(rownum/2, 6);
		Random r = new Random();
		int choice = r.nextInt(8);
		switch(choice) {
		case 0:
			a.adjusttonum(7);
			Snake_Formation s = new Snake_Formation();
			s.SetFormation(this, a.enemies, x, y);
			break;
		case 1:
			a.adjusttonum(7);
			Crane_Wing_Formation c = new Crane_Wing_Formation();
			c.SetFormation(this, a.enemies, x, y);
			break;
		case 2:
			a.adjusttonum(5);
			Flying_Geese_Formation f = new Flying_Geese_Formation();
			f.SetFormation(this, a.enemies, x, y);
			break;
		case 3:
			a.adjusttonum(6);
			Yoke_Formation yo = new Yoke_Formation();
			yo.SetFormation(this, a.enemies, x, y);
			break;
		case 4:
			a.adjusttonum(10);
			Scale_Formation sc = new Scale_Formation();
			sc.SetFormation(this, a.enemies, x, y);
			break;
		case 5:
			a.adjusttonum(8);
			Square_Formation d = new Square_Formation();
			d.SetFormation(this, a.enemies, x, y);
			break;
		case 6:
			a.adjusttonum(19);
			Moon_Formation m = new Moon_Formation();
			m.SetFormation(this, a.enemies, x, y);
			break;
		case 7:
			a.adjusttonum(12);
			Arrow_Formation ar = new Arrow_Formation();
			ar.SetFormation(this, a.enemies, x, y);
			break;
			}	
		this.addGrandfather();
		this.addSnake();
		this.ShowTheField();
    }
	
	public void setHolder(Creature a, int x, int y) {
		for(int i=0;i<rownum*rownum;i++)
		{
			if(field[i].GetPositionX()==x && field[i].GetPositionY()==y){
				field[i].SetHolder(a);
				a.setPosition(x, y);
			}
		}
	}
	
	public void CleanTheField() {
		for(int i=0;i<rownum*rownum;i++) {
			field[i].DeleteHolder();
		}
	}
	
	public void ShowTheField()
	{
		for(int i=0;i<rownum*rownum;i++) {
			field[i].report();
			if((i + 1)%rownum == 0)
				System.out.print("\n");
		}
		System.out.print("\n\n");
	}

}
