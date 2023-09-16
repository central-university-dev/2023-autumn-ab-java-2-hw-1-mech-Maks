package PersonProcessors;

import edu.example.Person;

import java.util.Optional;
import java.util.function.Consumer;

public class SwapParentsProcessor implements Consumer<Person> {
    @Override
    public void accept(Person person) {
        Optional.ofNullable(person)
                .map(x -> {
                    var father = x.father;
                    x.father = x.mother;
                    x.mother = father;
                    return x;
                })
                .orElse(null);

    }
}
