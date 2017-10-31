
class HuluWa extends Creature implements Comparable{

    private Color color;
    private Name name;

    public HuluWa(Color color, Name name) {
        this.type = CreatureType.娃;
       this.color = color;
       this.name = name;
       this.position = null;
    }

    public HuluWa(Color color, Name name, Position position) {
        this.color = color;
        this.name = name;
        this.position = position;
    }

    @Override
    public boolean biggerThan(Comparable another){
        if(another instanceof HuluWa)
            return this.name.ordinal() > ((HuluWa) another).name.ordinal();
        else
            return false;
    }

    @Override
    public String report(){
        return this.name.toString();
    }



    public Color getColor() {
        return color;
    }

    public Name getName() {
        return name;
    }
}

enum Color{红, 橙, 黄, 绿, 青, 蓝, 紫};

enum Name{大, 二, 三, 四, 五, 六, 七};
