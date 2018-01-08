public class Magnate implements Creature{
    private  MagnateName magnateName ;
    private Position position;

    public Magnate(int index){
        this.magnateName = MagnateName.values()[index];
    }
    public Magnate(){
        this.magnateName= null;
        this.position = null;
    }

    public String getName() {
        return magnateName.getName();
    }

    public void printName() {
        System.out.print(this.magnateName.getName());
    }

    @Override
    public Position getPosition(){return position;}

    @Override
    public void setPosition(Position position){
        this.position = position;
        position.setHolder(this);
    }

    @Override
    public String toString() {
        return "Magnate{" +
                "magnateName=" + magnateName +
                ", position=" + position +
                '}';
    }

    @Override
    public void report(){
        System.out.print(this.toString());
    }

}


/*
对妖精头领及其对应的名称进行枚举
 */
enum MagnateName {
    scorpion("蝎子",1),Snake("蛇精",2);

    private String name;
    private int index;

    private MagnateName(String name,int index) {
        this.name = name;
        this.index = index;
    }

    public String getName() {
        return name;
    }

    public int getIndex() {
        return index;
    }


}
