
public class Main {
	public static void main(String args[]){
		/*创建7个葫芦娃*/
		Creature [] Hulubros = new Huluwas[7];
		for (int i = 0; i < Hulubros.length; i++)
			Hulubros[i] = new Huluwas(Rank.values()[i],Color.values()[i]);
		
		/*创建一群小喽啰，为首的为蝎子精*/
		Creature []monsters = new Creature[7];
		monsters[0] = new Scorpion();
		for(int i = 1; i < monsters.length; i++)
			monsters[i] = new Goblin();
		
		/*创建爷爷和蛇精*/
		Creature grandpa = new Grandpa();
		Creature snake = new Snake();
		
		/*排阵*/
		Formation formation = new Formation();
		formation.Random_Queue_for_Huluwas(Hulubros);//葫芦娃以长蛇型任意站队
		formation.Goose_Queue(monsters);  //小喽啰，雁型排阵
		formation.Cheering(grandpa);  //加油助威的爷爷
		formation.Cheering(snake);  //加油助威的蛇精
		
		/*将各个生物排好的阵型放入地图中*/
		Map map = new Map();
		map.putCreatures(Hulubros, 5, 3);
		Sorter bq = new BubbleSort();
		bq.sort(map, Hulubros, 5, 3);  //此处葫芦娃要先排序
		map.putCreatures(monsters, 5, 5);
		map.putCreature(grandpa, 8, 2);
		map.putCreature(snake, 6, 8);
		map.show();  //打印地图
		map.outCreatures(monsters, 5, 5);  //小喽啰从地图中出去
		
		/*此处小喽啰重新排阵打印*/
		formation.Crane_Queue(monsters); //小喽啰，鹤翼排阵
		map.putCreatures(monsters, 7, 5);
		map.show();
		map.outCreatures(monsters, 7, 5);
		
		/*此处小喽啰重新排阵打印*/
		formation.ChongE_Queue(monsters);  //小喽啰，冲轭排阵
		map.putCreatures(monsters, 5, 6);
		map.show();
		map.ClearMap();
		
		return;
	}
}
