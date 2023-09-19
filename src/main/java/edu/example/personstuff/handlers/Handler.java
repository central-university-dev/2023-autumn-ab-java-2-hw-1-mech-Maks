package edu.example.personstuff.handlers;

@FunctionalInterface
public interface Handler<T> {
    void handle(T x);
}
