
class HuluWa {

    static private String []name = {"老大","老二","老三","老四","老五","老六","老七"};//葫芦娃的名字
    static private String []color = {"红色","橙色","黄色","绿色","青色","蓝色","紫色"};//葫芦娃的颜色
    private int id;//此葫芦娃的编号

    public HuluWa(int id) {
        if(id < 0 || id > 6)
            throw new RuntimeException("这是个假葫芦娃，编号是：" + id);
        this.id = id;
    }

    public int tellId() {
        return this.id;
    }

    public String toNameString(){
        return HuluWa.name[this.id];
    }

    public String toColorString() {
        return HuluWa.color[this.id];
    }

}
