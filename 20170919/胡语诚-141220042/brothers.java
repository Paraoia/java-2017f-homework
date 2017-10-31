/**
 * Created by admin on 2017/9/22.
 */

public class brothers {

    public static void main(String[] args) {
        brother one = new brother(1,Color.RED);
        brother two = new brother(2,Color.ORANGE);
        brother three = new brother(3,Color.YELLOW);
        brother four = new brother(4,Color.GREEN);
        brother five = new brother(5,Color.BLUE);
        brother six = new brother(6,Color.INDIGO);
        brother seven = new brother(7,Color.VIOLET);
        brother[] bros = {seven,three,two,six,one,five,four};
        bubble(bros);
        printBros(bros);
        brother[] bros2 = {two,one,three,seven,six,five,four};
        quick(bros2,0,6);
        printBros2(bros2);
    }

    static void bubble(brother[] bros) {
        for(int i=0;i < 6;i++)
            for(int j=0;j < 6-i;j++) {
                if(bros[j].getNo() > bros[j+1].getNo()) {
                    System.out.println(bros[j].getName() + ":" + j +"->" + (j+1));
                    System.out.println(bros[j+1].getName() + ":" + (j+1) +"->" + j);
                    brother tmp = bros[j];
                    bros[j] = bros[j+1];
                    bros[j+1] = tmp;
                }
            }
    }

    static void quick(brother[] bros,int left,int right) {
        if(left >= right)
            return;
        Color no = bros[left].getColor();
        int i=left+1,j=right;
        while(i < j) {
            if(bros[i].getColor().compareTo(no) > 0) {
                System.out.println(bros[i].getColorName() + ":" + i + "->" + j);
                System.out.println(bros[j].getColorName() + ":" + j + "->" + i);
                brother tmp = bros[j];
                bros[j] = bros[i];
                bros[i] = tmp;
                j--;
            }
            else if(bros[i].getColor().compareTo(no) <= 0)
                i++;
        }
        if(bros[i].getColor().compareTo(no) > 0) {
            if(left != i-1) {
                System.out.println(bros[left].getColorName() + ":" + left + "->" + (i - 1));
                System.out.println(bros[i - 1].getColorName() + ":" + (i - 1) + "->" + left);
                brother tmp = bros[left];
                bros[left] = bros[i - 1];
                bros[i - 1] = tmp;
            }
            i--;
        }
        else if(bros[i].getColor().compareTo(no) <= 0) {
            System.out.println(bros[left].getColorName() + ":" + left + "->" + i);
            System.out.println(bros[i].getColorName() + ":" + i + "->" + left);
            brother tmp = bros[left];
            bros[left] = bros[i];
            bros[i] = tmp;
            j++;
        }
        quick(bros,left,i-1);
        quick(bros,j,right);
    }


    static void printBros(brother[] bros) {
        for(int i=0;i < 7;i++)
            System.out.println(bros[i].getName());
    }

    static void printBros2(brother[] bros) {
        for(int i=0;i < 7;i++)
                System.out.println(bros[i].getColorName());
    }

}
