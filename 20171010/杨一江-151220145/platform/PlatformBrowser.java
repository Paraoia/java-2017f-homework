package platform;

import utils.coordinate.Coordinate;
import utils.position.BasePosition;

abstract public class PlatformBrowser {
    abstract public BasePosition Location(Coordinate coord);
    abstract public BasePosition[] Location(Coordinate[] coords);
}
