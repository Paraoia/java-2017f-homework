//每一个葫芦娃：具有不同属性并能够报出自己的属性

public class Boy {
    int rank;       //排行,由数字1~7表示
    COLOR color;      //颜色,由数字1~7表示
    int prePos, nowPos;     //自己之前的位置和现在的位置

    Boy(int r, COLOR c, int q, int p) {
        rank = r;
        color = c;
        prePos = q;
        nowPos = p;
    }

    void tellRank() {
        switch(rank) {
            case 1: System.out.print("老大 "); break;
            case 2: System.out.print("老二 "); break;
            case 3: System.out.print("老三 "); break;
            case 4: System.out.print("老四 "); break;
            case 5: System.out.print("老五 "); break;
            case 6: System.out.print("老六 "); break;
            case 7: System.out.print("老七 "); break;
        }
    }

    void tellColor(){
        switch(color) {
            case RED: System.out.print("红色 "); break;
            case ORANGE: System.out.print("橙色 "); break;
            case YELLOW: System.out.print("黄色 "); break;
            case GREEN: System.out.print("绿色 "); break;
            case CYAN: System.out.print("青色 "); break;
            case BLUE: System.out.print("蓝色 "); break;
            case PURPLE: System.out.print("紫色 "); break;
        }
    }

    //每当换位置时，跟新位置属性并报出
    void changePos(int a) {
        prePos = nowPos;
        nowPos = a;
        if(prePos != nowPos) {
            tellRank();
            System.out.printf(":%d->%d\n",prePos, nowPos);
        }
    }
}
