import java.util.ArrayList;
import java.util.Collections;

enum Direction{
    北, 东, 南, 西
};

public class Formation {
    Direction formDirection;
    Integer width, height;
    ArrayList<priorityPosition> Dots = new ArrayList<priorityPosition>();

    Formation(FormRecord formRecord){
        this.formDirection = formRecord.getFormOri();
        this.width = formRecord.getWidth();
        this.height = formRecord.getHeight();
        String[] dots = formRecord.getFormDot();
        for (Integer i = 0; i < dots.length; i++){
            for (Integer j = 0;  j < dots[i].length(); j++){
                if (dots[i].charAt(j) != '0')
                    Dots.add(new priorityPosition(j, i, Character.getNumericValue(dots[i].charAt(j))));
            }
        }
        Collections.sort(Dots);
    }


    public void lineUp(ArrayList<Creature> creatures, Position leftUp, Direction campDirection){
        //TODO: throw exception



        int diff = campDirection.ordinal() - formDirection.ordinal();
        diff = diff < 0 ? diff + 4 : diff;
        double theta = Math.toRadians(diff*90);
//        System.out.println("diff = " + diff);
        if(theta != 0) {
            Long arr[][] = new Long[][]{
                    {Math.round(Math.cos(theta)), Math.round(Math.sin(theta))},
                    {Math.round(-Math.sin(theta)), Math.round(Math.cos(theta))}
            };
            for (priorityPosition p :
                    Dots) {
                Integer newx = (int) Math.round(p.getX() * arr[0][0] + p.getY() * arr[1][0]);
                Integer newy = (int) Math.round(p.getX() * arr[0][1] + p.getY() * arr[1][1]);
                p.setX(newx);
                p.setY(newy);
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
                for (priorityPosition p : Dots) {
                    Integer newx = p.getX() + xPlus;
                    Integer newy = p.getY() + yPlus;
                    p.setX(newx);
                    p.setY(newy);
                }

            }
            else {
                for (priorityPosition p : Dots) {
                    Integer newx = p.getX() + height;
                    p.setX(newx);
                }
            }
        }

        for (Integer c = 0, d = 0; c < creatures.size() && d < Dots.size(); c++, d++){
            Creature creature = creatures.get(c);
            Position p = new Position(leftUp.getX(), leftUp.getY());
            p.add(Dots.get(d));
            creature.setPositon(p);
            creatures.set(c, creature);
        }

        if (creatures.size() > Dots.size()){
            Position p = new Position(leftUp.getX(), leftUp.getY());
            p.add(Dots.get(Dots.size()-1));
            for (Integer c = Dots.size(); c < creatures.size(); c++ ){
                Creature creature = creatures.get(c);
                creature.setPositon(p);
                creatures.set(c, creature);
            }
        }
    }


    public void setOriginDirection(Direction formDirection) {
        this.formDirection = formDirection;
    }

    public void setWidth(Integer width) {
        this.width = width;
    }

    public void setHeight(Integer height) {
        this.height = height;
    }

    public void setDots(ArrayList<priorityPosition> dots) {
        Dots = dots;
    }

    public Direction getOriginDirection() {
        return formDirection;
    }

    public Integer getWidth() {
        return width;
    }

    public Integer getHeight() {
        return height;
    }

    public ArrayList<priorityPosition> getDots() {
        return Dots;
    }

    public void rotate(){
        ;
    }


}

class priorityPosition extends Position implements Comparable<priorityPosition>{
    Integer priority;

    priorityPosition(Integer x, Integer y, Integer priority){
        super(x, y);
        this.priority = priority;
    }

    @Override
    public int compareTo(priorityPosition arg0){
        return this.priority.compareTo(arg0.priority);
    }

    static public boolean less(priorityPosition p1, priorityPosition p2){
        return p1.priority > p2.priority;
    }

    static public boolean greater(priorityPosition p1, priorityPosition p2){
        return p1.priority < p2.priority;
    }

}

