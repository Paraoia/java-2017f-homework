package HuLu;

public class Test {
 
    public static void main(String[] args) {
      
        Space space=new Space(16);
   
        Creature[] hulu = new Creature[7];
        for (int i = 0; i < hulu.length; i++) {
            hulu[i] = new HuLuWa(COLOR.values()[i], RANK.values()[i]);
        }
        
        Creature[] monster=new Creature[7];
        for(int i=1;i<7;i++){
            monster[i]=new Xiaolouluo();
        }
        monster[0]=new Xiezijing();
        
        Creature grandpa=new Grandpa();

        Creature shejing=new Shejing();

        Queue queue = new Queue(hulu);
        queue.messUp();
//        System.out.println("排序前葫芦娃的顺序：");
//        queue.queueShow();

        new BubbleSorter().sort(queue);
//        System.out.println("排序后葫芦娃的顺序：");
//        queue.queueShow();
        
        System.out.println("战斗开始...\n\n");
        
        new ZhenChangshe().arrange(space, 8, 1, hulu);
        new ZhenYanhang().arrange(space, 6, 1, monster);
      
        space.setCreature(grandpa,8,2);
        space.setCreature(shejing,6,2);

        System.out.println("第一回合：雁行阵法");
        space.spaceShow();
        
        space.cleanSpace();

        new ZhenChangshe().arrange(space, 7, 3, hulu);
        new ZhenHeyi().arrange(space, 4, 3, monster);
       
        space.setCreature(grandpa,7,4);
        space.setCreature(shejing,4,4);

        System.out.println("第二回合：鹤翼阵法");
        space.spaceShow();
        
       
    }
}