
public class GourdEva {
    public enum colors{
        RED,ORANGE,YELLOW,GREEN,BLUENESS,BLUE,PURPLE;
    }
    int position;
    colors color;
    int age;  //年龄采用倒序，1为最大

    public void countOffAge(){
        switch (age){
            case 1:
                System.out.print("大娃 ");break;
            case 2:
                System.out.print("二娃 ");break;
            case 3:
                System.out.print("三娃 ");break;
            case 4:
                System.out.print("四娃 ");break;
            case 5:
                System.out.print("五娃 ");break;
            case 6:
                System.out.print("六娃 ");break;
            case 7:
                System.out.print("七娃 ");break;
        }
    }
    public void countOffColor(){
        switch (color){
            case RED:
                System.out.print("红色 ");break;
            case ORANGE:
                System.out.print("橙色 ");break;
            case YELLOW:
                System.out.print("黄色 ");break;
            case GREEN:
                System.out.print("绿色 ");break;
            case BLUENESS:
                System.out.print("青色 ");break;
            case BLUE:
                System.out.print("蓝色 ");break;
            case PURPLE:
                System.out.print("紫色 ");break;
        }
    }
    public void goToPosition(int newPosition){
        switch (age){
            case 1:
                System.out.println("老大："+position+"->"+newPosition);break;
            case 2:
                System.out.println("老二："+position+"->"+newPosition);break;
            case 3:
                System.out.println("老三："+position+"->"+newPosition);break;
            case 4:
                System.out.println("老四："+position+"->"+newPosition);break;
            case 5:
                System.out.println("老五："+position+"->"+newPosition);break;
            case 6:
                System.out.println("老六："+position+"->"+newPosition);break;
            case 7:
                System.out.println("老七："+position+"->"+newPosition);break;
        }
        position=newPosition;
    }
    public boolean ageBiggerThan(GourdEva other){
        return this.age<=other.age;
    }
    public boolean colorSmallerThan(GourdEva other){
        return this.color.compareTo(other.color)<=0;
    }

    public GourdEva(int position, colors color, int age) {
        this.position = position;
        this.color = color;
        this.age = age;
    }

    public void setPosition(int position) {
        this.position = position;
    }
}
