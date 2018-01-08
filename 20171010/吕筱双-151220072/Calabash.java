public class Calabash  implements Creature ,Comparable{

    private  Name name ;
    private Color color;
    private Position position;

    public Calabash(int index){
        this.name = Name.values()[index];
        this.color = Color.values()[index];
    }
    public Calabash(){
        this.name = null;
        this.color =null;
    }

    public void setName(Name name) {
        this.name = name;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public void printName() {
        System.out.print(this.name.getName());
    }

    public Name getNameValue() {
        return name;
    }

    public String getName() {
        return name.getName();
    }

    public Color getColor() {
        return color;
    }

    public void printColor() {
        System.out.println(this.color.getColor());
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
        return "Calabash{" +
                "name=" + name +
                ", color=" + color +
                ", position=" + position +
                '}';
    }

    @Override
    public void report(){
        System.out.print(this.toString());
    }

    public boolean biggerThan(Comparable brother){
        if(brother instanceof Calabash) {
            return this.getNameValue().ordinal() > ((Calabash) brother).getNameValue().ordinal();
        }
        else
            return false;
    }
}

/*
    对颜色静态变量进行枚举
 */
enum Color {
    RED("红色",1),ORANGE("橙色",2),YELLOW("黄色",3),GREEN("绿色",4),CMYK("青色",5),BLUE("蓝色",6),PURPLE("紫色",7);

    private String color;
    private int index;

    private Color(String color,int index) {
        this.color = color;
        this.index = index;
    }

    public int getIndex() {
        return index;
    }

    public String getColor() {
        return color;
    }
}

/*
对葫芦娃及其对应的名称进行枚举
 */
enum Name {
    ONE("老大",1),TWO("老二",2),THREE("老三",3),FOUR("老四",4),FIVE("老五",5),SIX("老六",6),SEVEN("老七",7);

    private String name;
    private int index;

    private Name(String name,int index) {
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