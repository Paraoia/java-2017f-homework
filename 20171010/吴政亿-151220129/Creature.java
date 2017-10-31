enum CreatureType {
    Null, Calabash, Grandpa, Snake, Scorpion, Minion
}

//  定义生物类型
//  0:无生物
//  1:葫芦娃
//  2:老爷爷
//  3:蛇精
//  4:蝎子精
//  5:小喽啰
public class Creature {
    protected CreatureType type;

    protected String name;

    public Creature() {
        type = CreatureType.Null;
        name = new String();
    }

    public void Echo() {
        if (type == CreatureType.Null) {
            System.out.print("\t");
        } else if (type == CreatureType.Calabash || type == CreatureType.Grandpa || type == CreatureType.Snake) {
            System.out.print(name + "\t\t");
        } else {
            System.out.print(name + "\t");
        }
    }

    public void SetType(CreatureType type, String name) {
        this.type = type;
        this.name = name;
    }

    public boolean HaveCreature() {
        return type != CreatureType.Null;
    }
}
