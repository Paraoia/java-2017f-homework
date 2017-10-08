
public class sort{
    private static void bubbleSort(position pos){
        for(int i = 0; i < 7; i++){
            for(int j = 0; j < 6 - i; j++){
                if(pos.getWaNum(j) > pos.getWaNum(j+1)){
                    pos.exchange(j,j+1);
                }
            }
        }

        System.out.println("冒泡排序后的顺序：");
        pos.callPosition();
    }

    private static void binarySort(position pos){
        for(int i = 0; i < 6; i++){
           int temp = pos.getWaNum(i);
           int left = 0;
           int right = i-1;
           int mid = 0;
           while(left <= right){
               mid = (left+right)/2;
               if(temp<pos.getWaNum(mid)){
                   right = mid - 1;
               }else{
                   left = mid + 1;
               }
           }
           pos.move(i,7);
           for(int j = i-1; j>=left; j--){
               pos.move(j, j+1);
           }
           pos.move(7,left);
        }
        System.out.println("二分法排序后的顺序：");
        pos.callPosByColor();
    }

    public static void main(String args[]){
        position pos1 = new position();
        pos1.getRandomRow();
        System.out.println("随意站队的顺序：");
        pos1.callPosition();
        bubbleSort(pos1);
        position pos2 = new position();
        pos2.clearPos();
        pos2.getRandomRow();
        System.out.println("随意站队的顺序：");
        pos2.callPosByColor();
        binarySort(pos2);
    }
}