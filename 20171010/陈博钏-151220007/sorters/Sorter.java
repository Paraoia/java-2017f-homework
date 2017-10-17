package sorters;

import creature.Creature;

import java.util.ArrayList;

import game.Map;

/**
 * Created by cbcwe on 2017/10/16.
 */

public interface Sorter {
    // start in (start_x, start_y)
    public void sort(Map map, int start_x, int start_y, ArrayList<Creature> creatures);
}
