import java.util.Random;

enum ZhenfaType {Heyi, Yanxing, Chonge, Changshe, Yulin, Fangyuan, Yanyue, Fengshi}

public class Zhenfa {
    private ZhenfaType type;  //阵法类型

    public ZhenfaType getType() {
        return type;
    }

    public void setType(ZhenfaType type) {
        this.type = type;
    }

    private Position[] positions;
    private Creature[] creatures;

    public Position[] getPositions() {
        return positions;
    }

    public Creature[] getCreatures() {
        return creatures;
    }

    public Zhenfa(Creature[] creatures, ZhenfaType type) {
        this.type = type;
        this.positions = new Position[creatures.length]; //阵法此时还没有具体成型，只有一组生物
        this.creatures = creatures;   //阵法有了creature
    }

    public void form(Space space, int startX, int startY) {     //阵法在space成型
        int n = space.getN();
        switch (type) {
            case Yanxing:
                //Random rand = new Random();
                //int t = rand.nextInt(n - creatures.length - 1);
                for (int i = 0; i < creatures.length; i++) {
                    //int范围类的随机数 space 一分为2
                    positions[i] = new Position(startX- i  , startY+i );
                    creatures[i].setPosition(positions[i]);
                }
                break;
            case Heyi:
                if (creatures[0].getType() == CreatureType.Xiezijing) {
                    positions[0] = new Position(startX, startY); //先排蝎子精
                    creatures[0].setPosition(positions[0]);
                    int sig = -1;
                  for (int i = 1; i < creatures.length; i++) {
                        positions[i] = new Position(startX - (i+1)/ 2 , startY + sig * (i +1)/2);
                        creatures[i].setPosition(positions[i]);
                        sig*=-1;
                    }
                } else if (creatures[0].getType() == CreatureType.Huluwa) {
                    //葫芦娃 鹤翼
                }
                break;
            case Changshe:
                for (int i = 0; i < creatures.length; i++) {
                    positions[i] = new Position(startX + i, startY);
                    creatures[i].setPosition(this.positions[i]);
                }
                //还有一些阵法未完成
            case Chonge://other Formations
        }
    }

}
