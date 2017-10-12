/*
*葫芦兄弟的队列，作为两次排序类的基类
* 基类实现了初始化随机队列，队列排序结束后报数的功能
* 基类没有实现具体的排序函数
* */
import java.util.Random;
public class HuLuQueueSorter {
    protected HuLuWa[] queue;   //  葫芦娃队伍

    public HuLuQueueSorter(){
        int[] initPos = randomArray(7); //  生成随机队列

        /*初始化七个葫芦娃，并且随机站队*/
        queue = new HuLuWa[7];
        String[] HuLuNames = {"老大","老二","老三","老四","老五","老六","老七",};
        for(int i = 0; i < 7; i++){
            queue[i] = new HuLuWa(HuLuNames[initPos[i]]);
        }
    }

    /*葫芦娃站队排序的主函数*/
    public void main(){
        init();                     //  初始化队列

        System.out.print("排序前");
        reportQueue();              //  排序之前报数

        Sort();                     //  排序

        System.out.print("排序后");
        reportQueue();              //  排序之后报数
    }

    /*根据具体的要求，用排行或者颜色报数*/
    public void reportQueue(){
        System.out.print("队列：");
        int i;
        for(i = 0; i < 6; i++){
            System.out.print(queue[i].getCountName() + ",");
        }
        System.out.println(queue[i].getCountName());
    }

    /*下面两个功能在派生类中实现*/
    protected void init(){

    }
    public void Sort(){

    }

    /*生成随机数组，用于初始化随机队列*/
    private static int [] randomArray(int len){
        int solutionArr[] = new int[len];
        int ranIndex=0;
        Random random = new Random();
        for (int i = 0; i < len; i++)
            solutionArr[i] = i;
        for (int i = 0; i <len; i++) {
            ranIndex = random.nextInt(len);
            int temp = solutionArr[i];
            solutionArr[i] = solutionArr[ranIndex];
            solutionArr[ranIndex] = temp;
        }
        return solutionArr;
    }
}
