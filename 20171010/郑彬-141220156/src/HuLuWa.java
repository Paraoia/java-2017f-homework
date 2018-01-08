/**
 * Created by bingo on 2017/10/22.
 */

enum COLOR {
    赤, 橙, 黄, 绿, 青, 蓝, 紫
}

enum SENIORITY {
    一, 二, 三, 四, 五, 六, 七
}

public class HuLuWa extends Creature {
    private COLOR color;
    private SENIORITY seniority;

    public HuLuWa(COLOR color, SENIORITY seniority) {
        super();
        this.color = color;
        this.seniority = seniority;
    }

    public COLOR getColor() {
        return color;
    }

    public void setColor(COLOR color) {
        this.color = color;
    }

    public SENIORITY getSeniority() {
        return seniority;
    }

    public void setSeniority(SENIORITY seniority) {
        this.seniority = seniority;
    }

    @Override
    public String toString() {
        return this.seniority.toString() + "(" + this.color.toString() + ")";
    }

    @Override
    public void report() {
        System.out.println(this.toString());
    }

    @Override
    public String getName() {
        return toString();
    }

    @Override
    public char getSymb() {
        switch (this.seniority) {
            case 一:     return '1';
            case 二:     return '2';
            case 三:     return '3';
            case 四:     return '4';
            case 五:     return '5';
            case 六:     return '6';
            case 七:     return '7';
            default:     return 'H';
        }
    }
}
