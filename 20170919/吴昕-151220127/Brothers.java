/* 从葫芦娃基类派生出的七兄弟
* 编入可用于排序的序号
* 重写报数以及报颜色函数 */

class First extends Huluwa{
    First() { setNO(1); }

    @Override
    public void exclaim_no() { System.out.print("老大 "); }
    public void exclaim_color() { System.out.print("红色 "); }
}

class Second extends Huluwa {
    Second() { setNO(2); }

    @Override
    public void exclaim_no() { System.out.print("老二 "); }
    public void exclaim_color() { System.out.print("橙色 "); }
}

class Third extends Huluwa {
    Third() { setNO(3); }

    @Override
    public void exclaim_no() { System.out.print("老三 "); }
    public void exclaim_color() { System.out.print("黄色 "); }
}

class Fourth extends Huluwa {
    Fourth() { setNO(4); }

    @Override
    public void exclaim_no() { System.out.print("老四 "); }
    public void exclaim_color() { System.out.print("绿色 "); }
}

class Fifth extends Huluwa {
    Fifth() { setNO(5); }

    @Override
    public void exclaim_no() { System.out.print("老五 "); }
    public void exclaim_color() { System.out.print("青色 "); }
}

class Sixth extends Huluwa {
    Sixth() { setNO(6); }

    @Override
    public void exclaim_no() { System.out.print("老六 "); }
    public void exclaim_color() { System.out.print("蓝色 "); }
}

class Seventh extends Huluwa {
    Seventh() { setNO(7); }

    @Override
    public void exclaim_no() { System.out.print("老七 "); }
    public void exclaim_color() { System.out.print("紫色 "); }
}