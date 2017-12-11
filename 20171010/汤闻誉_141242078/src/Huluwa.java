public class Huluwa extends Creature implements Comparable{
    private SENIORITY seniority;
    public SENIORITY getSeniority() {
        return seniority;
    }
    Huluwa(SENIORITY seiority) {
        this.seniority = seiority;
    }

    @Override
    public void report(){
        System.out.print(this.seniority.toString()+"  ");
    }

    @Override
    public boolean biggerThan(Comparable brother){
        if (brother instanceof  Huluwa)
            return this.getSeniority().ordinal()> ((Huluwa) brother).getSeniority().ordinal();
        else
            return false;
    }

    @Override
    public boolean lessThan(Comparable brother){
        if (brother instanceof  Huluwa)
            return this.getSeniority().ordinal()< ((Huluwa) brother).getSeniority().ordinal();
        else
            return false;
    }

}
enum SENIORITY {
    大娃, 二娃, 三娃, 四娃, 五娃, 六娃, 七娃
}