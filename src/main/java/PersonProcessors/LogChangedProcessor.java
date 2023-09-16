package PersonProcessors;
import edu.example.Person;
import java.util.function.Consumer;

public class LogChangedProcessor implements Consumer<Person> {
    @Override
    public void accept(Person person) {
        System.out.println("changed");
    }
}
