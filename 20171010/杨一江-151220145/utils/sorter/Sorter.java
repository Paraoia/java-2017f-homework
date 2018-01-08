package utils.sorter;

import utils.layout.Layout;
import utils.position.BasePosition;

public interface Sorter {
    void Sort(Layout array, ComparingInterface cmpInterface);
    BasePosition sHead(Layout array, ComparingInterface cmpInterface);
    BasePosition sTail(Layout array, ComparingInterface cmpInterface);
    BasePosition sCar(Layout array, ComparingInterface cmpInterface);
    BasePosition[] sCdr(Layout array, ComparingInterface cmpInterface);
}
