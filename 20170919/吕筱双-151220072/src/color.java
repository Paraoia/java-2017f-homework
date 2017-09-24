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