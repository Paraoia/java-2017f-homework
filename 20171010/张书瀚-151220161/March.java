public class March implements Constants {
    public boolean isEmpty(Position[][] positions, int line) {
        for(int i=0; i<positions[line].length;i++) {
            if(positions[line][i].isOccupy())
                return false;
        }
        return true;
    }

    public boolean isBoy(Position[][] positions, int line) {
        for(int i=0; i<positions[line].length;i++) {
            if(positions[line][i].isOccupy() && (positions[line][i].getHolder() instanceof Boy))
                return true;
        }
        return false;
    }

    public boolean isMonsters(Position[][] positions, int line) {
        for(int i=0; i<positions[line].length;i++) {
            if(positions[line][i].isOccupy() && ((positions[line][i].getHolder() instanceof Snake)
                    || (positions[line][i].getHolder() instanceof Scorpion)
                    || (positions[line][i].getHolder() instanceof Goblins)))
                return true;
        }
        return false;
    }

    public void march(Space space, Object obj, ORIENTATION orientation) {
        int adder = 0;
        if (orientation == ORIENTATION.SOUTH) {
            adder = 1;
        } else if (orientation == ORIENTATION.NORTH) {
            adder = -1;
        }
        Position[][] positions = space.getPositions();

        int Begin = 0, End = 19;
        if(obj instanceof Boy) {
            for(int i=0;i<MAXLINE;i++) {
                if (isBoy(positions, i)) {
                    Begin = End = i;
                    break;
                }
            }
        }
        else if(obj instanceof Goblins) {
            for(int i=0; i<MAXLINE;i++) {
                if (isMonsters(positions, i)) {
                    Begin = i;
                    break;
                }
            }
            for (int j=Begin;j<MAXLINE;j++) {
                if (isEmpty(positions, j)) {
                    End = j - 1;
                    break;
                }
            }
        }

        if((Begin+adder>=0) && (End+adder)<=MAXLINE) {   //没有越界
            if(isEmpty(positions, Begin+adder) || isEmpty(positions,End+adder)) {
                if(adder<0) {
                    for (int j = Begin; j <= End; j++) {
                        for (int i = 0; i < MAXROW; i++) {
                            if (positions[j][i].isOccupy()) {
                                positions[j + adder][i].setHolder(positions[j][i].getHolder());
                                positions[j + adder][i].setOccupy();
                                positions[j + adder][i].getHolder().setPos(positions[j + adder][i]);
                                positions[j][i].clearOccupy();

                            }
                        }
                    }
                }
                else {
                    for (int j = End; j >= Begin; j--) {
                        for (int i = 0; i < MAXROW; i++) {
                            if (positions[j][i].isOccupy()) {
                                positions[j + adder][i].setHolder(positions[j][i].getHolder());
                                positions[j + adder][i].setOccupy();
                                positions[j + adder][i].getHolder().setPos(positions[j + adder][i]);
                                positions[j][i].clearOccupy();

                            }
                        }
                    }
                }
            }
        }
        else {
            System.out.print("不能走出战场！\n");
        }
    }
}

enum ORIENTATION {
    NORTH, SOUTH,
}