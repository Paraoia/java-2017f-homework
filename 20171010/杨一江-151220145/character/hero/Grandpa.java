package character.hero;

import character.Beings;
import character.hero.Huluwas.*;
import utils.coordinate._2Coordinate;
import utils.layout.Layout;
import utils.layout.LayoutBrief;
import utils.sorter.ComparingInterface;
import utils.sorter.Sorter;

public class Grandpa extends Beings{

    static private boolean DUPLICATED_LOCK = false;
    private Huluwa[] Huluwas;

    /*
    private Dawa dawa;
    private Erwa erwa;
    private Sanwa sanwa;
    private Siwa siwa;
    private Wuwa wuwa;
    private Liuwa liuwa;
    private Qiwa qiwa;
*/

    private Layout CurrentLayout;

    public Grandpa(_2Coordinate birthplace){
        super(birthplace);
        if(DUPLICATED_LOCK)
            throw null;
        DUPLICATED_LOCK = true;
    }

    private void SetLayout(LayoutBrief bf){
        CurrentLayout = new Layout(bf);
    }

    public void Seed(LayoutBrief initLayout){
        SetLayout(initLayout);
        if(CurrentLayout.nodes.length != 7) throw null;
        Huluwas = new Huluwa[]{new Dawa(null),
                new Erwa(null), new Sanwa(null),
                new Siwa(null), new Wuwa(null),
                new Liuwa(null), new Qiwa(null)};
        for (Huluwa baby:Huluwas
             ) {
            baby.FindMyPlaceInLayout(CurrentLayout);
        }
    }

    public void DesignateHuluwas(LayoutBrief layout){
        SetLayout(layout);
        for (Huluwa baby:Huluwas
             ) {
            if(!baby.FindMyPlaceInLayout(CurrentLayout))
                break;
        }
    }

    public void RangeHuluwas(Sorter sorter, ComparingInterface cmpInterface){
        sorter.Sort(CurrentLayout, cmpInterface);
    }

    @Override
    public String TellMyName(){
        return "爷爷";
    }

    @Override
    protected void AfterMeetingBeings(){
        throw null;
    }

    @Override
    public boolean isHero(){
        return true;
    }
}
