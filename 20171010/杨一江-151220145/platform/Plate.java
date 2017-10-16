package platform;

import character.Beings;
import character.hero.Grandpa;
import character.hero.Huluwa;
import character.hero.Huluwas.*;
import character.villain.Serpent;
import utils.COORD;
import utils.coordinate.Coordinate;
import utils.coordinate._2Coordinate;
import utils.layout.Layout;
import utils.layout.LayoutBrief;
import utils.layout.LayoutManip;
import utils.position.Position;

public class Plate extends PlatformBrowser implements LayoutManip{
    final static public int dimensionality = 2;
    final private _2Coordinate granularity;
    final private _2Coordinate start;
    final private int[] size;

    final private Position[][] Map;

    private Plate(_2Coordinate granularity, _2Coordinate start, int XNum, int YNum){
        this.granularity = new _2Coordinate(granularity);
        this.start = new _2Coordinate(start);
        size = new int[2];
        size[COORD.X.d()] = XNum;
        size[COORD.Y.d()] = YNum;

        Map = new Position[YNum][XNum];

        for (int i = 0; i < YNum; i++) {
            for (int j = 0; j < XNum; j++) {
                Map[i][j] = new Position(start.X() + granularity.X() * j, start.Y() + granularity.Y() * i);
            }
        }
    }

    static public Plate CreateRealm(_2Coordinate granularity, _2Coordinate start,
                                    int XNum, int YNum, Beings... Characters){
        Plate land = new Plate(granularity, start, XNum, YNum);
        for (Beings creature:Characters
             ) {
            Position respond = land.BirthplaceSection(creature.TellMyBirthplace());
            if(respond == null)  break;
            creature.Birth(respond);
        }
        return land;
    }

    static public Plate CreateRealm(PlateSettings Settings, Beings... Characters){
        return CreateRealm(Settings.granularity(), Settings.start(), Settings.XNum(), Settings.YNum(),Characters);
    }

    @Override
    public Position Location(Coordinate _coord){
        _2Coordinate coord = (_2Coordinate)_coord;
        int[] idx = {0, 0};
        idx[0] = (int)((coord.Y() - start.Y())/granularity.Y());
        idx[1] = (int)((coord.X() - start.X())/granularity.X());

        if(idx[0] < 0 || idx[0] >= size[COORD.Y.d()]
                || idx[1] < 0 || idx[1] >= size[COORD.X.d()])
            return null;
        return Map[idx[0]][idx[1]];
    }

    @Override
    public Position[] Location(Coordinate[] _coord){
        Position[] ret = new Position[_coord.length];
        for (int i = 0; i < _coord.length; i++) {
            ret[i] = Location(_coord[i]);
        }
        return ret;
    }

    private Position BirthplaceSection(_2Coordinate coord){
        Position temp = Location(coord);
        if(temp.isOccupied())   throw null;
        else    return temp;
    }

    @Override
    public String toString(){
        String ret = new String();
        for (Position[] row:Map
             ) {
            String rowString = new String();
            for (Position col:row
                 ) {
                rowString += col.toString();
            }
            ret += (rowString + "\n");
        }
        return ret;
    }

    public String MakeEveryoneResponse(){
        String ret = new String();
        for (Position[] row:Map
                ) {
            String rowString = new String();
            for (Position col:row
                    ) {
                if(col.isOccupied())
                    rowString += ("{" + col.getContent().TellMyName() + "}\t");
                else
                    rowString += "{...}\t";
            }
            ret += (rowString + "\n");
        }
        return ret;
    }

    @Override
    public Layout CentroSymmetry(Layout orig){
        return null;
    }

    @Override
    public Layout InversionSymmetry(Layout orig){
        return null;
    }

    @Override
    public Layout ReversionSymmetry(Layout orig){
        return null;
    }

    @Override
    public Layout Combination(Layout... origs){
        return null;
    }

    @Override
    public Layout Intersection(Layout... origs){
        return null;
    }

    public static void main(String[] argv){
        Grandpa grandpa = new Grandpa(new _2Coordinate(6,2));
        Serpent serpent = new Serpent(new _2Coordinate(9,12));
        Plate world = Plate.CreateRealm(PlateSettings.Regularized, grandpa, serpent);

        grandpa.Seed(new LayoutBrief(world, Layout.Changshe));
        serpent.Recruit(new LayoutBrief(world, Layout.Heyi));

        System.out.println("初始：");
        System.out.println(world.MakeEveryoneResponse());

        serpent.DesignateTroops(new LayoutBrief(world, Layout.Fanggang));

        System.out.println("阵型 1：");
        System.out.println(world.MakeEveryoneResponse());

        serpent.DesignateTroops(new LayoutBrief(world, Layout.Fengshi));

        System.out.println("阵型 2：");
        System.out.println(world.MakeEveryoneResponse());

        serpent.DesignateTroops(new LayoutBrief(world, Layout.Yanyue));

        System.out.println("阵型 3：");
        System.out.println(world.MakeEveryoneResponse());

        serpent.DesignateTroops(new LayoutBrief(world, Layout.Yanxing));

        System.out.println("阵型 4：");
        System.out.println(world.MakeEveryoneResponse());
    }
}

interface PlateSettings{
    _2Coordinate granularity();
    _2Coordinate start();
    int XNum();
    int YNum();

    PlateSettings Regularized = new PlateSettings() {
        @Override
        public _2Coordinate granularity() {
            return _2Coordinate.Regularized_Scale;
        }

        @Override
        public _2Coordinate start() {
            return _2Coordinate.Origin;
        }

        @Override
        public int XNum() {
            return 15;
        }

        @Override
        public int YNum() {
            return 15;
        }
    };
}
