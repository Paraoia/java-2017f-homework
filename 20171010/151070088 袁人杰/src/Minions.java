public class Minions extends Villain {
    //private LEVEL yourlevel;
    private String Name="喽啰";
    private int Code;

    public Minions(int Code,LEVEL level) {
        this.Code=Code;
        this.yourLevel=level;
    }

    @Override
    public void report() {
        System.out.print(this.toString());
    }

    @Override
    public String toString() {
        return this.yourLevel.toString()+this.Name.toString()+this.Code+"@grid("+ grid.getX()+","+ grid.getY()+")";
    }

    @Override
    public String getName() {
        return Name;
    }
}
