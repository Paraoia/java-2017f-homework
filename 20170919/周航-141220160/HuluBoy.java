public class HuluBoy {
    String name;
    String color;
    int rank;

    HuluBoy(String name,String color,int rank){
        this.name=name;
        this.color=color;
        this.rank=rank;
    }

    void getname(){
        System.out.print(name+" ");
    }

    void getcolor(){
        System.out.print(color+" ");
    }

    int getrank(){
        return rank;
    }

}
