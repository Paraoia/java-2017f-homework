import java.util.Random;

enum Color{
    RED(0),ORANGE(1),YELLOW(2),GREEN(3),CYAN(4),BLUE(5),PURPLE(6);
    private Color(int temp){
        this.ColorValue = temp;
    }
    private int ColorValue;
}

class HuluBro{
    private int position;
    private  Color color;
    private int NO;
    private String name;
    HuluBro(int temp){
        NO = temp;
        position = temp;
        switch (temp){
            case 0:{
                name = "大娃";
                color = Color.RED;
                break;
            }
            case 1:{
                name = "二娃";
                color = Color.ORANGE;
                break;
            }
            case 2:{
                name = "三娃";
                color = Color.YELLOW;
                break;
            }
            case 3:{
                name = "四娃";
                color = Color.GREEN;
                break;
            }
            case 4:{
                name = "五娃";
                color = Color.CYAN;
                break;
            }
            case 5:{
                name = "六娃";
                color = Color.BLUE;
                break;
            }
            case 6:{
                name = "七娃";
                color = Color.PURPLE;
                break;
            }
        }
    }
    public int getPosition() {
        return this.position;
    }
    public int getNO(){
        return this.NO;
    }
    public String getName() {
        return name;
    }
    public String getColor() {
        return color.toString();
    }
    public void changePos(int temp){
        this.position = temp;
    }
}

class HuluVine{
    HuluBro HuluBros[];
    int tpos[];
    HuluVine(){
        tpos = new int[7];
        HuluBros = new HuluBro[7];
        for(int i = 0;i<7;i++)
            HuluBros[i] = new HuluBro(i);
        //randomHulu();
        return;
    }
    public void randomHulu(){
        boolean[] ifExist = new boolean[7];
        for(int i = 0;i<7;i++)
            ifExist[i] = false;
        Random random = new Random();
        random.nextInt(7);
        for(int i = 0;i<7;i++){
            int ranPos;
            while(true) {
                ranPos = random.nextInt(7);
                if(!ifExist[ranPos]){
                    ifExist[ranPos] = true;
                    break;
                }
            }
            this.HuluBros[i].changePos(ranPos);
        }
        for(int i = 0;i < 7;i++)
            tpos[i] = HuluBros[i].getPosition();
        for(int i = 0;i < 7;i++)
            HuluBros[tpos[i]].changePos(i);
        return;
    }
    public void BubbleSort()
    {
        int temp;


        for(int i = 0;i < 6;i++)
        {
            for(int j = 0;j < i;j++)
            {
                if(HuluBros[tpos[j]].getNO() > HuluBros[tpos[j + 1]].getNO())
                {
                    HuluBros[tpos[j]].changePos((j+1));
                    HuluBros[tpos[j + 1]].changePos(j);
                    temp = tpos[j];
                    tpos[j] = tpos[j+1];
                    tpos[j+1] = temp;
                }
            }
        }
        return;
    }
    public void QuickSort(){
        QuickSortS(0,6);
        return;
    }
    public void QuickSortS(int low,int high){
        if(low>=high)
            return;
        int partation = getPar(low,high);
        QuickSortS(low,partation-1);
        QuickSortS(partation+1,high);
    }
    private int getPar(int low,int high){
        int temp = tpos[low];
        int pivot = HuluBros[temp].getNO();
        while(low<high){
            while(low<high&&pivot<=HuluBros[tpos[high]].getNO())
                high--;
            tpos[low] = tpos[high];
            HuluBros[tpos[high]].changePos(low);
            while(low<high&&pivot>=HuluBros[tpos[low]].getNO())
                low++;
            tpos[high] = tpos[low];
            HuluBros[tpos[low]].changePos(high);
        }
        HuluBros[temp].changePos(low);
        tpos[low] = temp;
        return low;
    }
    public void PutOut(){
        for (int i=0;i<7;i++){
            System.out.print(HuluBros[i].getColor()+" "+HuluBros[i].getPosition());
        }
    }
}

public class HuluWa{
    public static void main(String args[]){
        Color a = Color.BLUE;
        int t = a.ordinal();
        HuluVine m = new HuluVine();
        m.randomHulu();
        m.PutOut();
        m.BubbleSort();
        m.PutOut();
        m.randomHulu();
        m.PutOut();
        m.QuickSort();
        m.PutOut();
        return;
    }
}

