/**
 * Created by Yuyang Wei on 2017/10/18.
 */
public class HeYiZhen implements Marshal{
    @Override
    public void marshal(Map map,Scorpion scorpion,Toad[]toads,int N){
        System.out.println("");

        Position[][]positions=map.getPositions();

        for(int i=0;i<N;i++){
            for(int j=0;j<N;j++){
                if(positions[i][j].getHolder() instanceof Scorpion||positions[i][j].getHolder() instanceof Toad){
                    positions[i][j].setHaveFalse();
                }
            }
        }
        map.putMan(7,4,scorpion);
        map.putMan(4,1,toads[0]);
        map.putMan(5,2,toads[1]);
        map.putMan(6,3,toads[2]);
        map.putMan(6,5,toads[3]);
        map.putMan(5,6,toads[4]);
        map.putMan(4,7,toads[5]);

    }
}
