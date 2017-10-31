public class GodIsGod {
    public static void main(String[] args) {

        //葫芦树上结了7个葫芦
        Huluwa[] hulus = HuluTree.createHuluwas();

        //生成一个队列
        Queue queue = new Queue();

        //将葫芦兄弟随机放到队列中
        queue.enQueue(hulus);

        //队列上的葫芦兄弟随机站队
        queue.randomQueue();

        //葫芦兄弟根据名字报数
        queue.reportByName();

        //队列上的葫芦兄弟冒泡排序
        //注: 排序都是借助0号位置来完成, 而非直接交换两个葫芦娃的位置
        queue.bubbleSort();

        //葫芦兄弟根据名字报数
        queue.reportByName();

        //队列上的葫芦兄弟随机站队
        queue.randomQueue();

        //葫芦兄弟根据颜色报数
        queue.reportByColor();

        //队列上的葫芦兄弟快速排序
        queue.quickSort();

        //葫芦兄弟根据颜色报数
        queue.reportByColor();
    }
}
