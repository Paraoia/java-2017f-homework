public abstract class Villain implements Creature,Comparation{

    protected LEVEL yourLevel;
    protected Grid grid;

    public LEVEL getYourLevel() {
        return yourLevel;
    }

    @Override
    public void setGrid(Grid grid) {
        this.grid = grid;
        grid.setHolder(this);
    }

    @Override
    public Grid getGrid() {
        return grid;
    }

    @Override
    public boolean biggerThan(Comparation another) {
        if (another instanceof Villain)
            return this.getYourLevel().toNumber() > ((Villain) another).getYourLevel().toNumber();
        else
            return false;
    }

    enum LEVEL {
        Boss(1),Captain(2),Minions(3);

        private int sNum=0;

        private LEVEL(int _sNum) {
            this.sNum=_sNum;
        }

        public int toNumber() {
            return this.sNum;
        }
    }

}
