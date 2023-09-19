package edu.example.personstuff.chanprocessor;

import edu.example.personstuff.Person;
import edu.example.personstuff.handlers.Handler;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class PersonChainProcessor {
    private final List<Handler<Person>> handlers;

    public PersonChainProcessor(){
        handlers = new LinkedList<>();
    }

    public void addHandler(Handler<Person> handler){
        handlers.add(handler);
    }
    public void addHandlers(List<Handler<Person>> handlers){
        this.handlers.addAll(handlers);
    }

    public void process(Person person){
        if(handlers.isEmpty()){
            System.out.println("No handlers");
        }

        Iterator<Handler<Person>> iterator = handlers.iterator();
        while (iterator.hasNext()) {
            Handler<Person> handler = iterator.next();
            handler.handle(person);
            iterator.remove();
        }
    }
}
