import java.util.*;

public class GrandFather
{
    List<Huluwa> huluwas = new ArrayList<>();

    private static int HuluwaNumber = 7;

    public GrandFather()
    {
        for (int i = 0; i < HuluwaNumber; i++) huluwas.add(new Huluwa());
    }

    public void sort(sortType with)
    {
        switch(with)
        {
            case bubble:
                bubbleSort();
                break;
            case insert:
                insertSort();
                break;
            default:
        }
    }

    public enum sortType
    {
        bubble, insert
    }

    public void report(Huluwa.keyType type)
    {
        for (Huluwa h : huluwas)
        {
            switch (type)
            {
                case name:
                    h.whatName("\n");
                    break;
                case color:
                    h.whatColor("\n");
                    break;
            }
        }
    }

    public void shuffle()
    {
        Collections.shuffle(huluwas);
    }

    private void bubbleSort()
    {
        for (int i = 0; i < huluwas.size(); i++)
        {
            boolean noChange = true;
            for (int j = huluwas.size() - 1; j > i; j--)
            {
                if (huluwas.get(j - 1).isGreaterThan(huluwas.get(j)))
                {
                    //print
                    exchangeInfo(huluwas.get(j - 1), huluwas.get(j), j - 1, j);
                    //exchange
                    Huluwa temp = huluwas.get(j - 1);
                    huluwas.set(j - 1, huluwas.get(j));
                    huluwas.set(j, temp);
                    noChange = false;
                }
            }
            if (noChange)
                break;
        }
    }

    private void insertSort()
    {
        List<Huluwa> n = new ArrayList<>();
        for (Huluwa h : huluwas)
        {
            if (n.size() == 0)
            {
                n.add(h);
                insertInfo(h, 0);
                continue;
            }
            int l = 0, r = n.size();
            while (true)
            {
                int mid = (l + r) / 2;
                if (h.isGreaterThan(n.get(mid)))
                {
                    l = mid + 1;
                }
                else if (n.get(mid).isGreaterThan(h))
                {
                    r = mid;
                }
                if (l >= r)
                {
                    n.add(l, h);
                    insertInfo(h, mid);
                    break;
                }
            }
        }   huluwas = n;
    }

    private static void exchangeInfo(Huluwa lh, Huluwa rh, int l, int r)
    {
        lh.whatName(" : ");
        System.out.println(l + " to " + r);
        rh.whatName(" : ");
        System.out.println(r + " to " + l);
    }

    private static void insertInfo(Huluwa h, int index)
    {
        h.whatName(" -> ");
        System.out.println(index);
    }
}
