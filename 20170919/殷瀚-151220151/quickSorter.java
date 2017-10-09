/*
* 继承自class HuLuQueueSorter
* 根据颜色确定了葫芦娃的rank信息，用于排序时比较
* 把报数时使用的名字CountName确定为颜色
* 通过快速排序实现了排序的功能
* */
public class quickSorter extends HuLuQueueSorter {

    /*设置rank和CountName*/
    @Override
    protected void init(){
        for(int i = 0; i < 7; i++){
            int numInFamily = 0;
            switch(queue[i].getColor()){
                case "红色" : numInFamily = 1; break;
                case "橙色" : numInFamily = 2; break;
                case "黄色" : numInFamily = 3; break;
                case "绿色" : numInFamily = 4; break;
                case "青色" : numInFamily = 5; break;
                case "蓝色" : numInFamily = 6; break;
                case "紫色" : numInFamily = 7; break;
            }
            queue[i].setRank(numInFamily);

            /*使用排行进行报数*/
            queue[i].setCountName("color");
        }
    }

    /*快速排序*/
    @Override
    public void Sort(){
        quickSort(queue, 0, 6);
    }

    private void quickSort(HuLuWa[] WaWaMen, int left, int right){
        if(left < right){

            /*partition*/
            HuLuWa key = WaWaMen[left];
            int low = left;
            int high = right;
            while(low < high){
                while(low < high && !key.youngerThan(WaWaMen[high]) ){
                    high--;
                }
                while( low < high &&  !WaWaMen[low].youngerThan(key) ){
                    low++;
                }
                HuLuWa.exchange(queue, low, high);
            }
            HuLuWa.exchange(queue, left, low);

            /*递归排序*/
            quickSort(WaWaMen,left,low-1);
            quickSort(WaWaMen,low+1,right);
        }
    }
}
