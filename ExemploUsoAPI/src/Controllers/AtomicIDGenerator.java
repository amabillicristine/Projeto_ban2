package Controllers;

import java.util.concurrent.atomic.AtomicInteger;


public class AtomicIDGenerator {
    
 private static final AtomicInteger counter = new AtomicInteger();

    public static int generateID() {
        return counter.incrementAndGet();
    }   
}
