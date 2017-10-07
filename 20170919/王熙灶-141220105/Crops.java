/**
 * 葫芦军团，由七只葫芦娃组成
 * 红娃排行老大、橙娃排行老二、黄娃排行老三、绿娃排行老四、青娃排行老五、蓝娃排行老六、紫娃排行老七，
 * 七兄弟各有一身独特的本领。
 */

import java.util.Random;

public class Crops {
    public Calabash[] calaBros;
    
    /**
     * 传说鸿蒙之初，天地间诞生了七只葫芦娃，从大到小，依次从葫芦里蹦了出来，排成了一条队
     */
    public void generate() {
        calaBros = new Calabash[7];
        calaBros[0] = new Calabash("红色", "老大", 1);
        calaBros[1] = new Calabash("橙色", "老二", 2);
        calaBros[2] = new Calabash("黄色", "老三", 3);
        calaBros[3] = new Calabash("绿色", "老四", 4);
        calaBros[4] = new Calabash("青色", "老五", 5);
        calaBros[5] = new Calabash("蓝色", "老六", 6);
        calaBros[6] = new Calabash("紫色", "老七", 7);
    }

    /**
     * 葫芦娃生性十分活跃，因此总是在队伍中乱窜，导致随意站队
     */
    public void randomPermutation() {
        Random random = new Random();
        for(int i = 0; i < 7; i++) {
            int p = random.nextInt(7);
            Calabash tmp = calaBros[i];
            calaBros[i] = calaBros[p];
            calaBros[p] = tmp;
        }
    }

    /**
     * 在当前的葫芦军团队伍中，将排在第i位和第j位的葫芦娃位置互换
     */
    public void swap(int i, int j) {
        calaBros[i].reportExchange(i, j);
        System.out.print(", ");
        calaBros[j].reportExchange(j, i);
        System.out.print("\n");
        Calabash tmp = calaBros[i];
        calaBros[i] = calaBros[j];
        calaBros[j] = tmp;
    }

    /**
     * 从头至尾，打印每只葫芦娃的颜色
     */
    public void printColor() {
        for(Calabash cala: calaBros) {
            System.out.print(cala.get_colorWa() + " ");
        }
        System.out.println();
    }

    /**
     * 从头到尾，打印每只葫芦娃的长幼次序
     */
    public void printNo() {
        for(Calabash cala: calaBros) {
            System.out.print(cala.get_laoNo() + " ");
        }
        System.out.println();
    }
}