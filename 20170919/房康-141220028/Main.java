import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Person> list = new ArrayList<>();
        list.add(new Person(Person.Order.ONE, Person.Color.RED));
        list.add(new Person(Person.Order.TWO, Person.Color.ORANGE));
        list.add(new Person(Person.Order.THREE, Person.Color.YELLOW));
        list.add(new Person(Person.Order.FOUR, Person.Color.GREEN));
        list.add(new Person(Person.Order.FIVE, Person.Color.CYAN));
        list.add(new Person(Person.Order.SIX, Person.Color.BLUE));
        list.add(new Person(Person.Order.SEVEN, Person.Color.PURPLE));

        Sorter sorter = new Sorter();

        Collections.shuffle(list);
        sorter.bubbleSort(list, Comparator.comparingInt(o -> o.getOrder().ordinal()));
        for(Person person : list){
            person.talk();
        }
        System.out.println("===============================");

        Collections.shuffle(list);
        sorter.quickSort(list, Comparator.comparingInt(o -> o.getColor().ordinal()));
        for(Person person : list){
            person.talk();
        }
    }
}
