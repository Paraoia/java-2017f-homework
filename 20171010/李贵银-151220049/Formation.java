public interface Formation {
    /*private Position leader;
    Formation(Position leader)
    {
        this.leader=new Position(leader.getX(),leader.getY());
    }
    public void makeFormation(Position []shape)
    {
        Creature []c;
        for(int i=0;i<shape.length;i++)
        {
           c[i]=new Loulu("loulu");
           c[i].setPosition(shape[i]);
         }
    }
    */
    public void Do(int x,int y,Space s,Creature []creatures,int length);
    //（x,y)为队形里的第一个
}

