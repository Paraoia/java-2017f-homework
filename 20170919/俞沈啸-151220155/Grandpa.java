public class Grandpa {
    public static void main(String[] args){

        //爷爷培育了一条葫芦藤
        Calabashvine calabashvine=new Calabashvine();

        //爷爷构造了一个队列
        Queue queue=new Queue();

        //爷爷将藤上的葫芦娃放入队列中
        queue.enqueueinrandom(calabashvine.huluwas);

        //爷爷让葫芦娃报数
        queue.countoffinseniority();

        //爷爷让葫芦娃按大小排序
        queue.sortinseniority();

        //爷爷让葫芦娃报数
        queue.countoffinseniority();

        //爷爷将葫芦娃再次随机站队
        queue.enqueueinrandom(calabashvine.huluwas);

        //爷爷让葫芦娃按颜色排序
        queue.sortincolor();

        //爷爷让葫芦娃报数
        queue.countoffincolor();

    }
}
