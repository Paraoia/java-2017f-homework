#10.10作业
##完成情况
在观摩了曹老师的代码之后，我将第二次的代码进行了重构，架构较之前发生了较大的变化。
整个项目包括三个大的部分：各种生物，位置坐标，用于布置各种生物的空间。各种组成部分如下：

1. Creature接口及相关：其中包括了report, getPosition, setPosition, clearPosition等方法，用于统一表示所有的生物，便于修改。实现了该接口的类包括Huluwa（葫芦娃类），Growups（用于表示普通生物，妖怪，爷爷均属于此类）。

2. Position接口及相关：二维空间坐标类（FieldPosition）实现的接口，方便后续调用。

3. Field类及相关：二维空间，包含了一个FieldPosition的二维数组，可将各种生物体排布出任意阵型。定义了专门的排阵的类DrawField，内置Draw函数，可输入一张黑白图片，识别出图像中的阵型，返回二维布尔数组，Field类根据该数组将生物排列出各种阵型。

此外，还有第二次作业中的排序功能，现重写为SortCreature类，包括一个排序函数接口，接受任何Creature数组，按照长幼之分排列各自的位置，适用范围更好。

##面向对象理念的应用：
###开放封闭原则
软件实体应该对拓展开放，对内部数据成员的修改封闭。基于此原则设计Field类，如上文所言，Field本来包含了一个二维数组用于表示二维空间，我们要通过Field类实现排兵布阵（多种布阵方式），按照过程式设计的思路，可以为每一种布阵方式实现一个函数（接口）：
```
class Field{
    .......
    public void deployAsFieldname1(Creature[] creature);
    public void deployAsFieldname2(Creature[] creature);
    public void deployAsFieldname3(Creature[] creature);
    .......
}
```
但是，这种实现方式比较死板，首先，排阵函数内部有大量的关于排阵位置的细节代码，一旦空间的大小发生变化，为了适配变化所有函数都需要改动，其次，每增加一种实现方式都要新增一个函数，对于后续拓展无疑是很不方便的。我们可以说这种实现方式是“半开放拓展”的。
为了解决上面的问题，我首先将排阵函数的细节从Field类中剥离, 用一个专门的类DrawField进行布阵。DrawField类中，如果依旧是一个函数解决一种布阵排列，那本质上并没有提升，于是设计了从图片中识别布阵（输入黑白图片，根据Field阵地大小对图片进行划分，划分方块中如果有着色就排布上生物，返回二维布尔数组让Field类依据该数组布阵），类的拓展性大幅提升：
```
class DrawField{
    .......
    public Boolean[][] Draw(String ImageName, int FieldHeight, int FieldWidth);
    ......
}
class Field{
    .......
    public void Deploy(String FieldName, Creature[] creature){
        .........
        Boolean[][] cache = DrawField.Draw(FieldName, height, width);
        /*根据cache排阵*/
    }
    .......
}
```
如此，只需要在项目的资源文件中提供一张布阵的图片就可以实现相应布阵，不需要任何代码的删改。

###依赖倒置原则
高层模块不能依赖于底层模块，二者都应该依赖于抽象。良好的接口设计使得高层代码使用底层提供的接口进行实现，底层的变动不会导致高层代码的修改。我尽量遵循该原则，用Position接口，Creature接口实现二维空间坐标，各种生物体之间的隔离，布阵操作均调用接口实现，降低了代码间耦合。


