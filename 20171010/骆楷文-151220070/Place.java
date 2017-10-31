public class Place {
    public int[][] coord;
    public int length;

    Place(int type){
        switch (type){
            case 1:
                int[][] temp1 = new int[][]{
                        {0,0}, {1,-1}, {1,1}, {2,-2}, {2,2}, {3,-3},
                        {3,3}, {4,-4}, {4,4}, {5,-5}, {5,5}, {6,-6}, {6,6},
                        {7,-7}, {7,7}, {8,-8}, {8,8}, {9,-9}, {9,9}, {10,-10}
                };
                coord = temp1;
                length = 20;
                break;
            case 2:
                int [][] temp2 = new int[][]{
                        {0,0},{1,1},{2,2},{3,3},{4,4},{5,5},{6,6},
                        {7,7},{8,8},{9,9}
                };
                coord = temp2;
                length = 10;
                break;
            case 3:
                int [][] temp3 = new int[][]{
                        {0,0},{1,-1},{2,0},{3,-1},{4,0},
                        {5,-1},{6,0},{7,-1},{8,0},{9,-1}
                };
                coord = temp3;
                length = 10;
                break;
            case 4:
                int [][] temp4 = new int[][]{
                        {0,0},{1,0},{2,0},{3,0},{4,0},
                        {5,0},{6,0},{7,0},{8,0},{9,0}
                };
                coord = temp4;
                length = 10;
                break;
            case 5:
                int [][] temp5 = new int[][]{
                        {0,0},{1,1},{2,2},{2,0},{2,-2},
                        {3,3},{3,1},{3,-1},{3,-3},{4,0}
                };
                coord = temp5;
                length = 10;
                break;
            case 6:
                int [][] temp6 = new int[][]{
                        {0,0},{1,1},{1,-1},{2,2},{2,-2},
                        {3,2},{3,-2},{4,1},{4,-1},{5,0}
                };
                coord = temp6;
                length = 10;
                break;
            case 7:
                int [][] temp7 = new int[][]{
                        {0,0},{0,1},{0,-1},{1,0},{1,1},
                        {1,-1},{2,0},{2,1},{2,-1},{2,2},
                        {2,-2},{3,0},{3,2},{3,-2},{3,3},
                        {3,-3},{4,3},{4,-3},{5,4},{5,-4}
                };
                coord = temp7;
                length = 20;
                break;
            case 8:
                int [][] temp8 = new int[][]{
                        {0,0},{1,0},{2,0},{1,1},{1,-1},
                        {3,0},{2,2},{2,-2},{4,0},{3,3},
                        {3,-3}, {5,0}
                };
                coord = temp8;
                length = 12;
                break;
            default:coord = null;length = 0;break;
        }
    }
}

