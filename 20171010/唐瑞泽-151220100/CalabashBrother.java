/**
 * Created by tangruize on 10/16/17.
 */
public class CalabashBrother extends Creature {
    // constructor
    CalabashBrother(int i) {
        super(CalabashNames.values()[i].toString(), CalabashColors.values()[i].toString());
    }
}

enum CalabashNames {
    大娃, 二娃, 三娃, 四娃, 五娃, 六娃, 七娃
}

enum CalabashColors {
    赤, 橙, 黄, 绿, 青, 蓝, 紫
}