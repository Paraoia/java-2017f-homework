
public class Game {

    static public void main(String args[]){
        Obj grass = new Obj(new StrImage("  "));
        Space space = new Space(new Position(30, 20), grass);

        Huluwa huluwas[] =  {
                new Huluwa(SENIORITY.二, COLOR.橙, new StrImage("✇")),
                new Huluwa(SENIORITY.大, COLOR.红, new StrImage("✪")),
                new Huluwa(SENIORITY.五, COLOR.青, new StrImage("❀")),
                new Huluwa(SENIORITY.四, COLOR.绿, new StrImage("✦")),
                new Huluwa(SENIORITY.七, COLOR.紫, new StrImage("❦")),
                new Huluwa(SENIORITY.三, COLOR.黄, new StrImage("✧")),
                new Huluwa(SENIORITY.六, COLOR.蓝, new StrImage("❧")),
        };

        Camp c1 = new Camp(new Formation(FormRecords.长蛇阵), huluwas);
        c1.setLeftUp(new Position(10, 0));
        c1.setCampDirection(Direction.南);
        c1.layout(space);

        Creature scorpion = new Creature(new StrImage("☻"), 1);
        Camp c2 = new Camp(new Formation(FormRecords.锋矢阵));
        c2.addCreature(scorpion);
        for (int i = 0; i < 20; i++){
            c2.addCreature(new Creature(new StrImage("\uD83D\uDC38"), 2));
        }
        c2.setLeftUp(new Position(6, 9));
        c2.setCampDirection(Direction.北);
        c2.layout(space);

        Creature grandpa = new Creature(new Position(3, 2),new StrImage("♠"), 1);
        grandpa.layout(space);

        Creature snake = new Creature(new Position(3, 10), new StrImage("✌ "), 1);
        snake.layout(space);
        space.show2DStr();


        System.out.println("=================================================");
        c2.changeForm(new Formation(FormRecords.鱼鳞阵), space);
        c2.layout(space);
        space.show2DStr();

        System.out.println("=================================================");
        c2.changeForm(new Formation(FormRecords.鹤翼阵), space);
        c2.layout(space);
        space.show2DStr();

        System.out.println("=================================================");
        c2.changeForm(new Formation(FormRecords.偃月阵), space);
        c2.layout(space);
        space.show2DStr();

        System.out.println("=================================================");
        c2.changeForm(new Formation(FormRecords.方门阵), space);
        c2.layout(space);
        space.show2DStr();

        System.out.println("=================================================");
        c2.changeForm(new Formation(FormRecords.衡轭阵), space);
        c2.layout(space);
        space.show2DStr();

        System.out.println("=================================================");
        c2.changeForm(new Formation(FormRecords.雁行阵), space);
        c2.layout(space);
        space.show2DStr();
    }
}
