public class Huluwa
{
    private String m_name;  //名字
    private String m_color; //颜色
    public int m_age;      //排序根据

    Huluwa(String name,String color,int age)
    {
        m_name=name;
        m_color=color;
        m_age=age;
    }
    //当前葫芦娃报数
    void report_name()
    {
        System.out.print(m_name+' ');
    }
    //当前葫芦娃报数
    void report_color()
    {
        System.out.print(m_color+' ');
    }
    //报告位置变化
    void report_position_change(int pre,int des)
    {
        System.out.println(m_name+":"+pre+"->"+des);
    }
}
