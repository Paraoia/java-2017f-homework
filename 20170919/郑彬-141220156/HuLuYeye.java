import com.sun.scenario.effect.Merge;

import java.util.Random;

/**
 * Created by bingo on 2017/9/25.
 */

enum Ranking {
    RANKING_NONE("不存在"), FIRST("老大"), SECOND("老二"), THIRD("老三"), FORTH("老四"), FIFTH("老五"), SIXTH("老六"), SEVENTH("老七");
    private String ChineseName;
    Ranking(String str) { ChineseName = str; }
    String getChineseName() { return ChineseName; }
}

enum Color {
    COLOR_NONE("不存在"), RED("红"), ORANGE("橙"), YELLOW("黄"), GREEN("绿"), BLACK("青"), BLUE("蓝"), PURPLE("紫");
    private String ChineseName;
    Color(String str) { ChineseName = str; }
    String getChineseName() { return ChineseName; }
}

class HuLuWa {
    private Ranking ranking;
    private Color color;

    HuLuWa() {
        this.ranking = Ranking.RANKING_NONE;
        this.color = Color.COLOR_NONE;
    }

    HuLuWa(Ranking r, Color c) {
        this.ranking = r;
        this.color = c;
    }

    HuLuWa(HuLuWa h) {
        this.ranking = h.getRanking();
        this.color = h.getColor();
    }

    public Ranking getRanking() {
        return ranking;
    }

    public Color getColor() {
        return color;
    }

    public void setRanking(Ranking ranking) {
        this.ranking = ranking;
    }

    public void setColor(Color color) {
        this.color = color;
    }
}

class HuLuBrothers {
    private HuLuWa[] huLuBro;

    public HuLuBrothers() {
    }

    public HuLuBrothers(HuLuWa[] huLuBro) {
        this.huLuBro = huLuBro;
    }

    private void swap(int i, int j) {
        assert(i > 0 && i < huLuBro.length && j > 0 && j < huLuBro.length);

        if(i != j) {
            System.out.printf("%s: %d -> %d\n", huLuBro[j].getRanking().getChineseName(), j, i);
            System.out.printf("%s: %d -> %d\n", huLuBro[i].getRanking().getChineseName(), i, j);
            HuLuWa temp = huLuBro[i];
            huLuBro[i] = huLuBro[j];
            huLuBro[j] = temp;
        }
    }

    public void BubbleSortByRanking() {
        for(int i = huLuBro.length; i > 1; i --) {
            for(int j = 0; j < i - 1; j ++) {
                if(huLuBro[j].getRanking().compareTo(huLuBro[j + 1].getRanking()) > 0) {
                    swap(j, j + 1);
                }
            }
        }
    }

    private void Merge(int p, int m, int q) {
        // System.out.printf("Merge [%d, %d] with (%d, %d]\n", p, m, m, q);
        HuLuWa[] arr = new HuLuWa[q - p + 1];
        int i = p, j = m, idx = 0;
        while(i < m && j < q) {
            if(huLuBro[i].getColor().compareTo(huLuBro[j].getColor()) <= 0) {
                arr[idx ++] = new HuLuWa(huLuBro[i ++]);
                if(i != idx + p) {
                    System.out.printf("%s: %d -> %d\n", huLuBro[i - 1].getRanking().getChineseName(), i - 1, idx - 1 + p);
                }
            } else {
                arr[idx ++] = new HuLuWa(huLuBro[j ++]);
                if(j != idx + p) {
                    System.out.printf("%s: %d -> %d\n", huLuBro[j - 1].getRanking().getChineseName(), j - 1, idx - 1 + p);
                }
            }
        }

        while(i < m) {
            arr[idx ++] = new HuLuWa(huLuBro[i ++]);
            if(i != idx + p) {
                System.out.printf("%s: %d -> %d\n", huLuBro[i - 1].getRanking().getChineseName(), i - 1, idx - 1 + p);
            }
        }

        while (j < q) {
            arr[idx ++] = new HuLuWa(huLuBro[j ++]);
            if(j != idx + p) {
                System.out.printf("%s: %d -> %d\n", huLuBro[j - 1].getRanking().getChineseName(), j - 1, idx - 1 + p);
            }
        }

        for(i = 0; i < idx; i ++) {
            huLuBro[p + i] = arr[i];
        }
    }

    private void MergeSort(int i, int j) {
        // System.out.printf("MegerSort from %d to %d\n", i, j);
        if(i + 1 < j) {
            int m = (i + j) / 2;
            MergeSort(i, m);
            MergeSort(m, j);
            Merge(i, m, j);
        }
    }

    public void MergeSortByColor() {
        MergeSort(0, huLuBro.length);
    }

    public void Disorder() {
        int len = huLuBro.length, idx;
        Random rand = new Random(System.currentTimeMillis());
        for(int i = 0; i < len; i ++) {
            idx = rand.nextInt(len - i) + i;
            if(idx != i) {
                swap(i, idx);
            }
        }
    }

    public void TellRanking() {
        System.out.println("Ranking order:");
        for(HuLuWa wawa: huLuBro) {
            System.out.println(wawa.getRanking().getChineseName());
        }
    }

    public void TellColor() {
        System.out.println("Color order: ");
        for(HuLuWa wawa: huLuBro) {
            System.out.println(wawa.getColor().getChineseName());
        }
    }
}

public class HuLuYeye {

    public static void main(String[] args) {

        // initialize
        System.out.println("初始化......");
        HuLuWa[] huluBro = new HuLuWa[7];
        for(int i = 0; i < 7; i ++) {
            huluBro[i] = new HuLuWa(Ranking.values()[i + 1], Color.values()[i + 1]);
        }
        HuLuBrothers bro = new HuLuBrothers(huluBro);


        // Bubble sort
        System.out.println("\n随意站队......");
        bro.Disorder();
        bro.TellRanking();
        System.out.println("\n冒泡排序......");
        bro.BubbleSortByRanking();
        System.out.println("\n报数......");
        bro.TellRanking();

        // Merge sort
        System.out.println("\n\n随意站队......");
        bro.Disorder();
        bro.TellColor();
        System.out.println("\n二分排序......");
        bro.MergeSortByColor();
        System.out.println("\n报颜色......");
        bro.TellColor();
    }

}


