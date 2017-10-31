import org.w3c.dom.Attr;

/** Assigenment 1: Gourd-Brother-oriented programming
 *  @version 2.0
 *  @author 151140042
 *
 *  This part provides the entry point.
 */

public class God {

    /*
    public static void bubble(Color[] member,int number)
    {
        boolean check;
        for (int i = 1;i < number;i ++)
        {
            check = true;
            for (int j = 0;j < number - i;j ++)
                if (member[j].compareTo(member[j + 1]) > 0)
                {
                    check = false;
                    Color t = member[j];
                    member[j] = member[j + 1];
                    member[j].displayRank();
                    System.out.println(j + 1 + " -> " + j);
                    member[j + 1] = t;
                    member[j + 1].displayRank();
                    System.out.println(j + " -> " + (j + 1));
                }
            if (check)
                break;
        }
    }
    public static void quick(Color[] member,int begin,int end)
    {
        if (begin >= end)
            return;
        int front = begin + 1,back = end;
        Color t;
        do
        {
            if (member[back].compareTo(member[begin]) < 0)
            {
                t = member[front];
                member[front] = member[back];
                member[front].displayRank();
                System.out.println(back + " -> " + front);
                member[back] = t;
                member[back].displayRank();
                System.out.println(front + " -> " + back);
                front ++;
            }
            else
                back --;
        } while (front <= back);
        t = member[back];
        member[back] = member[begin];
        member[begin] = t;
        quick(member,begin,back - 1);
        quick(member,front,end);
    }
    */

    private static Lotus[] lotus;
    private static Gourd[] gourd;
    private static final int LENGTH = Attribute.values().length;

    private static void shuffle() {
        Gourd candidate;
        for (int i = 0;i < LENGTH;i ++) {
            do {
                candidate = gourd[(int) (Math.random() * LENGTH)];
                for (int j = 0; j < i; j++) {
                    if (lotus[j].putGourd() == candidate) {
                        candidate = null;
                        break;
                    }
                }
            } while (candidate == null);
            lotus[i].distribute(candidate);
        }
    }

    private static void bubbleSort() {
        boolean check;
        for (int i = 1;i < LENGTH;i ++) {
            check = true;
            for (int j = 0;j < LENGTH - i;j ++)
                if (lotus[j].putGourd().putOrdinal() > lotus[j + 1].putGourd().putOrdinal()) {
                    lotus[j].putGourd().exchange(lotus[j + 1].putGourd());
                    check = false;
                }
            if (check)
                break;
        }
    }

    private static int binSearch(int front,int back,int target) {
        if (lotus[back].putGourd().putOrdinal() <= lotus[target].putGourd().putOrdinal())
                return back + 1;
        if (front >= back)
            return back;
        int middle = (front + back) / 2;
        if (lotus[middle].putGourd().putOrdinal() > lotus[target].putGourd().putOrdinal())
            return binSearch(front,middle,target);
        return binSearch(middle + 1,back,target);
    }

    private static void binSort() {
        int location;
        for (int i = 1;i < LENGTH;i ++) {
            location = binSearch(0, i - 1, i);
            for (int j = i;j > location;j --)
                lotus[j].putGourd().exchange(lotus[j - 1].putGourd());
        }
    }

    /** @param args to parse as an array in the command line */
    public static void main(String[] args) {
        lotus = new Lotus[LENGTH];
        gourd = new Gourd[LENGTH];
        for (int i = 0;i < LENGTH;i ++)
            lotus[i] = new Lotus();
        Attribute.reset();
        for (int i = 0;i < LENGTH;i ++)
            gourd[i] = new Gourd();
        shuffle();
        System.out.println("冒泡排序前：");
        System.out.print(lotus[0].putGourd().putRank());
        for (int i = 1;i < LENGTH;i ++)
            System.out.print(" " + lotus[i].putGourd().putRank());
        System.out.println();
        System.out.println("冒泡排序中：");
        bubbleSort();
        System.out.println("冒泡排序后：");
        System.out.print(lotus[0].putGourd().putRank());
        for (int i = 1;i < LENGTH;i ++)
            System.out.print(" " + lotus[i].putGourd().putRank());
        System.out.println();
        shuffle();
        System.out.println("二分排序前：");
        System.out.print(lotus[0].putGourd().putRank());
        for (int i = 1;i < LENGTH;i ++)
            System.out.print(" " + lotus[i].putGourd().putRank());
        System.out.println();
        System.out.println("二分排序中：");
        binSort();
        System.out.println("二分排序后：");
        System.out.print(lotus[0].putGourd().putRank());
        for (int i = 1;i < LENGTH;i ++)
            System.out.print(" " + lotus[i].putGourd().putRank());
        System.out.println();
    }
}