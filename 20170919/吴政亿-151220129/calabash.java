enum  COLOR{
    Red,Orange,Yellow,Green,Cyan,Blue,Purple;
}

public class Calabash {
    private String name;
    private int index;
    private COLOR color;
    
    
    public Calabash(String name, int index, COLOR color){
        this.name = name;
        this.index = index;
        this.color = color;
    }
    
    public void SetCalabash(String name, int index, COLOR color) {
    	this.name = name;
        this.index = index;
        this.color = color;
    }
    
    public String GetName() {
    	return this.name;
    }
    
    public String GetColor() {
    	 String temp = null;
         switch(this.color){
             case Red:   temp = "³à";break;
             case Orange:temp = "³È";break;
             case Yellow:temp = "»Æ";break;
             case Green: temp = "ÂÌ";break;
             case Cyan:  temp = "Çà";break;
             case Blue:  temp = "À¶";break;
             case Purple:temp = "×Ï";break;
         }
         return temp;
    }
    
    public int GetIndex() {
    	return this.index;
    }
}

