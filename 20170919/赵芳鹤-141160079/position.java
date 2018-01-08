import java.util.Random;

public class position{
    /*初始化position
    所有位置上都没有葫芦娃
    @huluwaNum代表各个位置的葫芦娃编号，-1代表无葫芦娃
    @isEmpty代表各个位置是否为空
    */
    private static int huluwaNum[] = {-1,-1,-1,-1,-1,-1,-1,-1};
    private static boolean isEmpty[]={true,true,true,true,true,true,true,true};

    public static void exchange(int pos1, int pos2){
        //交换pos1和pos2两个位置上的葫芦娃，每次移动前报告动作
        callChange(pos1, 7, 0);
        huluwaNum[7] = huluwaNum[pos1];
        callChange(pos2, pos1,0);
        huluwaNum[pos1] = huluwaNum[pos2];
        callChange(7,pos2,0);
        huluwaNum[pos2] = huluwaNum[7];
    }

    public static void move(int fromPos, int toPos){
        if(isEmpty[toPos]){
            if(!isEmpty[fromPos]){
                //如果fromPos不为空，toPos为空，将fromPos的葫芦娃移动到toPos
                callChange(fromPos, toPos, 1);
                huluwaNum[toPos] = huluwaNum[fromPos];
                isEmpty[toPos] = false;
                huluwaNum[fromPos] = -1;
                isEmpty[fromPos] = true;
            }
        }
    }
    public void getRandomRow(){
        //让葫芦娃随机站队
        Random random = new Random();

        int k = 0;
        while(k < 7){
            int tmp = random.nextInt(7)%7;
            if(isEmpty[tmp]){
                //判断产生的随机数代表的位置是否为空，空则站入下一个葫芦娃，非空则产生下一个随机数
                huluwaNum[tmp] = k;
                isEmpty[tmp] = false;
                k++;
            }
        }
    }
    public static void callChange(int fromPos, int toPos, int colorKey){
        //报告交换动作
        if(colorKey == 0) {
            huluwa.printAgeSequence(huluwaNum[fromPos]);
        }else{
            huluwa.printColor(huluwaNum[fromPos]);
        }
        System.out.printf(": %d->%d\n", fromPos, toPos);
    }

    public static void callPosition(){
        //报告各个位置站的葫芦娃（年龄）
        for(int i = 0; i<7; i++){
            huluwa.printAgeSequence(huluwaNum[i]);
            System.out.printf(" ");
        }
        System.out.printf("\n");
    }

    public static void callPosByColor(){
        //报告各个位置站的葫芦娃（颜色）
        for(int i = 0; i<7; i++){
            huluwa.printColor(huluwaNum[i]);
            System.out.printf(" ");
        }
        System.out.printf("\n");
    }

    public static int getWaNum(int i){
        //返回第i个位置的葫芦娃编号
        return huluwaNum[i];
    }
    public void clearPos(){
        //第一次排序后对huluwaNum和isEmpty进行重置，以便于第二次排序
        for(int i = 0; i < 8; i++){
            huluwaNum[i] = -1;
            isEmpty[i] = true;
        }
    }
}
