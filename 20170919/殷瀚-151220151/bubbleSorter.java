/*
* 继承自class HuLuQueueSorter
* 根据排行确定了葫芦娃的rank信息，用于排序时比较
* 把报数时使用的名字CountName确定为排行
* 通过冒泡排序实现了排序的功能
* */
public class bubbleSorter extends HuLuQueueSorter {

    /*设置rank和CountName*/
    @Override
    protected void init(){
        for(int i = 0; i < 7; i++){
            /*根据排行得到排序大小信息*/
            int numInFamily = 0;
            switch(queue[i].getName()){
                case "老大" : numInFamily = 1; break;
                case "老二" : numInFamily = 2; break;
                case "老三" : numInFamily = 3; break;
                case "老四" : numInFamily = 4; break;
                case "老五" : numInFamily = 5; break;
                case "老六" : numInFamily = 6; break;
                case "老七" : numInFamily = 7; break;
            }
            queue[i].setRank(numInFamily);

            /*使用排行进行报数*/
            queue[i].setCountName("name");
        }
    }

    /*冒泡排序*/
    @Override
    public void Sort(){
        for(int i = 0; i < 7; i++){
            for(int j = 0; j < 7 - i -1; j++){
                if(queue[j].youngerThan(queue[j+1])){
                    HuLuWa.exchange(queue, j, j+1);
                }
            }
        }
    }
}
