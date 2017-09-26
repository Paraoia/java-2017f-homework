/**
 * This class defines Huluwa.
 */

public class Huluwa {
    private Global.NAME name;
    private Global.COLOR color;
    private int position;

    public Huluwa(Global.NAME name, Global.COLOR color, int position){
        this.name = name;
        this.color = color;
        this.position = position;
    }

    public Global.NAME getName(){
        return name;
    }
    public Global.COLOR getColor(){
        return color;
    }
    public int getPosition(){
        return position;
    }

    public void jumpFromTo(int i, int j){
        System.out.println(name + ":\t" + i + "->" + j);
    }
    public void countOff(int kind){
        if(0==kind)
            System.out.println(name);
        else if(1==kind)
            System.out.print(color);
    }
}
