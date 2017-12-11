public class Huluwa extends Creature implements Comparable, Active {
    private COLOR color;
    private SENIORITY seniority;

    Huluwa(COLOR color, SENIORITY seniority){
        super(seniority.toString());
        this.color = color;
        this.seniority = seniority;
    }

    public COLOR getColor(){
        return this.color;
    }

    public SENIORITY getSeniority() {
        return this.seniority;
    }

    @Override
    public boolean biggerThan(Comparable brother){
        if(brother instanceof Huluwa)
            return this.getSeniority().ordinal() > ((Huluwa) brother).getSeniority().ordinal();
        else
            return false;
    }

    @Override
    public void act(){
        System.out.println("呔,妖怪受死!");
    }

}

enum COLOR{
    赤,橙,黄,绿,青,蓝,紫
}

enum SENIORITY{
    一,二,三,四,五,六,七
}
