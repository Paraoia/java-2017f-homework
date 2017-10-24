public class LouLuo implements Creature {

    private LName name;
    private Position position;

    LouLuo(LName name){
        this.name = name;
    }

    public String toString(){
        return "小喽啰"+name.toString();
    }

    @Override
    public void report(){
        System.out.print(this.toString());
    }

    @Override
    public void setPosition(Position position){
        this.position = position;
        position.setHolder(this);
    }

    @Override
    public Position getPosition(){
        return position;
    }
}

enum LName {
    一, 二, 三, 四, 五, 六, 七
}
