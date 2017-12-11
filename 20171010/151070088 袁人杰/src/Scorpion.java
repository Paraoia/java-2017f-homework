public class Scorpion extends Villain{
    //private LEVEL yourlevel;
    private String Name="蝎子";
    private int Seniority;

    public Scorpion(LEVEL level,int seniority) {
        this.yourLevel=level;
        this.Seniority=seniority;
    }

    public int getSeniority() {
        return Seniority;
    }

    public LEVEL getYourlevel() {
        return yourLevel;
    }

    public String getName() {
        return Name;
    }

    public void setSeniority(int seniority) {
        Seniority = seniority;
    }

    @Override
    public void report() {
        System.out.print(this.toString());
    }

    @Override
    public String toString() {
        return this.Name.toString()+this.Seniority+this.yourLevel.toString()+"@grid("+ grid.getX()+","+ grid.getY()+")";
    }

}
