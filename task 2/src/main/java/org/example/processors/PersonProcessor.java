package org.example.processors;

import org.example.Person;

import java.util.function.Function;

public interface PersonProcessor extends Function<Person, Person> {}
