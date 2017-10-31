import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class GoodCamp extends Camp {
    GoodCamp()
    {
        this.sum=7;
        creature=new Huluwa[7];
        creature[0]=new Huluwa(COLOR.赤,SENIORITY.一);
        creature[1]=new Huluwa(COLOR.橙,SENIORITY.二);
        creature[2]=new Huluwa(COLOR.黄,SENIORITY.三);
        creature[3]=new Huluwa(COLOR.绿,SENIORITY.四);
        creature[4]=new Huluwa(COLOR.青,SENIORITY.五);
        creature[5]=new Huluwa(COLOR.蓝,SENIORITY.六);
        creature[6]=new Huluwa(COLOR.紫,SENIORITY.七);

    }
    public void shuffle() {
        Random rnd = ThreadLocalRandom.current();
        for (int i = creature.length - 1; i > 0; i--) {
            int index = rnd.nextInt(i + 1);
            Creature temp = creature[index];
            creature[index]=creature[i];
            creature[i]=temp;
        }
    }

}
