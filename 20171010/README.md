# 面向葫芦娃编程 之 阵法篇

## 第零章 背景
> 按《孙膑兵法．十阵第十六》记载：“凡阵有十：有方阵，有圆阵，有疏阵，有数阵，有椎形阵，有雁形阵，有钩形阵，有玄疑阵，有火阵，有水阵。”

众所周知，在葫芦娃那个年代，打架是要有阵法的，这样才能统一指挥并增强攻击力，即使实力较弱的一方也会因此变得易守难攻。
这不，葫芦兄弟又遇到了妖精们，由于人数较少，爷爷指挥的葫芦兄弟摆出长蛇阵防守；蝎子精带领的小喽啰们摆出各种架势试图进攻。欲知后事如何，请听下文分解。

## 第一章 造物主
> 葫芦娃，葫芦娃，一根藤上七朵花。

还记得上面那句歌词吗？实际上，它就是对造物主工作最真实的写照。
造物主是谁？我们无从得知。但是，它确实做了许多伟大的事情，比如，每个被造物都有自己的名字，都有自己的属性。比如大娃叫`大娃`，属性`红`。造物主喜欢简约风格，所以每个属性都用一个汉字表示好了。
每个被造物都拥有这样的属性，不如把被造物用一个基类表示好了：
```
public class Creature {
    Creature(String name, String attr)；
    public String getName()；
    public String getAttr()；
}
```

##第二章 被造物
> 龙生龙，凤生凤，老鼠生的儿子会打洞。

自造物主发明被造物之后，地球上的物种爆炸式增长。它们不仅仅表现了被造物应有的属性，还各自发展出一套本领。比如大娃又叫`大力娃`，二娃又叫`千里眼`。
是的，聪明的造物主早就想到了，让它们各自继承被造物吧！
```
// 爷爷
public class Grandpa extends Creature {
    Grandpa() {
        super("爷爷", "爷");
    }
}
```
```
// 葫芦兄弟
public class CalabashBrother extends Creature {
    CalabashBrother(int i) {
        super(CalabashNames.values()[i].toString(),
              CalabashColors.values()[i].toString());
    }
}

enum CalabashNames {
    大娃, 二娃, 三娃, 四娃, 五娃, 六娃, 七娃
}

enum CalabashColors {
    赤, 橙, 黄, 绿, 青, 蓝, 紫
}
```

## 第三章 战斗
> 狭路相逢勇者胜。

这一天，爷爷带领葫芦兄弟正在巡逻，偶遇蝎子精带着小喽啰们在作恶。他们展开一场激烈的战斗...
爷爷带领的葫芦兄弟占据左侧险峻地形，易守难攻。蝎子精带着小喽啰们占据右侧宽敞地形，方便逃跑。
爷爷觉得自己人数太少，让葫芦娃随机站成长蛇阵型。蝎子精为了虚张声势，让小喽啰们张牙舞爪地变换了多种阵型。
如何指挥呢？真是个问题。作为领导者，爷爷和蝎子精早就想好了。每个被造物都是有生日的，按照生日将他们分为长幼，每个生物都好区分了。在地图的每个点上安排他们的编号，他们根据自己的编号站队，就可以形成阵法。
当然啦，安排每一个点实在是太困难，领导者可没这心思。直接用数学方法描述好了，其实也就几个循环，每次换阵型前先让它们全部回来看看新阵型，然后根据编号站位。蝎子精心里如是想。
```
public class Battle {
    // each position's index is creatures' index.
    private int [][]map;

    // map size, no less than 12
    private final int SIZE = 12;

    /* contains all creatures;
     * 0 for grandpa, 1~7 for calabash brothers, 8 for scorpion king and others for lackeys
     */
    private Creature[] creatures;

    // creatures num
    private final int NUM = 28;

    // init creatures and map, and place grandpa and the scorpion king.
    Battle();

    // print the map
    void print();

    // rand sort calabash brothers
    void randCalabashArray();

    // clear villains area and then place a new array
    private void clearVillainsArea();

    // crane wing array (鹤翼)
    void craneWingArray();

    // goose fly array (雁行)
    void gooseFlyArray();

    // Balance yoke array (衡轭)
    void balanceYokeArray();

    // long snake array (长蛇)
    void longSnakeArray();

    // fish scale array (鱼鳞)
    void fishScaleArray();

    // square round array (方円)
    void squareRoundArray();
    // lay down half moon array (偃月)
    void layDownHalfMoonArray();

    // sharp array array (锋矢)
    void sharpArrayArray();
}
```

## 第四章 开始战斗吧！

> \-\-\-\-\-\-\-\-\-\-鹤翼\-\-\-\-\-\-\-\-\-\-

>     爷          蝎      
>                         
>                         
>     紫                  
>     绿    喽          喽
>     蓝      喽      喽  
>     黄        喽  喽    
>     青          喽      
>     赤                  
>     橙                  
>                         
>                         
> 
> \-\-\-\-\-\-\-\-\-\-雁行\-\-\-\-\-\-\-\-\-\-

>     爷          蝎      
>                         
>                         
>     青                  
>     黄              喽  
>     赤            喽    
>     橙          喽      
>     绿        喽        
>     蓝      喽          
>     紫                  
>                         
>                         
> 
> \-\-\-\-\-\-\-\-\-\-衡轭\-\-\-\-\-\-\-\-\-\-

>     爷          蝎      
>                         
>                         
>     赤          喽      
>     黄        喽        
>     蓝          喽      
>     绿        喽        
>     紫          喽      
>     橙        喽        
>     青                  
>                         
>                         
> 
> \-\-\-\-\-\-\-\-\-\-长蛇\-\-\-\-\-\-\-\-\-\-

>     爷          蝎      
>                         
>                         
>     紫          喽      
>     赤          喽      
>     橙          喽      
>     绿          喽      
>     青          喽      
>     黄          喽      
>     蓝          喽      
>                         
>                         
> 
> \-\-\-\-\-\-\-\-\-\-鱼鳞\-\-\-\-\-\-\-\-\-\-

>     爷          蝎      
>                         
>                         
>     赤                  
>     紫          喽      
>     绿            喽    
>     橙      喽喽喽喽喽  
>     青    喽喽喽喽喽喽喽
>     蓝        喽喽      
>     黄                  
>                         
>                         
> 
> \-\-\-\-\-\-\-\-\-\-方円\-\-\-\-\-\-\-\-\-\-

>     爷          蝎      
>                         
>                         
>     赤                  
>     橙          喽      
>     黄        喽  喽    
>     紫      喽      喽  
>     青        喽  喽    
>     绿          喽      
>     蓝                  
>                         
>                         
> 
> \-\-\-\-\-\-\-\-\-\-偃月\-\-\-\-\-\-\-\-\-\-

>     爷          蝎      
>                         
>                   喽    
>     赤          喽喽    
>     青        喽喽      
>     黄      喽喽        
>     绿      喽喽        
>     橙      喽喽        
>     紫        喽喽      
>     蓝          喽喽    
>                   喽    
>                         
> 
> \-\-\-\-\-\-\-\-\-\-锋矢\-\-\-\-\-\-\-\-\-\-

>     爷          蝎      
>                         
>                         
>     橙          喽      
>     赤        喽喽喽    
>     绿      喽  喽  喽  
>     黄    喽    喽    喽
>     紫          喽      
>     蓝          喽      
>     青          喽

