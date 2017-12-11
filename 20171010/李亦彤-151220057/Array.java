public class Array {

    final static int N=16;
    private Position[][] positions;
    //int num;
    public Array()
    {
        positions=new Position[N][N];
        for(int i=0;i<N;i++)
        {
            for(int j=0;j<N;j++)
            {
                positions[i][j]=new Position();
            }
        }
    }

    public void SetQueue(Queue q)
    {
        for (int i = 0; i < q.getPositions().length; i++) {

            int x= q.getPositions()[i].getX();
            int y= q.getPositions()[i].getY();
            positions[x][y]=new Position(x,y);
            q.getPositions()[i].getHolder().setPosition(positions[x][y]);
        }
    }
    public void switch_array(BudsAndScor_queue q)
    {
        for(int i=0;i<N;i++)
        {
            for(int j=0;j<N;j++)
            {
                if(positions[i][j].getHolder() instanceof Scorpion | positions[i][j].getHolder() instanceof Buddy| positions[i][j].getHolder() instanceof Grandpa| positions[i][j].getHolder() instanceof Snake)
                    positions[i][j]=new Position();
            }
        }
        SetQueue(q);
    }
    public void show(){
        for (int i=0;i<N;i++) {
            for (int j=0;j<N;j++) {
                if(positions[i][j].getX()!=-1)
                    positions[i][j].getHolder().report();
                else
                    System.out.print("          \t");
            }
            System.out.println("\n");
        }

        System.out.println("\n");
        //System.out.flush();
    }
    public void rollCall() {
        for (int i=0;i<N;i++) {
            for (int j=0;j<N;j++) {
                if(positions[i][j].getX()!=-1)
                    positions[i][j].getHolder().report();
            }
        }

        System.out.println("\n");
        //System.out.flush();
    }
    private void set_creature(Creature c)
    {
        int x=0,y=0;
        if(c instanceof Grandpa) {
            for(int i=0;i<N;i++)
            {
                for(int j=N-1;j>N/2;j--)
                {
                    if(positions[i][j].getX()==-1)
                    {
                        x=i;
                        y=j;
                        this.positions[x][y] = new Position(x, y);
                        c.setPosition(this.positions[x][y]);
                        return;
                    }
                }
            }
        }
        else if(c instanceof Snake){
            for(int i=0;i<N;i++)
            {
                for(int j=0;j<N/2;j++)
                {
                    if(positions[i][j].getX()==-1)
                    {
                        x=i;
                        y=j;
                        this.positions[x][y] = new Position(x, y);
                        c.setPosition(this.positions[x][y]);
                        return;
                    }
                }
            }
        }

    }
    public static void main(String[] args) {

        Scorpion scorpion = new Scorpion();
        Snake snake = new Snake();
        Grandpa grandpa = new Grandpa();
        Huluwa[] brothers = new Huluwa[7];
        Buddy[] buddies = new Buddy[7];
        for (int i = 0; i < brothers.length; i++) {
            brothers[i] = new Huluwa(COLOR.values()[i], SENIORITY.values()[i]);
        }
        for (int i = 0; i < buddies.length; i++) {
            buddies[i] = new Buddy(i);
        }

        Huluwa_queue h_queue = new Huluwa_queue(brothers);
        h_queue.shuffle();
        h_queue.rollCall();
        System.out.println("葫芦娃站队");
        new InsertionSorter().sort(h_queue);
        h_queue.rollCall();
        System.out.println("\n");
        System.out.println("蝎子精带小喽啰站队");
        BudsAndScor_queue b_queue = new BudsAndScor_queue(buddies, scorpion);
        b_queue.rollCall();
        System.out.println("\n");
        Array array = new Array();
        array.SetQueue(h_queue);
        array.SetQueue(b_queue);
        array.set_creature(grandpa);
        System.out.println("爷爷助威");
        grandpa.report();
        System.out.println("\n");
        array.set_creature(snake);
        System.out.println("蛇精助威");
        snake.report();
        System.out.println("\n");
        //array.rollCall();
        System.out.println("对峙局面-------------------------------------------------------------");
        array.show();
        System.out.println("\n");


        System.out.println("蝎子精带小喽啰变换阵法");
        b_queue.Heyi();
        b_queue.rollCall();
        System.out.println("\n");
        array.switch_array(b_queue);
        array.set_creature(grandpa);
        System.out.println("爷爷助威");
        grandpa.report();
        System.out.println("\n");
        array.set_creature(snake);
        System.out.println("蛇精助威");
        snake.report();
        System.out.println("\n");
        System.out.println("对峙局面-------------------------------------------------------------");
        array.show();
    }
}
