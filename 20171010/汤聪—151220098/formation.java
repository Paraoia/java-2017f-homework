package huluwa;

import com.sun.org.apache.xpath.internal.operations.String;

public class formation extends sort{
    public position[][] position;
    public int n;
    public xiezi xiezijing = new xiezi("蝎子精");
    public snake shejing=new snake("蛇精");
    public oldman grandpa=new oldman("老爷爷");
    public luoluo[] little;
    formation(int k)
    {
        this.n=k;
        this.position=new position[n][n];
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<n;j++) {
                this.position[i][j] = new position();
                position[i][j].holder = new creature();
            }
        }
        int i=0;
        little = new luoluo[6] ;
        for(;i<6;i++)
        {
            little[i]=new luoluo("啰咯");
        }
    }
    public void changeformation(int i)
    {
        switch(i)
        {
            case 1:
            {
                heyi();
                new_huluwa[] bros=new new_huluwa[7];
                sort p1=new sort();
                p1.set_random();
                p1.init(bros);
                p1.bubblesort();
               // huluwaqueue.bubblesort();
                for(int j=0;j<7;j++)
                    position[j][7].holder=p1.positions[j].newholder;
                break;
            }
            case 2:
            {
                burenshi();
                new_huluwa[] bros=new new_huluwa[7];
                sort p1=new sort();
                p1.set_random();
                p1.init(bros);
                p1.bubblesort();
                for(int j=0;j<7;j++)
                    position[j][6].holder=p1.positions[j].newholder;
                break;
            }
        }
    }
    public void heyi()
    {
        position[0][0].holder=little[0];
        position[6][0].holder=little[1];
        position[1][1].holder=little[2];
        position[5][1].holder=little[3];
        position[2][2].holder=little[4];
        position[4][2].holder=little[5];
        position[3][3].holder=xiezijing;
        position[3][4].holder=shejing;
        position[3][6].holder=grandpa;
    }
    public void burenshi()
    {
        position[0][1].holder=little[0];
        position[1][0].holder=little[1];
        position[6][1].holder=little[2];
        position[3][0].holder=little[3];
        position[4][1].holder=little[4];
        position[5][0].holder=little[5];
        position[2][1].holder=xiezijing;
        position[2][3].holder=shejing;
        position[2][5].holder=grandpa;
    }
    public void printformation()
    {
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<n;j++)
            {
                System.out.print(position[i][j].holder.name);
            }
            System.out.println();
        }
    }
}