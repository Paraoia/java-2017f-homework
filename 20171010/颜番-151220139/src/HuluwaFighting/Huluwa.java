package HuluwaFighting;

public class Huluwa implements Creature{

    private NAME name;
    private COLOR color;
    private Position pos;

    public Huluwa(int index){
        this.name = NAME.values()[index];
        this.color = COLOR.values()[index];
    }

    public String getName(){

        return name.toString();
    }

    public void report(){

        System.out.println(name+": "+color.toString()+" x: "+pos.getX()+" y: "+pos.getY());
    }


    public Position getPosition(){
        return pos;
    }

    public void setPosition(Position position){
        this.pos = position;
        this.pos.setHolder(this);
    }

    public void clearPosition(){
        this.pos.clearHolder();
        this.pos = null;
    }

    /*
    public boolean isbiggerThan(Comparable another) {
        assert(another instanceof Huluwa);
        return this.name.ordinal()>(((Huluwa)another).name.ordinal());
    }
    */
}

enum COLOR{
    RED, ORANGE, YELLOW, GREEN, CYAN, BLUE, PURPULE
}

enum NAME{
    大娃, 二娃, 三娃, 四娃, 五娃, 六娃, 七娃
}
