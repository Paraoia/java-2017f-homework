


public class CalabashBoy {

    Name name;
    Color color;
    int location;

    //CalabashBoy() {location = -1;}

    CalabashBoy (Name number) {
        name = number;
        switch (name) {
            case First:
                color = Color.Red;
                break;
            case Second:
                color = Color.Orange;
                break;
            case Third:
                color = Color.Yellow;
                break;
            case Fourth:
                color = Color.Green;
                break;
            case Fifth:
                color = Color.Blue;
                break;
            case Sixth:
                color = Color.Indigo;
                break;
            case Seventh:
                color = Color.Purple;
                break;
        }
    }

    public int tellcolor() {
        switch(color) {
            case Red: return 0;
            case Orange: return 1;
            case Yellow: return 2;
            case Green: return 3;
            case Blue: return 4;
            case Indigo: return 5;
            case Purple: return 6;
        }
        return 0;
    }

    public int tellname() {
        switch(name) {
            case First: return 0;
            case Second: return 1;
            case Third: return 2;
            case Fourth: return 3;
            case Fifth: return 4;
            case Sixth: return 5;
            case Seventh: return 6;
        }
        return 0;
    }

    public void colorreport() {
        System.out.print(color.toString());
    }

    public void namereport() {
        System.out.print(name.toString());
    }

    public int telllocation() {
        return location;
    }

    public int changelocation(int destination) {
        if (destination <= 0 || destination > 7)
            return -1;
        if (location != destination) {
            //output
            System.out.println(name + ": " + location + "->" + destination);
            location = destination;
            return 1;
        }
        return 0;
    }

    public int randomchoose() {
        int choose=(int)(Math.random() * 6) + 1;
        return choose;
    }

    public void setlocation(int loc) {
        location = loc;
        //System.out.println(loc);
    }

}
