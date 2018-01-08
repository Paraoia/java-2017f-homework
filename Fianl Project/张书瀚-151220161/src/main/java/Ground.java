import javax.swing.*;


public class Ground extends JFrame implements Constants {

    JMenuBar jMenuBar;
    JMenu boyMenu, goblinMenu;
    JMenuItem BArrow, BBalance, BGoose, BMoon, BScale, BSnake, BSquare, BWing;
    JMenuItem GArrow, GBalance, GGoose, GMoon, GScale, GSnake, GSquare, GWing;

    public Ground() {
        BattleField field = new BattleField();

        createMenu(field);
        setJMenuBar(jMenuBar);

        add(field);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(SCALE * WUNIT, SCALE * HUNIT + 100);
        setLocationRelativeTo(null);
        setTitle("HuluWar");


        //about battlefield
        // 0---------->x
        // |
        // |
        // |
        // |
        // V
        // y
    }


    public void createMenu(BattleField field) {
        //创建菜单
        jMenuBar = new JMenuBar();
        boyMenu = new JMenu("葫芦娃阵型");
        goblinMenu = new JMenu("妖怪阵型");

        //创建菜单项-葫芦娃
        BArrow = new JMenuItem("锋矢阵");
        BArrow.addActionListener((e) -> {
            field.boyFormation = FORMATIONS.ARROW;
            field.initFormation();
        });
        BBalance = new JMenuItem("横轭阵");
        BBalance.addActionListener((e) -> {
            field.boyFormation = FORMATIONS.BALANCE;
            field.initFormation();
        });
        BGoose = new JMenuItem("雁行阵");
        BGoose.addActionListener((e) -> {
            field.boyFormation = FORMATIONS.GOOSE;
            field.initFormation();
        });
        BMoon = new JMenuItem("偃月阵");
        BMoon.addActionListener((e) -> {
            field.boyFormation = FORMATIONS.MOON;
            field.initFormation();
        });
        BScale = new JMenuItem("鱼鳞阵");
        BScale.addActionListener((e) -> {
            field.boyFormation = FORMATIONS.SCALE;
            field.initFormation();
        });
        BSnake = new JMenuItem("长蛇阵");
        BSnake.addActionListener((e) -> {
            field.boyFormation = FORMATIONS.SNAKE;
            field.initFormation();
        });
        BSquare = new JMenuItem("方円阵");
        BSquare.addActionListener((e) -> {
            field.boyFormation = FORMATIONS.SQUARE;
            field.initFormation();
        });
        BWing = new JMenuItem("鹤翼阵");
        BWing.addActionListener((e) -> {
            field.boyFormation = FORMATIONS.WING;
            field.initFormation();
        });

        //创建菜单项-妖怪
        GArrow = new JMenuItem("锋矢阵");
        GArrow.addActionListener((e) -> {
            field.goblinFormation = FORMATIONS.ARROW;
            field.initFormation();
        });
        GBalance = new JMenuItem("横轭阵");
        GBalance.addActionListener((e) -> {
            field.goblinFormation = FORMATIONS.BALANCE;
            field.initFormation();
        });
        GGoose = new JMenuItem("雁行阵");
        GGoose.addActionListener((e) -> {
            field.goblinFormation = FORMATIONS.GOOSE;
            field.initFormation();
        });
        GMoon = new JMenuItem("偃月阵");
        GMoon.addActionListener((e) -> {
            field.goblinFormation = FORMATIONS.MOON;
            field.initFormation();
        });
        GScale = new JMenuItem("鱼鳞阵");
        GScale.addActionListener((e) -> {
            field.goblinFormation = FORMATIONS.SCALE;
            field.initFormation();
        });
        GSnake = new JMenuItem("长蛇阵");
        GSnake.addActionListener((e) -> {
            field.goblinFormation = FORMATIONS.SNAKE;
            field.initFormation();
        });
        GSquare = new JMenuItem("方円阵");
        GSquare.addActionListener((e) -> {
            field.goblinFormation = FORMATIONS.SQUARE;
            field.initFormation();
        });
        GWing = new JMenuItem("鹤翼阵");
        GWing.addActionListener((e) -> {
            field.goblinFormation = FORMATIONS.WING;
            field.initFormation();
        });

        //添加葫芦娃菜单
        boyMenu.add(BArrow);
        boyMenu.add(BBalance);
        boyMenu.add(BGoose);
        boyMenu.add(BMoon);
        boyMenu.add(BScale);
        boyMenu.add(BSnake);
        boyMenu.add(BSquare);
        boyMenu.add(BWing);
        //添加妖怪菜单
        goblinMenu.add(GArrow);
        goblinMenu.add(GBalance);
        goblinMenu.add(GGoose);
        goblinMenu.add(GMoon);
        goblinMenu.add(GScale);
        goblinMenu.add(GSnake);
        goblinMenu.add(GSquare);
        goblinMenu.add(GWing);

        jMenuBar.add(boyMenu);
        jMenuBar.add(goblinMenu);
    }

}
