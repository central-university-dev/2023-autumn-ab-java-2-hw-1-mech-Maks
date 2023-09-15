package edu.SecondTask.FirstVersion;

import edu.SecondTask.Person;

public class LogProcessor implements PersonProcessor {
    @Override
    public void process(Person person) {
        System.out.println(person + " changed");
    }
}
