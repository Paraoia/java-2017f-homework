public class Calabash_Bro {
    int rank;
    String sound, colour;
    int posi;
    String[] sounds = {"老大", "老二", "老三", "老四", "老五", "老六", "老七"};
    String[] colours = {"红色", "橙色", "黄色", "绿色", "青色", "蓝色", "紫色 "};

    public void Set_posi(int r, int p) {
        rank = r;
        sound = sounds[r - 1];
        colour = colours[r - 1];
        posi = p;
    }

    public void Change_pos(int dest) {
        System.out.println(sound + (posi+1) + "->"+ (dest+1));
        posi = dest;
    }

    public void Sounding() {
        System.out.print(sound + " ");
    }

    public void Sounding_Colour() {
        System.out.print(colour + " ");
    }
}
