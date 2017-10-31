
public class sort{
    private static void bubbleSort(position pos){
        //对葫芦娃数组进行冒泡排序
        for(int i = 0; i < 7; i++){
            for(int j = 0; j < 6 - i; j++){
                if(pos.getWaNum(j) > pos.getWaNum(j+1)){
                    //对位置进行交换
                    pos.exchange(j,j+1);
                }
            }
        }

        System.out.println("冒泡排序后的顺序：");
        pos.callPosition();
    }

    private static void binarySort(position pos){
        //对葫芦娃数组进行二分法排序
        for(int i = 0; i < 6; i++){
           int temp = pos.getWaNum(i);
           int left = 0;
           int right = i-1;
           int mid = 0;
           while(left <= right){
               //二分法寻找插入的位置
               mid = (left+right)/2;
               if(temp<pos.getWaNum(mid)){
                   right = mid - 1;
               }else{
                   left = mid + 1;
               }
           }
           pos.move(i,7);
           for(int j = i-1; j>=left; j--){
               //对位置进行移动
               pos.move(j, j+1);
           }
           pos.move(7,left);
        }
        System.out.println("二分法排序后的顺序：");
        //排列完成后报数
        pos.callPosByColor();
    }

    public static void main(String args[]){
        position pos1 = new position();
        //随机站队
        pos1.getRandomRow();
        System.out.println("随意站队的顺序：");
        pos1.callPosition();
        //按年龄对队伍冒泡排序
        bubbleSort(pos1);
        
        position pos2 = new position();
        //随机站队
        pos2.clearPos();
        pos2.getRandomRow();
        System.out.println("随意站队的顺序：");
        pos2.callPosByColor();
        //按颜色对队伍二分法排序
        binarySort(pos2);
    }
}
