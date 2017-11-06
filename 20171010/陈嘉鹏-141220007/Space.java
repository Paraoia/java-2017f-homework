import javafx.geometry.Pos;

import java.lang.reflect.Array;
import java.util.Arrays;

public class Space {
    Position limit;

    Obj[] mm;

    Obj fill;

    Space(Position limit, Obj fill){
        this.limit = limit;
        mm = new Obj[limit.getX() * limit.getY()];
        this.fill = fill;
        Arrays.fill(mm, fill);
    }

    public void Set(Position pos, Obj obj){
        Integer idx = pos.calIndex(limit);
        // TODO: thorw Execption
        if (idx < 0 | idx >= mm.length){
            System.err.println("[Space] Index out of bounds.");
            System.exit(-1);
        }
        mm[idx] = obj;
    }
    public void flush(Position pos){
        mm[pos.calIndex(limit)] = fill;
    }

    void show2DStr(){
        // TODO: thorw Execption
        if (Position.dimension != 2){
            System.err.println("[Space] Dimension is not 2.");
            System.exit(-1);
        }

        for(Integer i = 0; i < mm.length; ++i){
            mm[i].draw();
            if ((i+1) % limit.x == 0)
               StrImage.drawNewLine();
        }

    }






}
