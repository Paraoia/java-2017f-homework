import java.awt.*;
import java.util.Random;


public class Queue {

    public Position[] positions;

    public Queue() {
        positions = new Position[8];
        for (int i = 0; i < positions.length; i++) {
            positions[i] = new Position();
            positions[i].index = i;
            positions[i].holder = null;
        }
    }

    public void enqueueinrandom(Huluwa[] huluwas) {

        if (huluwas.length > this.positions.length) {
            System.out.println("Queue overflow");
            return; //actually should throw exception
        }


        int[] values=new int[7];
        Random random=new Random();
        int num=0;
        while(num<=6) {

            int number=random.nextInt(7);
            boolean exit=false;
            for(int i=0;i<num;i++)
            {
                if(number==values[i])
                    exit=true;
            }
            if(!exit)
            {
                values[num]=number;
                num++;
            }

        }

        positions[0].holder = huluwas[values[0]];
        positions[1].holder = huluwas[values[1]];
        positions[2].holder = huluwas[values[2]];
        positions[3].holder = huluwas[values[3]];
        positions[4].holder = huluwas[values[4]];
        positions[5].holder = huluwas[values[5]];
        positions[6].holder = huluwas[values[6]];


        //留个空位
        positions[7].holder = null;

        //...

    }




    public void sortinseniority() {

        Huluwa tempposition;

        for (int i = 0; i < positions.length; i++)
        {
            for (int j = 0; j < positions.length - 2; j++)
            {
                if (positions[j].holder.seniority > positions[j + 1].holder.seniority) {
                    positions[j + 1].holder.jumpto(positions, j + 1, 7);
                    positions[j].holder.jumpto(positions, j, j + 1);
                    positions[7].holder.jumpto(positions, 7, j);
                }
            }
        }
        System.out.println();
    }

    public void sortincolor(){

        quicksort(positions,0,6);
        System.out.println();
    }

    int partition(Position[] array, int p, int r)
    {
        Position x = array[r];
        int i = p - 1;

        for (int j = p; j <= r - 1; j++)
        {
            if (array[j].holder.color.ordinal() < x.holder.color.ordinal())
            {
                i++;

                if(i!=j) {
                    array[i].holder.jumpto(positions, i, 7);
                    array[j].holder.jumpto(positions, j, i);
                    array[7].holder.jumpto(positions, 7, j);
                }

            }
        }

        if(i+1!=r) {
            array[i + 1].holder.jumpto(positions, i + 1, 7);
            array[r].holder.jumpto(positions, r, i + 1);
            array[7].holder.jumpto(positions, 7, r);
        }

        return i + 1;
    }

    void quicksort(Position[] array, int p, int r)
    {
        if (p < r)
        {
            int q = partition(array, p, r);
            quicksort(array, p, q - 1);
            quicksort(array, q + 1, r);
        }
    }



    public void countoffinseniority(){
        for(int i=0;i<positions.length-1;i++)
            positions[i].holder.getseniority();
        System.out.println();
    }

    public void countoffincolor(){
        for(int i=0;i<positions.length-1;i++)
            positions[i].holder.getcolor();
        System.out.println();
    }

}

