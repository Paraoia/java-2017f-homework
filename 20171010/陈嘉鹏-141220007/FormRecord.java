
class FormRecord{
    Direction formOri;
    Integer   width;
    Integer   height;
    String[]  formDot;

    public FormRecord(Direction formOri, Integer width, Integer height, String[] formDot) {
        this.formOri = formOri;
        this.width = width;
        this.height = height;
        this.formDot = formDot;
    }

    public Direction getFormOri() {
        return formOri;
    }

    public Integer getWidth() {
        return width;
    }

    public Integer getHeight() {
        return height;
    }

    public String[] getFormDot() {
        return formDot;
    }

}

class FormRecords{
    static final FormRecord 鹤翼阵 = new FormRecord(
            Direction.南,
            7,
            4,
            new String[]{
                    "4000004",
                    "0300030",
                    "0020200",
                    "0001000"
            }
    );
    static final FormRecord 雁行阵 = new FormRecord(
            Direction.南,
            5,
            5,
            new String[]{
                    "00005",
                    "00040",
                    "00300",
                    "02000",
                    "10000"
            }
    );

    static final FormRecord 衡轭阵 = new FormRecord(
            Direction.南,
            3,
            6,
            new String[]{
                    "006",
                    "500",
                    "004",
                    "300",
                    "002",
                    "100"
            }
    );

    static final FormRecord 长蛇阵 = new FormRecord(
            Direction.南,
            1,
            7,
            new String[]{
                    "7",
                    "6",
                    "5",
                    "4",
                    "3",
                    "2",
                    "1"
            }
    );
    static final FormRecord 鱼鳞阵 = new FormRecord(
            Direction.南,
            7,
            5,
            new String[]{
                    "0005000",
                    "0000400",
                    "0303030",
                    "2020202",
                    "0001000"
            }
    );
    static final FormRecord 方门阵 = new FormRecord(
            Direction.南,
            5,
            5,
            new String[]{
                    "00500",
                    "04040",
                    "30003",
                    "02020",
                    "00100"
            }
    );
    static final FormRecord 偃月阵 = new FormRecord(
            Direction.西,
            7,
            9,
            new String[]{
                    "0000007",
                    "0004060",
                    "0030500",
                    "1204000",
                    "1204000",
                    "1204000",
                    "0030500",
                    "0004060",
                    "0000007"
            }
    );
    static final FormRecord 锋矢阵 = new FormRecord(
            Direction.北,
            9,
            7,
            new String[]{
                    "000010000",
                    "002020200",
                    "030030030",
                    "400040004",
                    "000050000",
                    "000060000",
                    "000070000"
            }
    );

};