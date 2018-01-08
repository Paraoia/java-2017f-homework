package maps;

public interface Arrange {

    //将需要显示的坐标集合放置在地图上
    //left,down 表示集合的左下角所对应在地图上的左下角的坐标
    public void setFormation(Map map, int left, int down);

    //将坐标集合从地图上删除
    public void delFormation();
}
