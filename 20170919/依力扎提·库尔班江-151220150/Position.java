public class Position {
    int No;
    CucurbitBrother someone;


    Position(int n){
        No=n;
        someone=null;
    }
    Position (int n,CucurbitBrother s)
    {
        No=n;
        someone=s;
    }

    CucurbitBrother getSomeone(){return someone;}

    void ChangeSomeone(CucurbitBrother s){someone=s;}
}
