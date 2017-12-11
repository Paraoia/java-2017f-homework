public class HuluwaWorld {
    public static void main(String[] args){
        /* 开天辟地，创建葫芦娃世界空间 */
        Space space = CreatSpace();

        /* 创建各种小生物，包括葫芦娃、爷爷、蛇精、蝎子、小咯喽 */
        Creature[] hulubro = CreatHulubro();
        Creature grandpa = CreatGrandpa();
        Creature snake = CreatSnake();
        Creature scorpion = CreatScorpion();
        Creature[] minions = CreatMinions();

        /* 创建一个上帝之手godhand，安排各种生物走入空间并站队 */
        EnterSpace godHand = new EnterSpace();

        System.out.println("形成对峙局面：（雁形 vs 长蛇）");
        /* 安排葫芦娃站成长蛇形列状排列，老大的地址在空间(row, col)处 */
        godHand.huluwa_longsnakeshape(space, hulubro, 17,6);
        /* 安排蝎子和啰喽站成雁形排列，带队的蝎子的地址在空间(row, col)处 */
        godHand.sco_and_min_gooseshape(space, scorpion, minions, 10,4);
        /* 安排爷爷和蛇精站到合适的位置各自打call... */
        godHand.grandpa_stand(space, grandpa, 15,15);
        godHand.snake_stand(space, snake, 6,15);

        /* 打印出对峙局面... */
        space.presentSpace();
        System.out.println("\n\n");

        /* 将空间里的蝎子、啰喽、爷爷、蛇精都clean掉，重新安排其位置... */
        space.clean_some_creatures();
        System.out.println("再次形成新的对峙局面：（箭形 vs 长蛇）");

        /* 安排蝎子和啰喽站成箭形排列，带队的蝎子的地址在空间(row, col)处 */
        godHand.sco_and_min_arrowshape(space, scorpion, minions, 8,9);
        /* 安排爷爷和蛇精站到合适的位置各自打call... */
        godHand.grandpa_stand(space, grandpa, 15,14);
        godHand.snake_stand(space, snake, 6,14);

        /* 打印出对峙局面... */
        space.presentSpace();
    }

    /* 创建二维空间 */
    public static Space CreatSpace(){
        Space spa = new Space();
        return spa;
    }

    /* 创建生物葫芦娃 */
    public static Creature[] CreatHulubro(){
        Creature[] hulubro = new Creature[7];
        hulubro[0] = new Creature("老大",'O');
        hulubro[1] = new Creature("老二",'O');
        hulubro[2] = new Creature("老三",'O');
        hulubro[3] = new Creature("老四",'O');
        hulubro[4] = new Creature("老五",'O');
        hulubro[5] = new Creature("老六",'O');
        hulubro[6] = new Creature("老七",'O');
        return hulubro;
    }

    /* 创建生物爷爷 */
    public static Creature CreatGrandpa(){
        Creature grandpa = new Creature("爷爷",'&');
        return grandpa;
    }

    /* 创建生物蛇精 */
    public static Creature CreatSnake(){
        Creature snake = new Creature("蛇精",'#');
        return snake;
    }

    /* 创建生物蝎子 */
    public static Creature CreatScorpion(){
        Creature scorpion = new Creature("蝎子",'#');
        return scorpion;
    }

    /* 创建生物喽啰 */
    public static Creature[] CreatMinions(){
        Creature[] minions = new Creature[12];
        int i;
        for(i=0; i<12; i++)
            minions[i] = new Creature("喽啰",'*');
        return minions;
    }

}