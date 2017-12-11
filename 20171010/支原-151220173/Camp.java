public class Camp {
    protected Position[] positions;
    protected  Creature[] creature;
    protected int sum;
    public void ChooseQueue(Queue q)
    {

        this.sum=q.num;
        positions=q.positions;
        //creature=new Creature[sum];
        for(int i=0;i<sum;i++)
        {

            positions[i].setHolder(creature[i]);
            creature[i].setPos(positions[i]);

        }

    }

}
