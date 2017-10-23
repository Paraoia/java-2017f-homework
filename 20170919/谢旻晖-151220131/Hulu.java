/*
* @author Minhui Xie
* @date 20,09,2017
* @time 21:43
*/

public class Hulu {
    private int numRank;
    private String name;
    private String color;
    private int position;

    //constructor
    Hulu(int numRank,String name,String color,int position)
    {
        this.color=color;
        this.numRank=numRank;
        this.name=name;
        this.position=position;
    }

    //show out my rank
    int getNumRank()
    {
        return numRank;
    }


    //let huluwa echo
    void echo() {
        System.out.println("I'm "+name);
        System.out.println("My color is "+color);
    }

    //let huluwa change his position and shout pre -> after
    void changePosition(int aim){
        System.out.println(name+":"+position+"->"+aim);
        position=aim;
    }

    void setPosition(int position) {
        this.position = position;
    }
}
