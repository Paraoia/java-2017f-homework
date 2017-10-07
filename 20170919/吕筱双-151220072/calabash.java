public class calabash{
    private  Name name ;
    private Color color;

    public calabash(int index){
        this.name = Name.values()[index-1];
        this.color = Color.values()[index-1];
    }
    public calabash(){
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
        System.out.println(this.name.getName());
    }

    public Name getName() {
        return name;
    }

    public Color getColor() {
        return color;
    }

    public void printColor() {
        System.out.println(this.color.getColor());
    }

    public void move(position temp){
        temp.getHolder().setColor(this.color);
        temp.getHolder().setName(this.name);
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