public class World {

    Brothers bro ;
    Sort sort;
    void initialize()  //初始化World成员变量 bro和sort
    {
        bro =new Brothers();
        sort = new Sort();
    }
    public static void main(String []args)
    {
        World world =new World();
        world.initialize();//初始化世界中的排序对象 和 葫芦兄弟们对象

        /* 随意站队 */
        world.bro.RandomQueue();
        System.out.println("冒泡排序前的站队：");
        world.bro.PrintRank();
        world.sort.BubbleSort(world.bro);
        System.out.println("冒泡排序后的站队");
        world.bro.PrintRank();

        /*重新随意站队*/
        world.bro.RandomQueue();
        System.out.println("快速排序前的站队：");
        world.bro.PrintColor();
        world.sort.QuickSort(world.bro,0,6);
        System.out.println("快速排序后的站队：");
        world.bro.PrintColor();
    }
}
