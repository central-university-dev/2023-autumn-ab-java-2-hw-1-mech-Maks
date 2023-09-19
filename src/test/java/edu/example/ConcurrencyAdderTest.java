package edu.example;

import edu.example.concurrency.ConcurrencyAdder;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ConcurrencyAdderTest {
    private final static int END_VALUE = 30001;

    @Test
    public void assertEqualsEndValue() {
        ConcurrencyAdder.execute();
        assertEquals(ConcurrencyAdder.getCount(), END_VALUE);
    }
}
