package Formation;


import mEnums.Direction;

public class FormRecordImpl implements FormRecord{
    Direction direction;
    Integer   width;
    Integer   height;
    String[]  formDot;

    public FormRecordImpl(Direction direction, Integer width, Integer height, String[] formDot) {
        this.direction = direction;
        this.width = width;
        this.height = height;
        this.formDot = formDot;
    }

    @Override
    public Direction getRecordDirection() {
        return direction;
    }

    @Override
    public Integer getWidth() {
        return width;
    }

    @Override
    public Integer getHeight() {
        return height;
    }

    @Override
    public String[] getFormDot() {
        return formDot;
    }
}
