package utils.layout;

import platform.PlatformBrowser;
import utils.coordinate.Coordinate;

public class LayoutBrief {
    final Coordinate[] coords;
    final PlatformBrowser world;

    public LayoutBrief(PlatformBrowser world, Coordinate... obj){
        this.world = world;
        this.coords = obj;
    }
}
