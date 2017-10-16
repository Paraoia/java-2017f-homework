package unit;

public class NullUnit extends Unit {
    public NullUnit() {
        super("一一一");
    }

    @Override
    public int compareTo(Unit other) {
        if (other instanceof NullUnit)
            return super.compareTo(other);
        else
            return 1;
    }
}
