enum COLOR {
    赤, 橙, 黄, 绿, 青, 蓝, 紫
}

enum SENIORITY {
    一, 二, 三, 四, 五, 六, 七
}
public class Huluwa extends Creature implements Comparable{

        private COLOR color;
        private SENIORITY seniority;

        public COLOR getColor() {
            return color;
        }

        public SENIORITY getSeniority() {
            return seniority;
        }

        public Position getPosition() {
            return position;
        }

        public void setPosition(Position position) {
            this.position = position;
            position.setHolder(this);
        }

        Huluwa(COLOR color, SENIORITY seiority) {
            this.color = color;
            this.seniority = seiority;
        }


        public void report() {
            System.out.print(this.toString());
        }


        public String toString(){
            return this.seniority.toString();
        }


        public boolean biggerThan(Comparable brother){

            if (brother instanceof Huluwa)
                return this.getSeniority().ordinal()> ((Huluwa) brother).getSeniority().ordinal();
            else
                return false;
        }

}
