package Space;

import Obj.Obj;
import Position.Position;
import mExceptions.SpaceCoverException;

import java.util.ArrayList;

public interface Space {

    public void layout(Obj obj) throws SpaceCoverException;
    public void layout(ArrayList<Obj> objs) throws SpaceCoverException;
    public void layout(Obj[] objs) throws SpaceCoverException;
    public void flush(Obj obj) throws SpaceCoverException;
    public void flush(ArrayList<Obj> objs) throws SpaceCoverException;
    public void flush(Obj[] objs) throws SpaceCoverException;
    public void moveTo(Obj obj, Position pos) throws SpaceCoverException;
    public void show();

}
