public class EnterSpace {
    /* 葫芦娃走入空间，开始站队形 */
    void huluwa_longsnakeshape(Space space, Creature[] hulubro, /*老大所占位置row与col*/ int col, int row){
        int count = 0;
        for(; count < 7; count++, row++ )
        {
            if(judge(space.GetSize(), row, col) == true)
                /* 放置葫芦娃 */
                takePosition(space.map[row][col], hulubro[count], row, col);
        }
    }

    /* 安排蝎子和啰喽站在合适位置形成雁形 */
    void sco_and_min_gooseshape(Space space, Creature sco, Creature[] min, /*蝎子精所占位置row与col*/ int col, int row){
        if(judge(space.GetSize(), row, col) == true)
            takePosition(space.map[row][col], sco, row, col);
        row++;
        col--;
        int count = 0;
        for(; count<10; count++, row++, col--){
            if(judge(space.GetSize(), row, col) == true)
                takePosition(space.map[row][col], min[count], row, col);
        }
    }

    /* 安排蝎子和啰喽站在合适位置形成箭形 */
    void sco_and_min_arrowshape(Space space, Creature sco, Creature[] min, /*蝎子精所占位置row与col*/ int col, int row){
        if(judge(space.GetSize(), row, col) == true)
            takePosition(space.map[row][col], sco, row, col);
        int r,c;
        int count = 0;
        r= row-1;
        c = col-1;
        for(; count < 2; count++, r--, c--)
            if(judge(space.GetSize(), r, c) == true)
                takePosition(space.map[r][c], min[count], r, c);
        r = row+1;
        c = col-1;
        for(; count < 4; count++, r++, c--)
            if(judge(space.GetSize(), r, c) == true)
                takePosition(space.map[r][c], min[count], r, c);
        r = row;
        c = col-1;
        for(; count < 10; count++, c--)
            if(judge(space.GetSize(), r, c) == true)
                takePosition(space.map[r][c], min[count], r, c);
    }

    /* 让爷爷站在位置(row,col)处 */
    void grandpa_stand(Space space, Creature grandpa, int col, int row){
        if(judge(space.GetSize(), row, col) == true)
            takePosition(space.map[row][col], grandpa, row, col);
    }

    /* 让蛇精站在位置(row,col)处 */
    void snake_stand(Space space, Creature snake, int col, int row){
        if(judge(space.GetSize(), row, col) == true)
            takePosition(space.map[row][col], snake, row, col);
    }

    /* 判断位置(row,col)是否超出空间范围 */
    boolean judge(int N, int row, int col){
        if(row<N && col<N)
            return true;
        else{
            System.out.println("位置("+row+","+col+")超出空间范围，放置失败");
            return false;
        }
    }

    /* 功能：在某一位置position上放上生物，位置坐标为(row,col) */
    void takePosition(Position pos, Creature a, int row, int col) {
        if(pos.taken == false)//该位置没被占，则站上葫芦娃
        {
            pos.Take(a);
        }
        // 否则，输出信息：位置占用失败
        else {
            System.out.println("Space的["+row+"]["+col+"]位置已经被占领，无法放置生物");
        }
    }
}
