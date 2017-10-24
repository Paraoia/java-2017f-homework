package utils.sorter;

import character.Beings;
import character.hero.Huluwa;
import utils.HLW_COLOR;
import utils.HLW_SENIORITY;
import utils.layout.Layout;
import utils.position.BasePosition;
import utils.position.Position;

public class BubbleSort implements Sorter {
    @Override
    public void Sort(Layout nodes, ComparingInterface cmpInterface){
        BasePosition[] array = nodes.getOccupiedNodes();
        for(int i = 0; i < array.length - 1; i++){
            for(int j = 0; j < array.length - i - 1; j++){
                if (ComparingInterface.isBackward(cmpInterface, array[j], array[j+1])){
                    Beings.ExchangeOurPosition(array[j].getContent(), array[j+1].getContent());
                }
            }
        }
    }

    @Override
    public BasePosition sHead(Layout array, ComparingInterface cmpInterface){
        //Sort(array, cmpInterface);
        //return array[0];
        return null;
    }

    @Override
    public BasePosition sTail(Layout array, ComparingInterface cmpInterface){
        //Sort(array, cmpInterface);
        //return array[array.length - 1];
        return null;
    }

    @Override
    public BasePosition sCar(Layout array, ComparingInterface cmpInterface){
        return sHead(array, cmpInterface);
    }

    @Override
    public BasePosition[] sCdr(Layout array, ComparingInterface cmpInterface){
        throw null;
    }
/*
    public static void main(String[] argv){

        Position[] array = new Position[7];

        array[0] = new Position(0, 0);
        array[1] = new Position(0, 1);
        array[2] = new Position(0, 2);
        array[3] = new Position(0, 3);
        array[4] = new Position(0, 4);
        array[5] = new Position(0, 5);
        array[6] = new Position(0, 6);

        Huluwa[] huluwas = new Huluwa[7];

        huluwas[5] = new Huluwa() {
            @Override
            public String TellMyName() {
                return "大娃";
            }

            @Override
            public HLW_COLOR TellMyColor() {
                return HLW_COLOR.RED;
            }

            @Override
            public HLW_SENIORITY TellMySeniority() {
                return HLW_SENIORITY.FIRST;
            }

            @Override
            protected void AfterMeetingBeings() {throw null;}
        };
        huluwas[2] = new Huluwa() {
            @Override
            public String TellMyName() {
                return "二娃";
            }

            @Override
            public HLW_COLOR TellMyColor() {
                return HLW_COLOR.ORANGE;
            }

            @Override
            public HLW_SENIORITY TellMySeniority() {
                return HLW_SENIORITY.SECOND;
            }

            @Override
            protected void AfterMeetingBeings() {throw null;}
        };
        huluwas[6] = new Huluwa() {
            @Override
            public String TellMyName() {
                return "三娃";
            }

            @Override
            public HLW_COLOR TellMyColor() {
                return HLW_COLOR.YELLOW;
            }

            @Override
            public HLW_SENIORITY TellMySeniority() {
                return HLW_SENIORITY.THIRD;
            }

            @Override
            protected void AfterMeetingBeings() {throw null;}
        };
        huluwas[1] = new Huluwa() {
            @Override
            public String TellMyName() {
                return "四娃";
            }

            @Override
            public HLW_COLOR TellMyColor() {
                return HLW_COLOR.GREEN;
            }

            @Override
            public HLW_SENIORITY TellMySeniority() {
                return HLW_SENIORITY.FOURTH;
            }

            @Override
            protected void AfterMeetingBeings() {throw null;}
        };
        huluwas[4] = new Huluwa() {
            @Override
            public String TellMyName() {
                return "五娃";
            }

            @Override
            public HLW_COLOR TellMyColor() {
                return HLW_COLOR.CYAN;
            }

            @Override
            public HLW_SENIORITY TellMySeniority() {
                return HLW_SENIORITY.FIFTH;
            }

            @Override
            protected void AfterMeetingBeings() {throw null;}
        };
        huluwas[0] = new Huluwa() {
            @Override
            public String TellMyName() {
                return "六娃";
            }

            @Override
            public HLW_COLOR TellMyColor() {
                return HLW_COLOR.BLUE;
            }

            @Override
            public HLW_SENIORITY TellMySeniority() {
                return HLW_SENIORITY.SIXTH;
            }

            @Override
            protected void AfterMeetingBeings() {throw null;}
        };
        huluwas[3] = new Huluwa() {
            @Override
            public String TellMyName() {
                return "七娃";
            }

            @Override
            public HLW_COLOR TellMyColor() {
                return HLW_COLOR.VIOLET;
            }

            @Override
            public HLW_SENIORITY TellMySeniority() {
                return HLW_SENIORITY.SEVENTH;
            }

            @Override
            protected void AfterMeetingBeings() {throw null;}
        };

        for (int i = 0; i < array.length; i++) {
            array[i].checkin(huluwas[i]);
        }

        Sorter sorter = new BubbleSort();

        sorter.Sort(array, Huluwa.ColorSorting_r2p);

        for (Position i:array
             ) {
            System.out.println(i);
        }

    }
    */
}
