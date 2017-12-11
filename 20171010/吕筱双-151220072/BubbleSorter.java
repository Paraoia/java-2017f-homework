import com.sun.org.apache.xalan.internal.xsltc.dom.CachedNodeListIterator;

import java.util.Arrays;

public class BubbleSorter implements Sorter {
    @Override
    public void sort(Matrix matrix) {
       Position[][]positions = matrix.getPositions();

        //将葫芦娃放在最右列
        int brotherQueueNum = 0;

        Creature creature = null;

       for(int i = 0; i < positions.length ;i++) {
            for (int j = 1; j < positions[i].length; j++) {
                if (positions[i][j].getHolder() instanceof Calabash ) {
                       // System.out.println("brotherQueueNum" + brotherQueueNum + ((Calabash) positions[i][j].getHolder()).getName());
                        if (positions[brotherQueueNum][0].getHolder() == null) {
                           // positions[i][j].getHolder().setPosition(positions[brotherQueueNum][0]);
                            positions[brotherQueueNum][0].setHolder(positions[i][j].getHolder());
                            positions[i][j].cleanHolder();
                        }
                        else{
                            while(positions[brotherQueueNum][0].getHolder() instanceof Calabash)
                                brotherQueueNum++;
                            Creature temp = positions[brotherQueueNum][0].getHolder();
                            positions[brotherQueueNum][0].setHolder(positions[i][j].getHolder());
                            positions[i][j].setHolder(temp);

                        }
                    brotherQueueNum++;
                }

            }
        }

        for(int i = 0,count = 0; i < positions.length&&count < 7;i++){
            if(positions[i][0].getHolder() instanceof Calabash)
                count++;
            else {
                for(int t= i+1; t < positions.length;t++){
                    if(positions[t][0].getHolder() instanceof Calabash){
                        Creature temp = positions[i][0].getHolder();
                        positions[i][0].setHolder(positions[t][0].getHolder());
                        positions[t][0].setHolder(temp);
                    }
                }
                count++;
            }
        }

        for(int i = 0; i < 6;i++){
            for(int j = 0 ; j < 6-i;j++){
                if(((Comparable)(positions[j][0].getHolder())).biggerThan((Comparable) positions[j+1][0].getHolder()))
                {
                    Creature temp = positions[j][0].getHolder();
                    positions[j][0].setHolder(positions[j+1][0].getHolder());
                    positions[j+1][0].setHolder(temp);

                }
            }
        }

        for(int i= 0; i < 7;i++){
            matrix.getCreatures()[i].setPosition(positions[i][0]);
            //System.out.println(matrix.getCreatures()[i].getName()+matrix.getCreatures()[i].getPosition().getX()+"  "+matrix.getCreatures()[i].getPosition().getY());
        }

    }

}
