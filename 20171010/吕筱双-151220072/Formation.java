import javax.swing.plaf.PanelUI;

public class Formation {
    private Position[] positions;

    public Position[] getPositions() {
        return positions;
    }

    public Formation(int num){
        this.positions = new Position[num];
        for(int i = 0 ; i < num ; i++){
                this.positions[i] = new Position(0, 0);
        }
    }
    public Formation GoGoGo(){
        positions[0].setPositon(0,0);
        positions[1].setPositon(0,1);
        return this;
    }

    public Formation HeYi() {
        int num= positions.length;
        this.positions[0].setPositon( num / 2,0);
        for (int i = 1, j = 1; i < num; i ++) {
            switch(i%2){
                case 0:
                    positions[i].setPositon(num / 2 + j,j);j++;break;
                case 1:
                    positions[i].setPositon(num / 2 - j,j);break;
            }

        }
        return this;
    }

    public Formation YanXing() {
        int num = positions.length;
        for (int i = num - 1, j = 1; i >= 0; i--, j++) {
            positions[j - 1].setPositon(i, j);
        }
        return this;
    }

    public Formation ChongE() {
        int num = positions.length;
        for (int i = 0, j = 0; i < num; i ++, j++) {
            int z = j % 2 == 0 ? 1 : 0;
            switch(i%3) {
                case 0:
                    positions[i].setPositon(j, z);
                case 1:
                    positions[i].setPositon(j, z + 2);
                case 2:
                    positions[i].setPositon(j, z + 2);
            }
        }
        return  this;
    }

    public Formation YuLin(){
        int num = positions.length;
        double max = Math.sqrt(num*2);

        int z = 0;
        for(int i =0; i < max&&z < positions.length;i++){
            for(int j = 0;j <=i&&z < positions.length;j++,z++){
                positions[z].setPositon(i,(int)(max - j)+i-j);
            }
        }

        positions[2].setPositon((int)max,positions[0].getY());
        return this;
    }

}
