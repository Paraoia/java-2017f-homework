enum COLOR {
    Red, Orange, Yellow, Green, Cyan, Blue, Purple
}

public class Calabash extends Creature {
    private int index;
    private COLOR color;

    public Calabash(String name, int index, COLOR color) {
        type = CreatureType.Calabash;
        this.name = name;
        this.index = index;
        this.color = color;
    }

    public void SetCalabash(String name, int index, COLOR color) {
        this.name = name;
        this.index = index;
        this.color = color;
    }

    public String GetName() {
        return this.name;
    }

    public String GetColor() {
        String temp = null;
        switch (this.color) {
            case Red:
                temp = "赤";
                break;
            case Orange:
                temp = "橙";
                break;
            case Yellow:
                temp = "黄";
                break;
            case Green:
                temp = "绿";
                break;
            case Cyan:
                temp = "蓝";
                break;
            case Blue:
                temp = "靛";
                break;
            case Purple:
                temp = "紫";
                break;
        }
        return temp;
    }

    public int GetIndex() {
        return this.index;
    }
}
