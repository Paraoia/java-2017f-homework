/*
* 葫芦娃类
* 包含基本信息：排行、颜色，对外可获取
* 以及具体过程中要求的信息：大小信息、报数时使用的名字，对外可获取和修改
* 主要函数：与另一个葫芦娃比较大小，交换两个葫芦娃，交换时报数
* */
public class HuLuWa {
    private String name, color;   //  葫芦娃的基本信息：排行，颜色
    /*下面的信息由两次排序的具体要求决定*/
    private int rank;             //  排序的大小依据， 由排行或者颜色确定
    private String countName;     //  报数时所使用的名字

    /*不带参数的构造函数，实际上并不会调用*/
    public HuLuWa() {
        name = "unknown";
        color = "unknown";
        rank = 0;
        countName = "unknown";
    }

    /*创造葫芦娃对象时，需要给出家中排行*/
    public HuLuWa(String rankInFamily){
        name = rankInFamily;
        switch(rankInFamily){
            case "老大" : color = "红色"; break;
            case "老二" : color = "橙色"; break;
            case "老三" : color = "黄色"; break;
            case "老四" : color = "绿色"; break;
            case "老五" : color = "青色"; break;
            case "老六" : color = "蓝色"; break;
            case "老七" : color = "紫色"; break;
        }
        /*此时还不能确定下面两条信息*/
        rank = 0;
        countName = "unknown";
    }

    /*比较两个葫芦娃谁应该站在后面*/
    public boolean youngerThan(HuLuWa next){
        if(rank > next.rank)
            return true;
        else
            return false;
    }

    public void setRank(int No){
        rank = No;
    }

    public void setCountName(String choice){
            switch(choice){
                case "name" : countName = name; break;
                case "color" : countName = color; break;
            }
    }

    /*交换位置时报数*/
    public void claimChangePosition(int src, int des){
        System.out.println(countName + ": " + src + "->" + des);
    }

    /*交换位置并且报数*/
    public static void exchange(HuLuWa WaWaMen[], int x, int y){
        if(x == y)
            return;
        WaWaMen[x].claimChangePosition(x, x+1);
        WaWaMen[x+1].claimChangePosition(x+1, x);
        HuLuWa temp = WaWaMen[x];
        WaWaMen[x] = WaWaMen[y];
        WaWaMen[y] = temp;
    }

    public String getName() {
        return name;
    }

    public String getColor() {
        return color;
    }

    public String getCountName() {
        return countName;
    }
}
