package HuluwaGo;

import java.util.Random;

public class Queue {

    private Position[] positions;
    private Creature[] creatures;
    private Sorter sorter;

    enum QueueType{鹤翼, 雁行, 冲轭, 长蛇, 鱼鳞, 方门, 偃月, 锋矢}

    private int[][] getTable(QueueType queueType, int x, int y){
        int[][] table = null;

        switch(queueType){
            case 偃月:
                //creatures.length should be 19
                table = new int[][]{
                        {x, y},
                        {x-1, y-1},
                        {x-1, y-3},
                        {x-2, y-2},
                        {x-2, y-4},
                        {x-3, y-3},
                        {x-3, y-5},
                        {x-3, y-7},
                        {x-4, y-3},
                        {x-4, y-5},
                        {x-4, y-7},
                        {x-5, y-3},
                        {x-5, y-5},
                        {x-5, y-7},
                        {x-6, y-2},
                        {x-6, y-4},
                        {x-7, y-1},
                        {x-7, y-3},
                        {x-8, y},
                };
                break;
            case 冲轭:
                //creatures.length should be 6
                table = new int[][]{
                        {x, y},
                        {x-1, y+1},
                        {x-2, y},
                        {x-3, y+1},
                        {x-4, y},
                        {x-5, y+1}
                };
                break;
            case 方门:
                //creatures.length should be 8
                table = new int[][]{
                        {x, y},
                        {x-1, y-1},
                        {x-1, y+1},
                        {x-2, y-2},
                        {x-2, y+2},
                        {x-3, y-1},
                        {x-3, y+1},
                        {x-4, y},
                };
                break;
            case 锋矢:
                //creatures.length should be 12
                table = new int[][]{
                        {x, y},
                        {x-2, y},
                        {x-4, y},
                        {x-5, y-4},
                        {x-5, y+4},
                        {x-6, y},
                        {x-7, y-3},
                        {x-7, y+3},
                        {x-8, y},
                        {x-9, y-2},
                        {x-9, y+2},
                        {x-10, y},
                };
                break;
            case 长蛇:
                //creatures.length should be 7
                table = new int[][]{
                        {x, y},
                        {x-1, y},
                        {x-2, y},
                        {x-3, y},
                        {x-4, y},
                        {x-5, y},
                        {x-6, y}
                };
                break;
            case 雁行:
                //creatures.length should be 5
                table = new int[][]{
                        {x, y},
                        {x-1, y+1},
                        {x-2, y+2},
                        {x-3, y+3},
                        {x-4, y+4}
                };
                break;
            case 鱼鳞:
                //creatures.length should be 10
                table = new int[][]{
                        {x, y},
                        {x-1, y-3},
                        {x-1, y-1},
                        {x-1, y+1},
                        {x-1, y+3},
                        {x-2, y-2},
                        {x-2, y},
                        {x-2, y+2},
                        {x-3, y+1},
                        {x-4, y}
                };
                break;
            case 鹤翼:
                //creatures.length should be 7
                table = new int[][]{
                        {x, y},
                        {x-1, y-1},
                        {x-1, y+1},
                        {x-2, y-2},
                        {x-2, y+2},
                        {x-3, y-3},
                        {x-3, y+3}
                };
                break;
            default: break;
        }

        return table;
    }

    public Queue(Creature[] creatures, QueueType queueType, Position start) {
        this.creatures = creatures;
        this.positions = new Position[creatures.length];

        int[][] table = getTable(queueType, start.getX(), start.getY());

        for (int i = 0; i < positions.length; i++) {
            this.positions[i] = new Position(table[i][0], table[i][1]);
            positions[i].setHolder(creatures[i]);
        }

    }

    public Position[] getPositions() {
        return positions;
    }

    public void showHuluWasByOrder(){
        System.out.println("葫芦兄弟报排行：");
        for(Position p : positions){
            ((Huluwa)p.getHolder()).sayOrderName();
            System.out.print(" ");
        }
        System.out.println();
    }

    public void showHuluWasByColor(){
        System.out.println("葫芦兄弟报颜色：");
        for(Position p : positions){
            ((Huluwa)p.getHolder()).sayColorName();
            System.out.print(" ");
        }
        System.out.println();
    }

    //接下来的方法有关代理类Sorter

    //设置代理类Sorter类型
    public void setSorter(Sorter sorter){
        this.sorter = sorter;
    }

    //使用代理类进行排序
    public void sort(){
        if(sorter == null){
            System.out.println("未指定排序器类型！未进行排序！");
            return;
        }
        sorter.sort(this);
    }

    //葫芦兄弟进行随意站队
    public void chaos(){
        System.out.println("葫芦兄弟进行随意站队！");
        Random random = new Random();
        for(int i = 0; i < 10; i++) {
            int index1 = random.nextInt(positions.length);
            int index2 = random.nextInt(positions.length);
            swap(positions[index1], positions[index2]);
        }
        System.out.println("葫芦兄弟随意站队完成！");
    }

    protected void swap(Position position1, Position position2){
        if(position1.equals(position2)) return;

        Creature tmp = position1.getHolder();
        position1.setHolder(position2.getHolder());
        position2.setHolder(tmp);

    }
}




