enum COLOR {
    CHI,CHENG,HUANG,LV,QING,LAN,ZI
}

public class CalabashBro{
    public String name;
    public COLOR color;
    public int seniority;
    public CalabashBro(int seniority){
    	switch(seniority){
    		case 1:
    			this.name="大娃";
    			this.color=COLOR.CHI;
    			this.seniority=seniority;
    			break;
    		case 2:
    			this.name="二娃";
    			this.color=COLOR.CHENG;
    			this.seniority=seniority;
    			break;
    		case 3:
    			this.name="三娃";
    			this.color=COLOR.HUANG;
    			this.seniority=seniority;
    			break;
    		case 4:
    			this.name="四娃";
    			this.color=COLOR.LV;
    			this.seniority=seniority;
    			break;
    		case 5:
    			this.name="五娃";
    			this.color=COLOR.QING;
    			this.seniority=seniority;
    			break;
    		case 6:
    			this.name="六娃";
    			this.color=COLOR.LAN;
    			this.seniority=seniority;
    			break;
    		case 7:
    			this.name="七娃";
    			this.color=COLOR.ZI;
    			this.seniority=seniority;
    			break;	
    		
    	}
    }
}
