package HuluTeam;

import java.util.Scanner;

public class Observer {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BattleField f = new BattleField(18);
		HuluBrothers a = new HuluBrothers();
		a.add("大");
		a.add("二");
		a.add("三");
		a.add("四");
		a.add("五");
		a.add("六");
		a.add("七");
		Enemies b = new Enemies();
		b.add("蝎");
		f.addHuluBrothers(a);
		f.addEnemies(b);
		Scanner in = new Scanner(System.in);
		String ch;
		do{
			f.Choose_A_Formation_For_Enemies(9, 11);
			ch = in.next();
		}while(!ch.equals("exit"));
		in.close();
	}

}
