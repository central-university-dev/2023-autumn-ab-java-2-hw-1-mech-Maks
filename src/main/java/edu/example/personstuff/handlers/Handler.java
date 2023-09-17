package edu.example.personstuff.handlers;

@FunctionalInterface
public interface Handler<T> {
    public void handle(T x);
}
