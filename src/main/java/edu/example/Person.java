package edu.example;

import lombok.Data;
import org.jetbrains.annotations.Nullable;

@Data
class Person {
    private final String name;

    @Nullable
    private Person mother;
    @Nullable
    private Person father;
    @Nullable
    private Person friend;
}
