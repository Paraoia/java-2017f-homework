package utils.sorter;

abstract public class ComparingInterface {

    private Object ego = null;

    final private void setEgo(Object ego){
        this.ego = ego;
    }

    final public Object getEgo(){
        return ego;
    }

    abstract public boolean _isGreater(Object cmp);
    abstract public boolean _isSmaller(Object cmp);
    abstract public boolean _isEqual(Object cmp);
    abstract public boolean _isForward(Object cmp);
    abstract public boolean _isBackward(Object cmp);
    abstract public boolean _isStill(Object cmp);

    static public boolean isGreater(ComparingInterface cmpInterface, Object base, Object cmp){
        cmpInterface.setEgo(base);
        return cmpInterface._isGreater(cmp);
    }

    static public boolean isSmaller(ComparingInterface cmpInterface, Object base, Object cmp){
        cmpInterface.setEgo(base);
        return cmpInterface._isSmaller(cmp);
    }

    static public boolean isEqual(ComparingInterface cmpInterface, Object base, Object cmp){
        cmpInterface.setEgo(base);
        return cmpInterface._isEqual(cmp);
    }

    static public boolean isForward(ComparingInterface cmpInterface, Object base, Object cmp){
        cmpInterface.setEgo(base);
        return cmpInterface._isForward(cmp);
    }

    static public boolean isBackward(ComparingInterface cmpInterface, Object base, Object cmp){
        cmpInterface.setEgo(base);
        return cmpInterface._isBackward(cmp);
    }

    static public boolean isStill(ComparingInterface cmpInterface, Object base, Object cmp){
        cmpInterface.setEgo(base);
        return cmpInterface._isStill(cmp);
    }
}
