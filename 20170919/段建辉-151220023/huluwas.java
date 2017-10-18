class Dawa extends Xiaojingang {
    Dawa() {
        rank = 1;
        color = Color.RED;
        name = "大娃";
    }

    @Override
    public String talkName() {return name; }
    @Override
    public void talkSkill() { System.out.println("我有力壮术、巨大化的技能！≖‿≖✧ "); }
}

class Erwa extends Xiaojingang {
    Erwa() {
        rank = 2;
        color = Color.ORANGE;
        name = "二娃";
    }

    @Override
    public void talkSkill() {
        System.out.println("我有千里眼、顺风耳的技能！٩(͡๏̯͡๏)۶");
    }
}

class Sanwa extends Xiaojingang {
    Sanwa() {
        rank = 3;
        color = Color.YELLOW;
        name = "三娃";
    }

    @Override
    public void talkSkill() {
        System.out.println("我有刀枪不入的技能！ ˋ（′～‵）ˊ");
    }
}

class Siwa extends Xiaojingang {
    Siwa() {
        rank = 4;
        color = Color.GREEN;
        name = "四娃";
    }

    @Override
    public void talkSkill() {
        System.out.println("我有火攻、吸纳火焰、霹雳的技能！(‵▽′)ψ ");
    }
}

class Wuwa extends Xiaojingang {
    Wuwa() {
        rank = 5;
        color = Color.CYAN;
        name = "五娃";
    }

    @Override
    public void talkSkill() {
        System.out.println("我有洪击、蓄水、闪电的技能！(●′ω`●)");
    }
}

class Liuwa extends Xiaojingang {
    Liuwa() {
        rank = 6;
        color = Color.BLUE;
        name = "六娃";
    }

    @Override
    public void talkSkill() {
        System.out.println("我有隐身的技能！(*・・*)");
    }
}

class Qiwa extends Xiaojingang {
    Qiwa() {
        rank = 7;
        color = Color.PURPLE;
        name = "七娃";
    }
    @Override
    public void talkSkill() {
        System.out.println("哈哈哈！我有神葫芦！(๑´ڡ`๑) (๑＞ڡ＜)☆");
    }
}

