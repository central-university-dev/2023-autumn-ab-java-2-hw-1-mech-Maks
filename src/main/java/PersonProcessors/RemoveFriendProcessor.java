package PersonProcessors;
import edu.example.Person;
import java.util.Optional;
import java.util.function.Consumer;

public class RemoveFriendProcessor implements Consumer<Person> {
    @Override
    public void accept(Person person) {
        Optional.ofNullable(person)
                .map(x->x.friend=null)
                .orElse(null);
    }
}
