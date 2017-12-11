package utils.layout;

import platform.PlatformBrowser;
import utils.coordinate.Coordinate;
import utils.coordinate._2Coordinate;
import utils.position.BasePosition;

import java.util.Random;

public class Layout {
    final public BasePosition[] nodes;
    final public PlatformBrowser platform;
    final public int length;

    public Layout(PlatformBrowser platform, Coordinate... obj){
        this.platform = platform;
        nodes = platform.Location(obj);
        length = nodes.length;
    }

    public Layout(LayoutBrief bf) {
        this.platform = bf.world;
        this.nodes = platform.Location(bf.coords);
        length = nodes.length;
    }

    public BasePosition[] getOccupiedNodes(){
        int sizeShouldBe = 0;
        BasePosition[] notes = new BasePosition[length];
        for (int i = 0; i < length; i++) {
            if(nodes[i].isOccupied()){
                notes[sizeShouldBe] = nodes[i];
                sizeShouldBe++;
            }
        }
        BasePosition[] ret = new BasePosition[sizeShouldBe];
        for (int i = 0; i < sizeShouldBe; i++) {
            ret[i] = notes[i];
        }
        return ret;
    }

    public boolean isAvailable(){
        for (BasePosition i:nodes
             ) {
            if(!i.isOccupied())
                return true;
        }
        return false;
    }

    public int getVacantNumber(){
        int sum = 0;
        for (BasePosition i:nodes
             ) {
            if(!i.isOccupied())
                sum++;
        }
        return sum;
    }

    static public _2Coordinate[] Heyi = {new _2Coordinate(9,7), new _2Coordinate(10,6),
        new _2Coordinate(10,8), new _2Coordinate(11,5), new _2Coordinate(11,9),
        new _2Coordinate(12,4), new _2Coordinate(12,10)};

    static public _2Coordinate[] Changshe = {new _2Coordinate(5,7), new _2Coordinate(5,6),
            new _2Coordinate(5,8), new _2Coordinate(5,5), new _2Coordinate(5,9),
            new _2Coordinate(5,4), new _2Coordinate(5,10)};

    static public _2Coordinate[] Fengshi = {new _2Coordinate(9,7), new _2Coordinate(10,6),
            new _2Coordinate(10,8), new _2Coordinate(11,5), new _2Coordinate(11,9),
            new _2Coordinate(10,7), new _2Coordinate(11,7), new _2Coordinate(12,7)};

    static public _2Coordinate[] Yanxing = {new _2Coordinate(9,9), new _2Coordinate(10,8),
            new _2Coordinate(11,7), new _2Coordinate(12,6), new _2Coordinate(13,5)};

    static public _2Coordinate[] Yanyue = {new _2Coordinate(9,7), new _2Coordinate(9,6),
            new _2Coordinate(9,8), new _2Coordinate(10,5), new _2Coordinate(10,9),
            new _2Coordinate(10,6), new _2Coordinate(10,8), new _2Coordinate(10,7),
            new _2Coordinate(11,4), new _2Coordinate(11,10), new _2Coordinate(11,5),
            new _2Coordinate(11,9), new _2Coordinate(11,6), new _2Coordinate(11,8),
            new _2Coordinate(11,7), new _2Coordinate(12,4), new _2Coordinate(12,10),
            new _2Coordinate(13,3), new _2Coordinate(13,11)};

    static public _2Coordinate[] Fanggang = {new _2Coordinate(9,7), new _2Coordinate(10,6),
            new _2Coordinate(10,8), new _2Coordinate(11,5), new _2Coordinate(11,9),
            new _2Coordinate(12,6), new _2Coordinate(12,8), new _2Coordinate(13,7)};

    public BasePosition FindVacantPlace(){
        if(!isAvailable())   return null;
        while (true){
            int favor = new Random().nextInt(length);
            if(!nodes[favor].isOccupied()){
                return nodes[favor];
            }
        }
    }

    public BasePosition FindHead(){
        return nodes[0];
    }
}
