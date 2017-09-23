
public class Hw1 {
    public static void main(String []args){
        SortClass sortclass = new SortClass();
        System.out.println("排序前：");
        sortclass.printAllName();
        System.out.println("开始排序：");
        sortclass.sort();
        System.out.println("排序后：");
        sortclass.printAllName();
    }
}

class SortClass{
    private final int num = 7;
    private CalabashBro []calabashBros;
    SortClass(){
        calabashBros = new CalabashBro[num];
        calabashBros[0] = new CalabashBro(3, 0);
        calabashBros[1] = new CalabashBro(2, 1);
        calabashBros[2] = new CalabashBro(1, 2);
        calabashBros[3] = new CalabashBro(0, 3);
        calabashBros[4] = new CalabashBro(4, 4);
        calabashBros[5] = new CalabashBro(6, 5);
        calabashBros[6] = new CalabashBro(5, 6);
    }

    //顺序打印所有人名字
    public void printAllName(){
        String str = "";
        for(int i = 0; i < num ; ++i)
            str = str + CalabashBro.name[calabashBros[i].tellid()] + " ";
        System.out.println(str);
    }

    //顺序打印所有人颜色
    public void printAllColor() {
        String str = "";
        for(int i = 0; i < num ; ++i)
            str = str + CalabashBro.color[calabashBros[i].tellid()] + " ";
        System.out.println(str);
    }

    //冒泡
    public void sort(){
        for(int i = 0; i < num ; ++i)
            for(int j = 0; j < num - i - 1; ++j)
                if(calabashBros[j].tellid() > calabashBros[j + 1].tellid())
                    calabashBros[j].exchange(calabashBros[j + 1]);
    }
}

class CalabashBro {

    static String []name = {"大娃","二娃","三娃","四娃","五娃","六娃","七娃"};
    static String []color = {"红色","橙色","黄色","绿色","青色","蓝色","紫色"};
    private int id;
    private int pos;

    public CalabashBro(int id, int pos){
        this.pos = pos;
        this.id = id;
    }

    public int tellid(){
        return id;
    }

    public void exchange(CalabashBro bro){
        //报告交换情况
        System.out.println(CalabashBro.name[id] + ":" + this.pos + "->" + bro.pos);
        //交换
        int temp = bro.id;
        bro.id = this.id;
        this.id = temp;
    }

}
