public class EmbattleSort implements Sorter {

    @Override
    public void sort(Creature []creatures, Map map, int... type) {

        if (type.length == 0)
            ChangSheembattle(creatures, map);
        else {
            switch(type[0]) {
                case 0: ChangSheembattle(creatures, map); break;
                case 1: HeYiembattle(creatures, map); break;
                case 2: FengShiembattle(creatures, map); break;
            }
        }

    }

    /**
     *  a series of temple solution
     */

    void ChangSheembattle(Creature []creatures, Map map) {

        int startX = map.getMaxX()/2 + 1, startY = map.getMaxY()/2, startZ = map.getMaxZ()/2;

        for (int i = 0 ; i < creatures.length; i++) {

            Position position = new Position3D(startX, startY, startZ);
            creatures[i].moveto(map, position);
            startX++;

        }

    }

    void HeYiembattle(Creature []creatures, Map map) {

        int startX = map.getMaxX()/2 - 2, startY = map.getMaxY()/2, startZ = map.getMaxZ()/2;

        int acnum = 0;

        for (int i = 0; i < creatures.length;) {

            Position position1 = new Position3D(startX, startY - acnum, startZ);
            creatures[i].moveto(map, position1);
            i++;

            if (i != 1 && i < creatures.length) {

                Position position2 = new Position3D(startX, startY + acnum, startZ);
                creatures[i].moveto(map, position2);
                i++;

            }

            acnum++;
            startX--;

        }

    }

    void FengShiembattle(Creature []creatures, Map map) {

        int startX = map.getMaxX()/2 - 2, startY = map.getMaxY()/2, startZ = map.getMaxZ()/2;
        int halfnum = creatures.length/2;
        int acnum = 1;
        boolean out = false;

        Position position0 = new Position3D(startX, startY, startZ);
        creatures[0].moveto(map, position0);

        for (int i = 1; i < halfnum;) {

            Position position1 = new Position3D(startX - acnum, startY - acnum, startZ);
            creatures[i].moveto(map, position1);
            i++;

            if (i >= halfnum)
                out = true;
            if (i >= creatures.length)
                return;

            Position position2 = new Position3D(startX - acnum, startY + acnum, startZ);
            creatures[i].moveto(map, position2);
            i++;

            acnum++;

        }

        if (out)
            halfnum++;

        startX--;

        for (int i = halfnum; i < creatures.length;) {

            Position position = new Position3D(startX, startY, startZ);
            creatures[i].moveto(map, position);
            i++;
            startX--;

        }

    }

}

