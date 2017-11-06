package Formation;

import Position.Position;
import Position.Position2D;
import Position.PriorityPosition;
import mEnums.Direction;

import java.util.ArrayList;
import java.util.Collections;

public class FormationImpl implements Formation{
    Direction direction;
    Integer width, height;
    ArrayList<PriorityPosition> Dots = new ArrayList<PriorityPosition>();

    public FormationImpl(FormRecord record){
        this.direction = record.getRecordDirection();
        this.width = record.getWidth();
        this.height = record.getHeight();
        String[] dots = record.getFormDot();
        for (Integer i = 0; i < dots.length; i++){
            for (Integer j = 0;  j < dots[i].length(); j++){
                if (dots[i].charAt(j) != '0')
                    Dots.add(new PriorityPosition(Character.getNumericValue(dots[i].charAt(j)), new Position2D(j, i)));
            }
        }
        Collections.sort(Dots);
    }


    @Override
    public void toward(Direction toDirection){
        int diff = toDirection.ordinal() - this.direction.ordinal();
        diff = diff < 0 ? diff + 4 : diff;
        double theta = Math.toRadians(diff*90);
        if(theta != 0) {
            Long arr[][] = new Long[][]{
                    {Math.round(Math.cos(theta)), Math.round(Math.sin(theta))},
                    {Math.round(-Math.sin(theta)), Math.round(Math.cos(theta))}
            };
            for (PriorityPosition p :
                    Dots) {
                Integer x = ((Position2D)p.getPosition()).getX();
                Integer y = ((Position2D)p.getPosition()).getY();
                Integer newx = (int) Math.round(x * arr[0][0] + y * arr[1][0]);
                Integer newy = (int) Math.round(x * arr[0][1] + y * arr[1][1]);
                p.setPosition(new Position2D(newx, newy));
            }
            if (diff > 1 && diff <= 3){
                Integer xPlus, yPlus;
                if (diff % 2 != 0) {
                    xPlus = height;
                    yPlus = width;
                }
                else {
                    xPlus = width;
                    yPlus = height;
                }
                for (PriorityPosition p : Dots) {
                    Integer x = ((Position2D)p.getPosition()).getX();
                    Integer y = ((Position2D)p.getPosition()).getY();
                    Integer newx = x + xPlus;
                    Integer newy = y + yPlus;
                    p.setPosition(new Position2D(newx, newy));
                }

            }
            else {
                for (PriorityPosition p : Dots) {
                    Integer x = ((Position2D)p.getPosition()).getX();
                    Integer y = ((Position2D)p.getPosition()).getY();
                    Integer newx = x + height;
                    p.setPosition(new Position2D(newx, y));
                }
            }
        }
    }

    @Override
    public ArrayList<PriorityPosition> getDots(){
        return Dots;
    }
}
