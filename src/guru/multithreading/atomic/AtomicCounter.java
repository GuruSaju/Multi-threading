package guru.multithreading.atomic;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * 
 * @author Srisarguru
 * The incrementAndGet() and decrementAndGet() methods are two of the numeric operations 
 * provided by the AtomicLong and AtomicInteger classes. You also have getAndDecrement(), 
 * getAndIncrement(), getAndAdd(int i) and addAndGet().
 */
public class AtomicCounter {
	private final AtomicInteger value = new AtomicInteger(0);

    public int getValue(){
        return value.get();
    }

    public int getNextValue(){
        return value.incrementAndGet();
    }

    public int getPreviousValue(){
        return value.decrementAndGet();
    }
}
