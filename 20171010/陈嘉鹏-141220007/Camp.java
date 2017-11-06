import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class Camp {
    Formation form;
    ArrayList<Creature> creatures = new ArrayList<Creature>();
    Position leftUp;
    Direction campDirection;


    public Camp(Formation form){
        this.form = form;
    }
    public Camp(Formation form, Creature[] creatures){
       this(form);
       this.creatures = new ArrayList<Creature>(Arrays.asList(creatures));
    }
    public Camp(Formation form, Creature[] creatures, Position leftUp, Direction campDirection){
        this(form, creatures);
        this.leftUp = leftUp;
        this.campDirection = campDirection;
    }

    public void flush(Space sp){
        for (Creature c :
                creatures) {
            c.flush(sp);
        }
    }

    public void changeForm(Formation form, Space sp){
        flush(sp);
        this.form = form;
    }
    public void changeLeftUp(Position leftUp, Space sp){
        flush(sp);
        setLeftUp(leftUp);
    }

    public Formation getForm() {
        return form;
    }

    public void setLeftUp(Position leftUp) {
        this.leftUp = leftUp;
    }

    public void setCampDirection(Direction campDirection) {
        this.campDirection = campDirection;
    }

    public Position getLeftUp() {
        return leftUp;
    }

    public Direction getCampDirection() {
        return campDirection;
    }

    public void Sort(){
        Collections.sort(creatures);
    }
    public void layout(Space sp){
        this.Sort();
        form.lineUp(creatures, leftUp, campDirection);
        for (Creature c :
                creatures) {
            c.layout(sp);
        }
    }

    public void addCreature(Creature creature){
        creatures.add(creature);
    }
    public void deleteCreature(Creature creature){
        creatures.remove(creature);
    }


}
