//每一个葫芦娃：具有不同属性并能够报出自己的属性


public class Boy implements Creature, Comparable {
    RANK rank;       //排行
    COLOR color;      //颜色
    Position pos;     //自己之前的位置和现在的位置

    Boy(RANK r, COLOR c) {
        rank = r;
        color = c;
    }

    public RANK getRank() {
        return rank;
    }

    public COLOR getColor() {
        return color;
    }

    @Override
    public void setPos(Position pos) {
        this.pos = pos;
    }

    @Override
    public Position getPos() {
        return this.pos;
    }

    @Override
    public void report() {
        if (this.pos != null)
            System.out.println(rank.toString() + " " + color.toString() + " @ " + this.pos.getX() + "," + this.pos.getY());
    }

    @Override
    public boolean biggerThan(Comparable another) {
        if (another instanceof Grandpa)
            return false;
        else if (another instanceof Boy)
            return this.getRank().ordinal() > ((Boy) another).getRank().ordinal();
        else
            return true;
    }


    //每当换位置时，跟新位置属性并报出
   /* void changePos(int a) {
        prePos = nowPos;
        nowPos = a;
        if(prePos != nowPos) {
            tellRank();
            System.out.printf(":%d->%d\n",prePos, nowPos);
        }
    }*/
}


enum COLOR {
    红, 橙, 黄, 绿, 青, 蓝, 紫,
}

enum RANK {
    一, 二, 三, 四, 五, 六, 七,
}