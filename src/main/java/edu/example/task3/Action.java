package edu.example.task3;

import lombok.Getter;

@Getter
public class Action {
    private int count = 1;
    public synchronized void increments(){
        for (int i = 0;i<10000;i++){
            count++;
        }
    }
}
