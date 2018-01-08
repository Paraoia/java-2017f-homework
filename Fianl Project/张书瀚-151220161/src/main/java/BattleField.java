import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.*;
import java.util.ArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class BattleField extends JPanel implements Constants {
    //生物
    public ArrayList<Boy> boys = new ArrayList<>();
    public ArrayList<Goblin> goblins = new ArrayList<>();
    public Grandpa grandpa;
    public Snake snake;
    public Scorpion scorpion;
    public Position positions[][] = new Position[WUNIT][HUNIT];
    //线程池
    public ExecutorService executorService;
    //读写
    private BufferedWriter bufferedWriter;
    private int writeCount = 0;
    public BATTLESTATUS battlestatus = BATTLESTATUS.PREPARE;
    public FORMATIONS boyFormation = FORMATIONS.SNAKE;
    public FORMATIONS goblinFormation = FORMATIONS.SNAKE;


    public BattleField() {
        addKeyListener(new MyAdapter());
        setFocusable(true);
        initField();
    }


    public void initField() {
        executorService = Executors.newCachedThreadPool();
        //初始化战场
        initFormation();
    }


    public void initFormation() {
        for (int i = 0; i < WUNIT; i++) {
            for (int j = 0; j < HUNIT; j++) {
                positions[i][j] = new Position(i, j);
            }
        }

        switch (boyFormation) {
            case ARROW:
                new ArrowFormatter().format(this, 1);
                break;
            case MOON:
                new MoonFormatter().format(this, 1);
                break;
            case WING:
                new WingFormatter().format(this, 1);
                break;
            case GOOSE:
                new GooseFormatter().format(this, 1);
                break;
            case SCALE:
                new ScaleFormatter().format(this, 1);
                break;
            case SNAKE:
                new SnakeFormatter().format(this, 1);
                break;
            case SQUARE:
                new SquareFormatter().format(this, 1);
                break;
            case BALANCE:
                new BalanceFormatter().format(this, 1);
                break;
        }

        switch (goblinFormation) {
            case ARROW:
                new ArrowFormatter().format(this, 2);
                break;
            case MOON:
                new MoonFormatter().format(this, 2);
                break;
            case WING:
                new WingFormatter().format(this, 2);
                break;
            case GOOSE:
                new GooseFormatter().format(this, 2);
                break;
            case SCALE:
                new ScaleFormatter().format(this, 2);
                break;
            case SNAKE:
                new SnakeFormatter().format(this, 2);
                break;
            case SQUARE:
                new SquareFormatter().format(this, 2);
                break;
            case BALANCE:
                new BalanceFormatter().format(this, 2);
                break;
        }
    }


    @Override
    public void paint(Graphics g) {
        super.paint(g);
        drawField(g);
    }

    public void drawField(Graphics g) {
        g.setColor(new Color(255, 255, 255));
        g.fillRect(0, 0, SCALE * WUNIT, SCALE * HUNIT);
        if (battlestatus == BATTLESTATUS.PREPARE) {
            g.drawImage(new ImageIcon(getClass().getClassLoader().getResource
                            ("prepare.png")).getImage(),
                    0, 0, this);
        } else if (battlestatus == BATTLESTATUS.FIGHTING) {
            g.drawImage(new ImageIcon(getClass().getClassLoader().getResource
                            ("background.png")).getImage(),
                    0, 0, this);
            for (int i = 0; i < WUNIT; i++) {
                for (int j = 0; j < HUNIT; j++) {
                    if (positions[i][j].getImageName() != null) {
                        //System.out.println(positions[i][j].getImageName());
                        Image image = new ImageIcon(getClass().getClassLoader()
                                .getResource(positions[i][j].getImageName()))
                                .getImage();
                        g.drawImage(image, i * SCALE, j * SCALE, this);
                    }
                    if (!positions[i][j].getDeadBodies().isEmpty()) {
                        for (String body : positions[i][j].getDeadBodies()) {
                            //System.out.println(body);
                            Image bodyImage = new ImageIcon(getClass()
                                    .getClassLoader().getResource(body))
                                    .getImage();

                            g.drawImage(bodyImage, i * SCALE, j * SCALE, this);
                        }
                    }

                }
            }
        } else if (battlestatus == BATTLESTATUS.JUSTICE) {
            g.drawImage(new ImageIcon(getClass().getClassLoader().getResource
                            ("justice.png")).getImage(),
                    0, 0, this);
        } else if (battlestatus == BATTLESTATUS.EVIL) {
            g.drawImage(new ImageIcon(getClass().getClassLoader().getResource
                            ("evil.png")).getImage(),
                    0, 0, this);
        }
    }

    public void printPositions() {
        try {
            bufferedWriter.write("Position:");
            bufferedWriter.newLine();
        } catch (Exception e) {
            e.printStackTrace();
        }

        for (int i = 0; i < WUNIT; i++) {
            for (int j = 0; j < HUNIT; j++) {
                try {
                    bufferedWriter.write(i + "-" + j + ":");
                    bufferedWriter.write(positions[i][j].printStatus());
                    bufferedWriter.newLine();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }

    private void restart() {
        boys.clear();
        goblins.clear();
        executorService.shutdownNow();
        initField();

        battlestatus = BATTLESTATUS.PREPARE;
        repaint();
    }

    public void checkGameOver() {
        boolean flag = false;
        for (Boy boy : boys) {
            if (boy.isAlive()) {
                if (boy.getRank() != 6) {
                    flag = true;
                    break;
                }
            }
        }
        if (!flag) { //葫芦娃死完了
            battlestatus = BATTLESTATUS.EVIL;
            repaint();
            executorService.shutdownNow();

            try {
                bufferedWriter.close();
            } catch (Exception e) {
                e.printStackTrace();
            }

            System.out.println("evil win");
        }

        flag = false;
        for (Goblin gob : goblins) {
            if (gob.isAlive()) {
                flag = true;
                break;
            }
        }
        if (!flag && !scorpion.isAlive()) {  //妖怪死完了
            battlestatus = BATTLESTATUS.JUSTICE;
            repaint();
            executorService.shutdownNow();
            try {
                bufferedWriter.close();
            } catch (Exception e) {
                e.printStackTrace();
            }

            System.out.println("justice win");
        }
    }

    private class MyAdapter extends KeyAdapter {
        @Override
        public void keyPressed(KeyEvent keyEvent) {
            int code = keyEvent.getKeyCode();
            switch (code) {
                case KeyEvent.VK_SPACE:
                    battlestatus = BATTLESTATUS.FIGHTING;
                    writeCount++;
                    String fileName = System.getProperty("user.dir")
                            + "/record-battle" + writeCount + ".txt";
                    try {
                        bufferedWriter = new BufferedWriter(new FileWriter
                                (fileName));
                    } catch (Exception writerException) {
                        writerException.printStackTrace();
                    }

                    for (Boy boy : boys) {
                        executorService.execute(boy);
                    }
                    for (Goblin gob : goblins) {
                        executorService.execute(gob);
                    }
                    executorService.execute(grandpa);
                    executorService.execute(scorpion);
                    executorService.execute(snake);
                    break;

                case KeyEvent.VK_R:
                    restart();
                    break;

                case KeyEvent.VK_L:
                    JFileChooser jFileChooser = new JFileChooser(System
                            .getProperty("user.dir"));
                    int returnValue = jFileChooser.showOpenDialog(null);
                    if (returnValue == JFileChooser.APPROVE_OPTION) {
                        File selectedFile = jFileChooser.getSelectedFile();
                        String test = selectedFile.getName();
                        if (test.startsWith("record-battle") && test.endsWith
                                ("" +
                                        ".txt")) {
                            new Replay(selectedFile).start();
                        } else {
                            return;
                        }

                    }
                    break;

                default:
                    break;
            }
        }
    }


    class Replay extends Thread {

        private BufferedReader bufferedReader;

        public Replay(File file) {
            try {
                bufferedReader = new BufferedReader(new FileReader(file));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        @Override
        public void run() {
            try {
                battlestatus = BATTLESTATUS.FIGHTING;
                while (true) {

                    for (int i = 0; i < WUNIT; i++) {
                        for (int j = 0; j < HUNIT; j++) {
                            positions[i][j] = new Position(i, j);
                        }
                    }

                    String test = bufferedReader.readLine();
                    if (test.equals("Position:")) {
                        for (int i = 0; i < WUNIT; i++) {
                            for (int j = 0; j < HUNIT; j++) {
                                String temp = bufferedReader.readLine();
                                //System.out.println("temp:" + temp);
                                String[] arr = temp.split(":");
                                if (arr.length > 1) {
                                    //System.out.println("arr1:" + arr[1]);
                                    String[] pics = arr[1].split(" ");
                                    if(pics[0].endsWith(".png")) {
                                        positions[i][j].setImageName(pics[0]);
                                    }
                                    //System.out.println("0:" + pics[0]);
                                    if (pics.length > 1) {
                                        for (int k = 1; k < pics.length; k++) {
                                            if (pics[k].endsWith(".png")) {
                                                positions[i][j].addDeadBodies
                                                    (pics[k]);
                                            }
                                            //System.out.println(k + ":" +pics[k]);
                                        }
                                    }
                                }

                            }
                        }
                    }
                    repaint();
                    sleep(100);
                }
            } catch (Exception e) {
                e.printStackTrace();
                try {
                    bufferedReader.close();
                } catch (Exception e1) {
                    System.out.println("复盘完成");
                }
                //restartLevel();
                Thread.currentThread().interrupt();
            }
        }
    }


}


enum BATTLESTATUS {
    PREPARE, FIGHTING, JUSTICE, EVIL,
}

enum FORMATIONS {
    ARROW, BALANCE, GOOSE, MOON, SCALE, SNAKE, SQUARE, WING,
}
