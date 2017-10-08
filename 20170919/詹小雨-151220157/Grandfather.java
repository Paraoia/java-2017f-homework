public class Grandfather {

    int []line = new int[7];

    Grandfather() {
        for (int i = 0; i < 7; i++)
            line[i] = -1;
    }

    public void setname(CalabashBoy []boys) {
        //boys[0].setname(Name.First);

        boys[0] = new CalabashBoy(Name.First);
        boys[1] = new CalabashBoy(Name.Second);
        boys[2] = new CalabashBoy(Name.Third);
        boys[3] = new CalabashBoy(Name.Fourth);
        boys[4] = new CalabashBoy(Name.Fifth);
        boys[5] = new CalabashBoy(Name.Sixth);
        boys[6] = new CalabashBoy(Name.Seventh);
    }

    void changetwoboys(CalabashBoy []boys, int first, int second) {
        int temp = boys[first].telllocation();
        boys[first].changelocation(boys[second].telllocation());
        boys[second].changelocation(temp);
    }

    public void formline(CalabashBoy []boys) {
        int []choosed = new int[7];
        for (int i = 0; i < 7; i++)
            choosed[i] = 0;
        for (int i = 0; i < 7; i++) {
            int newchoose = boys[i].randomchoose();
            if (choosed[newchoose - 1] != 1) {
                boys[i].setlocation(newchoose);
                choosed[newchoose - 1] = 1;
                line[newchoose - 1] = i;
            }
            else {
                while(true) {
                    newchoose++;
                    if (newchoose > 7)
                        newchoose -= 7;
                    if (choosed[newchoose - 1] != 1) {
                        boys[i].setlocation(newchoose);
                        choosed[newchoose - 1] = 1;
                        line[newchoose - 1] = i;
                        break;
                    }
                }
            }
        }

        linedisplay(boys);
    }

    public void bubblesort(CalabashBoy []boys) {
        System.out.println("Bubblesort by grandfather: ");

        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 6 - i; j++ ) {
                //judge by name
                if (boys[line[j]].tellname() > boys[line[j + 1]].tellname()) {
                    changetwoboys(boys, line[j], line[j + 1]);
                    int temp = line[j];
                    line[j] = line[j + 1];
                    line[j + 1] = temp;
                }
            }
        }

        boysreport(boys, 1);
    }

    int partition(CalabashBoy []boys, int low, int high) {
        int pivot = boys[line[low]].tellcolor();

        while(low < high) {

            while(low < high && boys[line[high]].tellcolor() >= pivot)
                high--;
            if (low != high) {
                changetwoboys(boys, line[low], line[high]);
                line[low] = line[high];
            }


            while(low < high && boys[line[low]].tellcolor() <= pivot)
                low++;
            if (low != high) {
                changetwoboys(boys, line[high], line[low]);
                line[high] = line[low];
            }

        }

        line[low] = pivot;

        return low;
    }

    void qspar(CalabashBoy []boys, int low, int high) {
        if(low < high){
            int pivot = partition(boys,low,high);
            qspar(boys, low,pivot - 1);
            qspar(boys,pivot + 1, high);
        }
    }

    public void quicksort(CalabashBoy []boys) {
        System.out.println("Quicksort by grandfather: ");
        qspar(boys, 0, 6);
        boysreport(boys, 2);
    }

    void linedisplay(CalabashBoy []boys) {
        System.out.print("Current line: ");

        for (int i = 0; i < 7; i++) {
            boys[line[i]].namereport();
            System.out.print(" ");
        }

        System.out.println();
    }

    void boysreport(CalabashBoy []boys, int type) {
        if (type == 1) {
            System.out.print("Name report: ");

            for (int i = 0; i < 7; i++) {
                boys[line[i]].namereport();
                System.out.print(" ");
            }

            System.out.println();
        }
        else if (type == 2) {
            System.out.print("Color report: ");

            for (int i = 0; i < 7; i++) {
                boys[line[i]].colorreport();
                System.out.print(" ");
            }

            System.out.println();
        }
    }
}


