package HuluWaSort;

public class Main {
    public static void main(String args[]){
        HuluWaFactory huluWaFactory = new HuluWaFactory();
        HuluWaSorter huluWaSorter = new HuluWaSorter();

        //使用工厂模式创建七个葫芦娃，并放入葫芦娃排序器中
        try {
            huluWaSorter.addHuluWa(huluWaFactory.produce("红"));
            huluWaSorter.addHuluWa(huluWaFactory.produce("橙"));
            huluWaSorter.addHuluWa(huluWaFactory.produce("黄"));
            huluWaSorter.addHuluWa(huluWaFactory.produce("绿"));
            huluWaSorter.addHuluWa(huluWaFactory.produce("青"));
            huluWaSorter.addHuluWa(huluWaFactory.produce("蓝"));
            huluWaSorter.addHuluWa(huluWaFactory.produce("紫"));
        }catch(Exception e){
            //有葫芦娃没有创建成功
            System.out.println(e.getMessage() + "程序异常退出！");
            System.exit(-1);
        }

        //葫芦娃们随意站队
        huluWaSorter.chaos();

        //排序器对葫芦娃们使用冒泡排序
        huluWaSorter.setSorter(HuluWaSorter.SorterType.BUBBLESORT);
        huluWaSorter.sort();
        huluWaSorter.showHuluWasByOrder();

        //葫芦娃们随意站队x2
        huluWaSorter.chaos();

        //排序器对葫芦娃们使用快速排序
        huluWaSorter.setSorter(HuluWaSorter.SorterType.QUICKSORT);
        huluWaSorter.sort();
        huluWaSorter.showHuluWasByColor();
    }

}
