

public class Calabashvine {

    //葫芦藤上有7个葫芦娃
    public Huluwa[] huluwas;

    public Calabashvine(){
        huluwas=new Huluwa[7];
        for(int i=0;i<huluwas.length;i++) {
            huluwas[i]=new Huluwa();
            huluwas[i].seniority=i;
        }
        huluwas[0].name="红娃";
        huluwas[1].name="橙娃";
        huluwas[2].name="黄娃";
        huluwas[3].name="绿娃";
        huluwas[4].name="青娃";
        huluwas[5].name="蓝娃";
        huluwas[6].name="紫娃";

        huluwas[0].color=COLOR.CHI;
        huluwas[1].color=COLOR.CHENG;
        huluwas[2].color=COLOR.HUANG;
        huluwas[3].color=COLOR.LV;
        huluwas[4].color=COLOR.QING;
        huluwas[5].color=COLOR.LAN;
        huluwas[6].color=COLOR.ZI;

    }


}
