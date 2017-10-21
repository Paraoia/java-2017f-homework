class Huluwa{
    private int rank;
    private String name;
    private Color color;
    // 构造葫芦娃
    public Huluwa(int who) {
        switch(who){
            case 0: rank = 0; name = "大娃"; color = Color.RED; break;
            case 1: rank = 1; name = "二娃"; color = Color.ORANGE; break;
            case 2: rank = 2; name = "三娃"; color = Color.YELLOW; break;
            case 3: rank = 3; name = "四娃"; color = Color.GREEN; break;
            case 4: rank = 4; name = "五娃"; color = Color.CYAN; break;
            case 5: rank = 5; name = "六娃"; color = Color.BLUE; break;
            case 6: rank = 6; name = "七娃"; color = Color.PURPLE; break;
            default: System.out.println("查无此娃!");
        }
    }
    // 报排行
    public void repoName(){
        System.out.print(name+" ");
    }
    // 报颜色
    public void repoColor(){
        System.out.print(color.toString()+" ");
    }
    public int getRank(){
        return rank;
    }
    // 比大小
    public boolean isOlder(Huluwa another){
        return rank < another.rank;
    }
    public boolean isYounger(Huluwa another){
        return rank > another.rank;
    }
    // 交换并报告交换动作
    public void swap(Position src, Position des){
        repoName(); System.out.print("：" + src.index + "->" + des.index + " ");
        des.holder.repoName(); System.out.print("：" + des.index + "->" + src.index + " ");
        Huluwa tmp = src.holder;
        src.holder = des.holder;
        des.holder = tmp;
    }
    // 移动并报告移动动作
    public void move(Position src, Position des){
        repoColor();
        if (des.index == -1){
            System.out.print("：" + (src.index+1) + "->OutOfQueue ");
        } else if (src.index == -1){
            System.out.print("：OutOfQueue->" + (des.index+1) + "\n");
        } else {
            System.out.print("：" + (src.index+1) + "->" + (des.index+1) + " ");
        }
        des.holder = src.holder;
        src.holder = null;
    }
}

enum Color {
    RED(0), ORANGE(1), YELLOW(2), GREEN(3), CYAN(4), BLUE(5), PURPLE(6);
    private int nCode;
    private String colors[] = {"红色", "橙色", "黄色", "绿色", "青色", "蓝色", "紫色"};
    private Color(int _nCode) {
        this.nCode = _nCode;
    }
    @Override
    public String toString(){
        return colors[nCode];
    }
}