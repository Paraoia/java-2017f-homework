package character.hero;

import character.Beings;
import character.Subordinate;
import utils.HLW_COLOR;
import utils.HLW_SENIORITY;
import utils.coordinate._2Coordinate;
import utils.position.*;
import utils.sorter.ComparingInterface;

import java.util.ArrayList;

abstract public class Huluwa extends Subordinate{

    static private int TotalBrother = 0;
//    static private ArrayList<Huluwa> Brothers;

    public Huluwa(_2Coordinate birthplace){
        super(birthplace);
        TotalBrother++;
    }
/*
    public Huluwa(_2Coordinate birthplace, Huluwa you){
        super(birthplace);
        TotalBrother++;
        Brothers.add(you);
    }
*/
    final public int TellBrotherNumber(){
        return TotalBrother;
    }

    /*
    final Huluwa FindMyBrother(HLW_SENIORITY seniority){
        for (Huluwa needle:Brothers
             ) {
            if(HLW_SENIORITY.isEqual(seniority,needle.TellMySeniority())){
                return needle;
            }
        }
        return null;
    }


    final public BasePosition FindMyBrotherPosition(final Beings Query, HLW_SENIORITY seniority){
        if(Query == null) throw null;
        Huluwa him = FindMyBrother(seniority);
        if(him == null)
            return null;
        return TellMyPosition();
    }
*/

    static final public ComparingInterface ColorSorting_r2p = new ColorSorting() {
        @Override
        public boolean _isForward(Object cmp){
            return _isGreater(cmp);
        }

        @Override
        public boolean _isBackward(Object cmp){
            return _isSmaller(cmp);
        }

        @Override
        public boolean _isStill(Object cmp){
            return _isEqual(cmp);
        }
    };
    static final public ComparingInterface SenioritySorting_f2s = new SenioritySorting() {
        @Override
        public boolean _isForward(Object cmp) {
            return _isGreater(cmp);
        }

        @Override
        public boolean _isBackward(Object cmp) {
            return _isSmaller(cmp);
        }

        @Override
        public boolean _isStill(Object cmp) {
            return _isEqual(cmp);
        }
    };

    @Override
    public boolean isHero(){
        return true;
    }

    abstract public String TellMyName();
    abstract public HLW_COLOR TellMyColor();
    abstract public HLW_SENIORITY TellMySeniority();
    abstract protected void AfterMeetingBeings();

    /*
    static public void main(String[] argv){
        Huluwa tested = new Huluwa(new _2Coordinate(0,0)) {
            @Override
            public String TellMyName() {
                return "tested";
            }

            @Override
            public HLW_COLOR TellMyColor() {
                return HLW_COLOR.BLUE;
            }

            @Override
            public HLW_SENIORITY TellMySeniority() {
                return HLW_SENIORITY.FIRST;
            }

            @Override
            protected void AfterMeetingBeings() {throw null;}
        };

        System.out.println("Total Brothers " + tested.TellBrotherNumber());
        System.out.println("Name " + tested.TellMyName());
        System.out.println("Seniority " + tested.TellMySeniority());
        System.out.println("Color " + tested.TellMyColor());
        Position position = new Position(1, 1);

        position.checkin(tested);
        System.out.println("BasePosition " + tested.TellBasePosition());

        position.checkout();
        System.out.println("BasePosition " + position);
    }
    */
}

abstract class ColorSorting extends ComparingInterface {
    @Override
    public boolean _isGreater(Object _cmp){
        BasePosition base = (BasePosition)getEgo();
        BasePosition cmp = (BasePosition)_cmp;
        if(base == null || cmp == null)
            return false;
        Huluwa baseContent =  (Huluwa)base.getContent();
        Huluwa cmpContent = (Huluwa)cmp.getContent();
        if(baseContent == null)
            return false;
        else if(cmpContent == null)
            return true;
        else
            return HLW_COLOR.isGreater(baseContent.TellMyColor(),
                    cmpContent.TellMyColor());
    }

    @Override
    public boolean _isSmaller(Object _cmp){
        BasePosition base = (BasePosition)getEgo();
        BasePosition cmp = (BasePosition)_cmp;
        if(base == null || cmp == null)
            return false;
        Huluwa baseContent =  (Huluwa)base.getContent();
        Huluwa cmpContent = (Huluwa)cmp.getContent();
        if(baseContent == null)
            return false;
        else if(cmpContent == null)
            return true;
        else
            return HLW_COLOR.isSmaller(((Huluwa)base.getContent()).TellMyColor(),
                    ((Huluwa)cmp.getContent()).TellMyColor());
    }

    @Override
    public boolean _isEqual(Object _cmp){
        BasePosition base = (BasePosition)getEgo();
        BasePosition cmp = (BasePosition)_cmp;
        if(base == null || cmp == null)
            return false;
        Huluwa baseContent =  (Huluwa)base.getContent();
        Huluwa cmpContent = (Huluwa)cmp.getContent();
        if(baseContent == null)
            return false;
        else if(cmpContent == null)
            return true;
        else
            return HLW_COLOR.isEqual(((Huluwa)base.getContent()).TellMyColor(),
                    ((Huluwa)cmp.getContent()).TellMyColor());
    }

    abstract public boolean _isForward(Object cmp);
    abstract public boolean _isBackward(Object cmp);
    abstract public boolean _isStill(Object cmp);
}

abstract class SenioritySorting extends ComparingInterface {
    @Override
    public boolean _isGreater(Object _cmp){
        BasePosition base = (BasePosition)getEgo();
        BasePosition cmp = (BasePosition)_cmp;
        if(base == null || cmp == null)
            return false;
        Huluwa baseContent =  (Huluwa)base.getContent();
        Huluwa cmpContent = (Huluwa)cmp.getContent();
        if(baseContent == null)
            return false;
        else if(cmpContent == null)
            return true;
        else
            return HLW_SENIORITY.isGreater(baseContent.TellMySeniority(),
                    cmpContent.TellMySeniority());
    }

    @Override
    public boolean _isSmaller(Object _cmp){
        BasePosition base = (BasePosition)getEgo();
        BasePosition cmp = (BasePosition)_cmp;
        if(base == null || cmp == null)
            return false;
        Huluwa baseContent =  (Huluwa)base.getContent();
        Huluwa cmpContent = (Huluwa)cmp.getContent();
        if(baseContent == null)
            return false;
        else if(cmpContent == null)
            return true;
        else
            return HLW_SENIORITY.isSmaller(((Huluwa)base.getContent()).TellMySeniority(),
                    ((Huluwa)cmp.getContent()).TellMySeniority());
    }

    @Override
    public boolean _isEqual(Object _cmp){
        BasePosition base = (BasePosition)getEgo();
        BasePosition cmp = (BasePosition)_cmp;
        if(base == null || cmp == null)
            return false;
        Huluwa baseContent =  (Huluwa)base.getContent();
        Huluwa cmpContent = (Huluwa)cmp.getContent();
        if(baseContent == null)
            return false;
        else if(cmpContent == null)
            return true;
        else
            return HLW_SENIORITY.isEqual(((Huluwa)base.getContent()).TellMySeniority(),
                    ((Huluwa)cmp.getContent()).TellMySeniority());
    }

    abstract public boolean _isForward(Object cmp);
    abstract public boolean _isBackward(Object cmp);
    abstract public boolean _isStill(Object cmp);
}
