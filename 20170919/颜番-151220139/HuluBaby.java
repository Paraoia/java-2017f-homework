public class HuluBaby {
    int rank;

    HuluBaby(int _rank){
        rank = _rank;
    }

    public int getRank(){
        return rank;
    }

    public String reportRank(){
        String output="";
        switch(rank){
            case 1: output="大娃"; break;
            case 2: output="二娃"; break;
            case 3: output="三娃"; break;
            case 4: output="四娃"; break;
            case 5: output="五娃"; break;
            case 6: output="六娃"; break;
            case 7: output="七娃"; break;
        }
        return output;
    }

    public String reportColor(){
        String output="";
        switch(rank){
            case 1: output="红色"; break;
            case 2: output="橙色"; break;
            case 3: output="黄色"; break;
            case 4: output="绿色"; break;
            case 5: output="青色"; break;
            case 6: output="蓝色"; break;
            case 7: output="紫色"; break;
        }
        return output;
    }
    public void reportExchangePos(int oldPos, int newPos){
        System.out.printf("%s: %d --> %d\n", reportRank(),oldPos, newPos);
    }

}

