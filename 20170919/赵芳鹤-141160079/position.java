import java.util.Random;

public class position{
    private static int huluwaNum[] = {-1,-1,-1,-1,-1,-1,-1,-1};
    private static boolean isEmpty[]={true,true,true,true,true,true,true,true};

    public static void exchange(int pos1, int pos2){
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
                callChange(fromPos, toPos, 1);
                huluwaNum[toPos] = huluwaNum[fromPos];
                isEmpty[toPos] = false;
                huluwaNum[fromPos] = -1;
                isEmpty[fromPos] = true;
            }
        }
    }
    public void getRandomRow(){
        //This is a function that allow hulu brothers to stand in a row randomly
        Random random = new Random();

        int k = 0;
        while(k < 7){
            int tmp = random.nextInt(7)%7;
            if(isEmpty[tmp]){
                huluwaNum[tmp] = k;
                isEmpty[tmp] = false;
                k++;
            }
        }
    }
    public static void callChange(int fromPos, int toPos, int colorKey){
        if(colorKey == 0) {
            huluwa.printAgeSequence(huluwaNum[fromPos]);
        }else{
            huluwa.printColor(huluwaNum[fromPos]);
        }
        System.out.printf(": %d->%d\n", fromPos, toPos);
    }

    public static void callPosition(){
        for(int i = 0; i<7; i++){
            huluwa.printAgeSequence(huluwaNum[i]);
            System.out.printf(" ");
        }
        System.out.printf("\n");
    }

    public static void callPosByColor(){
        for(int i = 0; i<7; i++){
            huluwa.printColor(huluwaNum[i]);
            System.out.printf(" ");
        }
        System.out.printf("\n");
    }

    public static int getWaNum(int i){
        return huluwaNum[i];
    }
    public void clearPos(){
        for(int i = 0; i < 8; i++){
            huluwaNum[i] = -1;
            isEmpty[i] = true;
        }
    }
}