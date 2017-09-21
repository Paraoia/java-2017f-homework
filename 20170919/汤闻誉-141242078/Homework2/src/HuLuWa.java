public class HuLuWa {
    String name;
    String color;
    Integer value;
    HuLuWa(String name,String color,Integer value){
        this.name=name;
        this.color=color;
        this.value=value;
    }

    void tellName(){
        System.out.print(name+"  ");
    }
    void tellColor(){
        System.out.print(color+"  ");
    }
 /*
    void move(Integer newPosition){
        if(position==newPosition)return;
        System.out.println(position+"->"+newPosition);
        position=newPosition;
    }
*/
    public Integer getValue() {
        return value;
    }


}
