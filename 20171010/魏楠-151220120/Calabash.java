public class Calabash extends Creature{
    private COLOR color;
    private SENIORITY seniority;
    Calabash(COLOR color, SENIORITY seniority) {
        this.color = color;
        this.seniority = seniority;
    }

    public SENIORITY getSeniority() {
        return seniority;
    }

    public void report() {
        System.out.println(this.toString());
    }

    @Override
    public String toString() {
        return this.seniority.toString() + "(" +this.color.toString() + ")" + " @" + this.getPosition().toString();
    }
    @Override
    public boolean Greater(Creature brother) {
        if(brother instanceof Calabash)
            return this.getSeniority().ordinal() > ((Calabash) brother).getSeniority().ordinal();
        else
            return false;
    }
}

enum COLOR {
    赤, 橙, 黄, 绿, 青, 蓝, 紫
}

enum SENIORITY {
    老大, 老二, 老三, 老四, 老五, 老六, 老七
}