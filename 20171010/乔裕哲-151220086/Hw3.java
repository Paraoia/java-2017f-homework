
public class Hw3 {
    public static void main(String []args){
        Creature []brothers = new HuluWa[7];
        for(int i = 0; i < 7; ++i)
            brothers[i] = new HuluWa(Color.values()[i], Name.values()[i]);
        Creature []badAss = new Creature[7];
        badAss[0] = new Xiezi();
        for(int i = 1; i < 7; ++i)
            badAss[i] = new Louluo();

        Creature yeye = new Yeye();
        Creature shejing = new Shejing();

        Contianer contianer = new Contianer(brothers, badAss);
        Formation formation = new Formation();

        System.out.println("葫芦娃长蛇VS反派冲轭！！");
        formation.changeFormation(contianer.getPositiveChars(), Format.长蛇, new Position(3, 6), Direction.up);
        formation.changeFormation(contianer.getNegativeChars(), Format.冲轭, new Position(10, 6), Direction.up);
        Arena arena = new Arena();
        arena.enter(contianer.getPositiveChars());
        arena.enter(contianer.getNegativeChars());
        arena.rollCall();

        System.out.println("\n\n爷爷和蛇精乱入！！（爷爷还是站在后面吧。。）");
        arena.addCreature(yeye, new Position(2,9));
        arena.addCreature(shejing, new Position(8,9));
        arena.rollCall();

        System.out.println("\n\n重新布阵！！葫芦娃长蛇VS反派鹤翼！！");
        arena.clear();
        formation.changeFormation(contianer.getPositiveChars(), Format.长蛇, new Position(11, 9), Direction.right);
        formation.changeFormation(contianer.getNegativeChars(), Format.鹤翼, new Position(3, 9), Direction.right);
        arena.enter(contianer.getPositiveChars());
        arena.enter(contianer.getNegativeChars());
        arena.rollCall();

        System.out.println("\n\n爷爷和蛇精乱入！！");
        arena.addCreature(yeye, new Position(11,8));
        arena.addCreature(shejing, new Position(4,9));
        arena.rollCall();
    }
}



