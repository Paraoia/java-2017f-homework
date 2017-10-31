enum Color { RED, ORANGE, YELLOW, GREEN, CYAN, BLUE, PURPLE }
public class Huluwa{
    private int no;
    private Color color;

    public Huluwa(int No,Color c)
    {
        no=No;
        color=c;
    }

    public void numberOff()
    {
        switch(no)
        {
            case 1:{
                System.out.print("老大");
                break;
            }
            case 2:{
                System.out.print("老二");
                break;
            }
            case 3:{
                System.out.print("老三");
                break;
            }
            case 4:{
                System.out.print("老四");
                break;
            }
            case 5:{
                System.out.print("老五");
                break;
            }
            case 6:{
                System.out.print("老六");
                break;
            }
            case 7:{
                System.out.print("老七");
                break;
            }
        }
    }

    public void colorOff()
    {
        System.out.print(color);
    }

    public int getNo() {
        return no;
    }
};
