import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class God {//存放main函数
    private void shuffle(Creature[] creatures) {
        Random rnd = ThreadLocalRandom.current();
        for (int i = creatures.length - 1; i > 0; i--) {
            int index = rnd.nextInt(i + 1);
            Position position = creatures[index].getPosition();
            creatures[index].setPosition(creatures[i].getPosition());
            creatures[i].setPosition(position);
        }
    }

    public static void main(String[] args) {
        God god=new God();

        Flat flat=new Flat(15);

        //初始化葫芦娃
        Creature[] brothers = new Creature[7];
        for (int i = 0; i < brothers.length; i++) {
            brothers[i] = new Huluwa(COLOR.values()[i], RANK.values()[i]);
        }

        //初始化妖怪们
        Creature[] yaoguai=new Creature[7];
        yaoguai[0]=new Xiezijing();
        for(int i=1;i<7;i++){
            yaoguai[i]=new Xiaolouluo();
        }

        //初始化爷爷
        Creature yeye=new Grandpa();

        //初始化蛇精
        Creature shejing=new Shejing();

        //先给葫芦娃随机站个队
        Queue queue = new Queue(brothers);
        queue.shuffle();
        System.out.println("初始乱序：");
        queue.rollCall();

        //再排好序
        new InsertionSorter().sort(queue);
        System.out.println("排好序：");
        queue.rollCall();

        flat.Shexing_queue(brothers,7,3);//葫芦娃站蛇形队

        flat.Heyi_queue(yaoguai,5,3);//妖怪站鹤翼队

        flat.setCreature(yeye,9,2);//爷爷站位

        flat.setCreature(shejing,5,2);//蛇精站位

        System.out.println("鹤翼站队：");
        flat.rollCall();//报数

        flat.cleanFlat();//清除重站

        flat.Shexing_queue(brothers,8,4);//葫芦娃站蛇形队

        flat.Yanhang_queue(yaoguai,7,3);//妖怪站雁行队

        flat.setCreature(yeye,9,3);//爷爷站位

        flat.setCreature(shejing,6,3);//蛇精站位

        System.out.println("雁行站队：");
        flat.rollCall();
    }
}
