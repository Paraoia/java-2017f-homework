public class Gourd {
    public int age;
    public int position;
    public String name;
    public String color;

    public Gourd(int Age,int Position,String Name,String Color){
        age=Age;
        position=Position;
        name=Name;
        color=Color;
    }
    public void ChangePosition(int NewPosition){
        System.out.println(name+":"+position+"->"+(NewPosition+1));
        position = NewPosition + 1;
    }
}
