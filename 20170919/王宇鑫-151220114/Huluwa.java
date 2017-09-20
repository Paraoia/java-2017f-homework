import java.util.*;

public class Huluwa
{
    private static int NO = 0;

    private int number = 0;

    private Map<keyType, String> info = new LinkedHashMap<>();

    public Huluwa()
    {
        number = ++NO;
        info.put(keyType.name, name());
        info.put(keyType.color, color());
    }

    public static void clear()
    {
        NO = 0;
    }

    public boolean isGreaterThan(Huluwa h)
    {
        return number > h.number;
    }

    public enum keyType
    {
        name, color
    }

    public void whatName(String with)
    {
        System.out.print(info.get(keyType.name));
        System.out.print(with);
    }

    public void whatColor(String with)
    {
        System.out.print(info.get(keyType.color));
        System.out.print(with);
    }

    private static String defaultName = "大二三四五六七";

    private String name()
    {
        if (number > defaultName.length())
            return "我不是我没有我不存在";
        return "老" + defaultName.charAt(number - 1);
    }

    private static String defaultColor = "红橙黄绿青蓝紫";

    private String color()
    {
        if (number > defaultColor.length())
            return "我不是我没有我不存在";
        return "" + defaultColor.charAt(number - 1);
    }

    public static void main(String[] args)
    {
        GrandFather gf = new GrandFather();
        gf.shuffle();
        gf.sort(GrandFather.sortType.bubble);
        gf.report(keyType.name);
        gf.shuffle();
        gf.sort(GrandFather.sortType.insert);
        gf.report(keyType.color);
    }
}