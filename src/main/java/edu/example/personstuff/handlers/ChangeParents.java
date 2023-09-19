package edu.example.personstuff.handlers;

import edu.example.personstuff.Person;
import lombok.NoArgsConstructor;

@NoArgsConstructor
public class ChangeParents implements Handler<Person> {
    @Override
    public void handle(Person person) {
        Person mother = person.getMother();
        person.setMother(person.getFather());
        person.setFather(mother);
    }
}
