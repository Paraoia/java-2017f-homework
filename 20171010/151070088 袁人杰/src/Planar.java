import java.util.Random;

public class Planar{
    private int planarSize;
    private Grid[][] grids;

    public Grid getGridOF(int x,int y) {
        return grids[x][y];
    }

    public Planar(int size) {
        this.planarSize =size;
        this.grids = new Grid[size][size];

        for (int i=0;i<size;i++){
            for (int j=0;j<size;j++){
                this.grids[i][j]=new Grid(i,j);
            }

        }
    }

    public int getPlanarSize() {
        return planarSize;
    }

    public void cleanPlanar(){
        for(int i = 0; i< planarSize; i++){
            for (int j = 0; j< planarSize; i++){
                grids[i][j].setHolder(null);
            }
        }
    }

    public void printPlanar(){
        for(int i=0;i<planarSize;i++){
            for (int j=0;i<planarSize;j++){
                if(grids[i][j].isOccupied()){
                    System.out.println(grids[i][j].getHolder().getName()+" ");
                }
                else
                    System.out.println("    ");
            }
        }

    }

    /*public static void main(String[] args) {
        Planar planar = new Planar(15);

        Huluwa[] bros = new Huluwa[7];
        for (int i=0;i<bros.length;i++){
            bros[i] = new Huluwa(Huluwa.COLOUR.values()[i], Huluwa.SENIORITY.values()[i]);
        }

        Queue HuluQueue = new Queue(bros.length);
        for (int i=0;i<bros.length;i++){
            HuluQueue.enQueue(bros[i]);
        }

        for (int i=0;i<bros.length;i++) {
            bros[i].setGrid(planar.grids[0][i]);
        }
        planar.arrRandom(bros);

        Sorter sorter = new Sorter();
        //sorter.bubbleSort(planar.grids[0]);
        sorter.bubbleSort(HuluQueue);
        for (int i=0;i<bros.length;i++){
            HuluQueue.getGrid(i).getHolder().report();
        }

        for (int i=0;i<bros.length;i++) {
            bros[i].setGrid(planar.grids[i][0]);
        }

        System.out.println();
        System.out.flush();


    }*/


}
