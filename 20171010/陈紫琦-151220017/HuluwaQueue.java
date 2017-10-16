public class HuluwaQueue extends Queue
{
    Space space;
    HuluwaQueue()
    {
        num = 7;
        creatures = new Creature[num];
        int i;
        for (i = 0; i < num; i++)
        {
            HuluAttribute huluAttribute;
            switch (i+1)
            {
                case 1: huluAttribute = HuluAttribute.RED; break;
                case 2: huluAttribute = HuluAttribute.ORANGE; break;
                case 3: huluAttribute = HuluAttribute.YELLOW; break;
                case 4: huluAttribute = HuluAttribute.GREEN; break;
                case 5: huluAttribute = HuluAttribute.CYAN; break;
                case 6: huluAttribute = HuluAttribute.BLUE; break;
                case 7: huluAttribute = HuluAttribute.PURPLE; break;
                default: huluAttribute = null; assert(false);
            }
            creatures[i]  = new Huluwa(i + 1, huluAttribute);
        }
    }


    public void LineUpRandomly() //任意站队
    {
        int[] array = new int[]{0, 1, 2, 3, 4, 5, 6};
        int i, rand;
        for (i = 6; i >= 0; i--) {
            java.util.Random random = new java.util.Random();// 定义随机类
            rand = random.nextInt(i + 1);// 返回[0,7)集合中的整数，注意不包括7
            if (rand != i) {
                int temp = array[i];
                array[i] = array[rand];
                array[rand] = temp;
            }
        }

        for(Creature cr :creatures)
            cr.leavePosition();
        for (i = 0; i < 7; i++)
               creatures[array[i]].setPosition(positions[i]);
    }

    public void report() //报数
    {
        int i;
        for (Position position: positions)
            position.getHolder().report(); //每个葫芦娃依次报数
        System.out.println();
    }

}
