public abstract class Block {

    boolean isoccupied() { return false; }

    abstract void positionreset();

    NAME getname() { return NAME.NONE; }

}

enum NAME {
    NONE, 大娃, 二娃, 三娃, 四娃, 五娃, 六娃, 七娃, 爷爷, 蛇精, 蝎子精, 蛤蟆怪
}
