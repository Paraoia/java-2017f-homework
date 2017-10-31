package maps;

import creatures.*;
import creatures.Evil;
import creatures.GrandPa;
import creatures.Huluwa;
import positions.TwoDimPosition;

public class Map {

    private TwoDimPosition[][] positions;
    private int MapWidth;

    public TwoDimPosition[][] getPositions() {
        return positions;
    }

    public Map(int width){
        this.MapWidth = width;
        this.positions = new TwoDimPosition[MapWidth][MapWidth];
        for(int i=0;i<=this.MapWidth-1;i++){
            for(int j=0;j<=this.MapWidth-1;j++) {
                this.positions[i][j] = new TwoDimPosition(i,j);
            }
        }
    }

    public int getMapWidth() {

        return MapWidth;
    }

    public void paintMap() {

        for(int i=0 ; i<=MapWidth-1;i++) {
            for(int j=0 ; j<=MapWidth-1;j++){
                if(positions[i][j].isEmpty())
                    System.out.print("*  ");
                else if(positions[i][j].getHolder() instanceof Huluwa)
                    System.out.print(((Huluwa) positions[i][j].getHolder()).getColor().toString()+" ");
                else if(positions[i][j].getHolder() instanceof Evil){
                    if(((Evil) positions[i][j].getHolder()).getName() == EVILNAME.蝎子精)
                        System.out.print("蝎"+" ");
                    else if(((Evil) positions[i][j].getHolder()).getName() == EVILNAME.蛤蟆怪)
                        System.out.print("蛙"+" ");
                    else if(((Evil) positions[i][j].getHolder()).getName() == EVILNAME.蛇精)
                        System.out.print("蛇"+" ");
                }
                else if(positions[i][j].getHolder() instanceof GrandPa)
                    System.out.print("爷"+" ");
                else;
            }
            System.out.print("\n");
        }
    }
}
