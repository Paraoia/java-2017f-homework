/**
 * Created by macbook on 2017/10/15.
 */
public class Director {
    Tspace tspace = new Tspace();

    Renwu[] huluwas=new Renwu[7];//葫芦娃

    Renwu[] yaoguais=new Renwu[11];//妖怪

    Renwu yeye;

    Renwu shejing;

    public void makebg(){

        for (int i = 0; i < 7; i++) {
            huluwas[i]=new Huluwa(Huluwa.PAIHANG.values()[i],Huluwa.COLOR.values()[i]);
        }
        yaoguais[0]=new Louluo("蝎子精 ");
        for (int i=1;i<11;i++){
            yaoguais[i]=new Louluo("喽啰"+String.valueOf(i)+"号");
        }
        yeye=new Louluo("爷爷  ");
        shejing=new Shejing("蛇精  ");

    }


    public static void main(String[] args){
        Director me=new Director();
        me.makebg();
        Zhandui zhandui=new Zhandui();
        int huluwa_h=5,huluwa_l=5;
        zhandui.she(me.tspace,me.huluwas,huluwa_h,huluwa_l);//葫芦娃站队
        new B_sort().sort(me.tspace,me.huluwas,huluwa_h,huluwa_l);//对葫芦娃进行排序
        zhandui.yeye(me.tspace,me.yeye,huluwa_h+3,huluwa_l-2);//爷爷站队
        zhandui.shejing(me.tspace,me.shejing,4,30);//蛇精站队
        zhandui.yan(me.tspace,me.yaoguais,5,30);//蝎子精带领小喽啰们站成雁形
        me.tspace.printTspace();//打印出二维空间
        me.tspace.cleanTspace();//清除二维空间
        zhandui.she(me.tspace,me.huluwas,5,5);
        zhandui.yeye(me.tspace,me.yeye,huluwa_h+3,huluwa_l-2);
        zhandui.shejing(me.tspace,me.shejing,4,20);
        zhandui.he(me.tspace,me.yaoguais,5,20);//鹤形
        me.tspace.printTspace();
    }
}
