public class Huluwa {
    private String name;
    private int ranking;//葫芦娃的排行
    private String color;//葫芦娃的颜色

    public Huluwa(){

    }


    public Huluwa(int ranking/*,String color*/){
        this.ranking = ranking;
        this.color = defineColor();
        this.name = defineName();
    }

    public void setRanking(int ranking) {
        this.ranking = ranking;
    }

    public int getRanking() {
        return ranking;
    }

    public String defineColor() {
        switch (this.ranking){
            case 1:
                this.color = "红";
                break;
            case 2:
                this.color = "橙";
                break;
            case 3:
                this.color = "黄";
                break;
            case 4:
                this.color = "绿";
                break;
            case 5:
                this.color = "青";
                break;
            case 6:
                this.color = "蓝";
                break;
            case 7:
                this.color = "紫";
                break;

        }
        return this.color;
    }

    private String defineName()  {
        switch (this.ranking){
            case 1:
                this.name = "老大";
                break;
            case 2:
                this.name = "老二";
                break;
            case 3:
                this.name = "老三";
                break;
            case 4:
                this.name = "老四";
                break;
            case 5:
                this.name = "老五";
                break;
            case 6:
                this.name = "老六";
                break;
            case 7:
                this.name = "老七";
                break;
        }

        return this.name;
    }
    public String getColor() {
        return color;
    }

    public String getName() {
        return name;
    }

    public void setColor(String color) {
        this.color = color;
    }

    /*public void report(){
        switch(this.ranking){
            case 1:
                System.out.println("老大！");
                break;
            case 2:
                System.out.println("老二！");
                break;
            case 3:
                System.out.println("老三！");
                break;
            case 4:
                System.out.println("老四！");
                break;
            case 5:
                System.out.println("老五！");
                break;
            case 6:
                System.out.println("老六！");
                break;
            case 7:
                System.out.println("老七！");
                break;
        }
    }
    */

}
