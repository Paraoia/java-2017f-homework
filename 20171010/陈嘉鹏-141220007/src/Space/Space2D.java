package Space;

import Image.Image;
import Obj.Obj;
import Position.Position;
import Position.Position2D;
import mExceptions.SpaceCoverException;

import java.util.Arrays;
import java.util.ArrayList;

public class Space2D implements Space{
    Position2D scope;

    Obj[] space;

    Obj fill;

    public Space2D(Position2D scope, Obj fill){
        this.scope = scope;
        space = new Obj[scope.getX() * scope.getY()];
        this.fill = fill;
        Arrays.fill(space, fill);
    }

    @Override
    public void layout(Obj obj) throws SpaceCoverException{
        Integer idx = obj.getPosition().calFromOrigin(scope);
        checkIndex(idx);
//        if (space[idx] != fill)
//            throw new SpaceCoverException("Creature Cover Other Creature.");

        space[idx] = obj;
    }

    @Override
    public void layout(ArrayList<Obj> objs) throws SpaceCoverException{
        for (Obj o :
                objs) {
            layout(o);
        }
    }

    @Override
    public void layout(Obj[] objs) throws SpaceCoverException{
        for (Obj o :
                objs) {
            layout(o);
        }
    }

    @Override
    public void flush(Obj obj) throws SpaceCoverException{
        Integer idx = obj.getPosition().calFromOrigin(scope);
        checkIndex(idx);

        space[idx] = fill;
    }

    @Override
    public void flush(Obj[] objs) throws SpaceCoverException{
        for (Obj o :
                objs) {
            flush(o);
        }
    }


    @Override
    public void flush(ArrayList<Obj> objs) throws SpaceCoverException{
        for (Obj o :
                objs) {
            flush(o);
        }
    }

    @Override
    public void moveTo(Obj obj, Position pos) throws SpaceCoverException{
        Integer idx = obj.getPosition().calFromOrigin(scope);
        checkIndex(idx);

        space[idx] = obj;

    }

    @Override
    public void show(){
        for(Integer i = 0; i < space.length; ++i){
            Image image = space[i].getImage();
            image.draw(null);
            if ((i+1) % scope.getX() == 0)
                image.drawNewLine();
        }
    }

    private void checkIndex(Integer idx) throws SpaceCoverException{
        if (idx < 0 || idx >= space.length)
            throw new SpaceCoverException("Object index out of space.");
    }

}
