import Image.StrImage;
import Obj.Creature.Creature;
import Obj.Creature.Huluwa.Huluwa;
import Obj.ObjImpl;
import Position.Position2D;
import Space.Space2D;
import mEnums.*;
import Camp.*;
import Formation.*;
import Image.*;
import mExceptions.*;
import Obj.*;
import Position.*;
import Space.*;

import java.util.ArrayList;

public class Game {

    static public void main(String args[]){
        try {
            ObjImpl grass = new ObjImpl(new StrImage("  "));
            Space2D space = new Space2D(new Position2D(30, 20), grass);

            Huluwa huluwas[] = {
                    new Huluwa(SENIORITY.二, COLOR.橙, new StrImage("✇")),
                    new Huluwa(SENIORITY.大, COLOR.红, new StrImage("✪")),
                    new Huluwa(SENIORITY.五, COLOR.青, new StrImage("❀")),
                    new Huluwa(SENIORITY.四, COLOR.绿, new StrImage("✦")),
                    new Huluwa(SENIORITY.七, COLOR.紫, new StrImage("❦")),
                    new Huluwa(SENIORITY.三, COLOR.黄, new StrImage("✧")),
                    new Huluwa(SENIORITY.六, COLOR.蓝, new StrImage("❧")),
            };

            CampImpl c1 = new CampImpl(new FormationImpl(RecordSource.长蛇阵), huluwas);
            c1.setLeftUpPoint(new Position2D(10, 0));
            c1.setToward(Direction.南);
            c1.lineUp();

            space.layout(c1.getCreatures());


            CreatureImpl scorpion = new CreatureImpl(new StrImage("☻"), 1);
            CampImpl c2 = new CampImpl(new FormationImpl(RecordSource.锋矢阵));
            c2.addCreature(scorpion);
            for (int i = 0; i < 20; i++) {
                c2.addCreature(new CreatureImpl(new StrImage("\uD83D\uDC38"), 2));
            }
            c2.setLeftUpPoint(new Position2D(6, 9));
            c2.setToward(Direction.北);
            c2.lineUp();
            space.layout(c2.getCreatures());

            CreatureImpl grandpa = new CreatureImpl(new Position2D(3, 2), new StrImage("♠"), 1);
            space.layout(grandpa);

            CreatureImpl snake = new CreatureImpl(new Position2D(3, 10), new StrImage("✌ "), 1);
            space.layout(snake);

            space.show();


            System.out.println("=================================================");
            space.flush(c2.getCreatures());
            c2.setFormation(new FormationImpl(RecordSource.鱼鳞阵));
            c2.lineUp();
            space.layout(c2.getCreatures());
            space.show();

            System.out.println("=================================================");
            space.flush(c2.getCreatures());
            c2.setFormation(new FormationImpl(RecordSource.鹤翼阵));
            c2.lineUp();
            space.layout(c2.getCreatures());
            space.show();

            System.out.println("=================================================");
            space.flush(c2.getCreatures());
            c2.setFormation(new FormationImpl(RecordSource.偃月阵));
            c2.lineUp();
            space.layout(c2.getCreatures());
            space.show();

            System.out.println("=================================================");
            space.flush(c2.getCreatures());
            c2.setFormation(new FormationImpl(RecordSource.方门阵));
            c2.lineUp();
            space.layout(c2.getCreatures());
            space.show();

            System.out.println("=================================================");
            space.flush(c2.getCreatures());
            c2.setFormation(new FormationImpl(RecordSource.衡轭阵));
            c2.lineUp();
            space.layout(c2.getCreatures());
            space.show();

            System.out.println("=================================================");
            space.flush(c2.getCreatures());
            c2.setFormation(new FormationImpl(RecordSource.雁行阵));
            c2.lineUp();
            space.layout(c2.getCreatures());
            space.show();
        }
        catch (SpaceCoverException e){
            System.err.println(e.toString());
        }

    }
}
