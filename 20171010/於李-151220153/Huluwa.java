public class Huluwa extends Creature implements Comparable {

    private COLOR color;
    private SENIORITY seniority;

    Huluwa(COLOR color, SENIORITY seiority) {
        color = color;
        seniority = seiority;
    }

    public SENIORITY getSeniority() {
        return seniority;
    }

    @Override
    public String toString(){
        return seniority.toString();
    }

    @Override
    public boolean biggerThan(Comparable another) {
        if (another instanceof  Huluwa)
            return getSeniority().ordinal()> ((Huluwa) another).getSeniority().ordinal();
        else
            return false;
    }

    @Override
    public void act() {
        System.out.println(toString() + ":欧拉欧拉欧拉欧拉!");
    }
}

enum COLOR {
    赤, 橙, 黄, 绿, 青, 蓝, 紫
}

enum SENIORITY {
    大娃, 二娃, 三娃, 四娃, 五娃, 六娃, 七娃
}