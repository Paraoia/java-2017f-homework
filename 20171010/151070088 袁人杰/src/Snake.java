public class Snake extends Villain {
    private NAME yourName;
    //private LEVEL yourlevel;
    private Grid grid;

    public Snake(NAME name,LEVEL level) {
        this.yourName=name;
        this.yourLevel=level;
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
    public void report() {
        System.out.print(this.toString());
    }

    @Override
    public String toString() {
        return this.yourName.toString() +this.yourLevel.toString()+ "@grid(" + grid.getX() + "," + grid.getY() + ")";
    }

    @Override
    public String getName() {
        return "蛇精";
    }

    enum NAME {
        金蛇精(1),青蛇精(2);
        private int sNum =0;

        private NAME(int _sNum) { this.sNum = _sNum;}

        public int toNumber() {
            return this.sNum;
        }

    }
}
