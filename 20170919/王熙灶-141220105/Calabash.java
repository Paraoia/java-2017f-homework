/**
 * 每一只葫芦娃所具备的属性，包括颜色，长幼次序，以及用于排序的关键字_intNo
 */

public class Calabash {
    private String _colorWa;
    private String _laoNo;
    private int _intNo;

    Calabash(String colorWa, String laoNo, int intNo) {
        _colorWa = colorWa;
        _laoNo = laoNo;
        _intNo = intNo;
    }

    public String get_colorWa() {
        return _colorWa;
    }

    public String get_laoNo() {
        return _laoNo;
    }

    public int get_intNo() {
        return _intNo;
    }

    /**
     * 葫芦娃报告自己的交换动作
     */
    public void reportExchange(int origin, int now) {
        System.out.print(_laoNo + ": " + origin + "->" + now);
    }
}