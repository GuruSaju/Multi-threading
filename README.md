# Multi-threading
Notes and concepts on Multithreading

Declaring a variable as volatile means that modifying its value immediately affects the actual memory storage for the variable. The compiler cannot optimize away any references made to the variable. This guarantees that when one thread modifies the variable, all other threads see the new value immediately. (This is not guaranteed for non-volatile variables.)

Declaring an atomic variable guarantees that operations made on the variable occur in an atomic fashion, i.e., that all of the substeps of the operation are completed within the thread they are executed and are not interrupted by other threads. For example, an increment-and-test operation requires the variable to be incremented and then compared to another value; an atomic operation guarantees that both of these steps will be completed as if they were a single indivisible/uninterruptible operation.

Synchronizing all accesses to a variable allows only a single thread at a time to access the variable, and forces all other threads to wait for that accessing thread to release its access to the variable.

Synchronized access is similar to atomic access, but the atomic operations are generally implemented at a lower level of programming. Also, it is entirely possible to synchronize only some accesses to a variable and allow other accesses to be unsynchronized (e.g., synchronize all writes to a variable but none of the reads from it).

Atomicity, synchronization, and volatility are independent attributes, but are typically used in combination to enforce proper thread cooperation for accessing variables.

Addendum (April 2016)

Synchronized access to a variable is usually implemented using a monitor or semaphore. These are low-level mutex (mutual exclusion) mechanisms that allow a thread to acquire control of a variable or block of code exclusively, forcing all other threads to wait if they also attempt to acquire the same mutex. Once the owning thread releases the mutex, another thread can acquire the mutex in turn.

Addendum (July 2016)

Synchronization occurs on an object. This means that calling a synchronized method of a class will lock the this object of the call. Static synchronized methods will lock the Class object itself.

Likewise, entering a synchronized block requires locking the this object of the method.

This means that a synchronized method (or block) can be executing in multiple threads at the same time if they are locking on different objects, but only one thread can execute a synchronized method (or block) at a time for any given single object.

The effect of the volatile keyword is approximately that each individual read or write operation on that variable is atomic.

Notably, however, an operation that requires more than one read/write -- such as i++, which is equivalent to i = i + 1, which does one read and one write -- is not atomic, since another thread may write to i between the read and the write.

The Atomic classes, like AtomicInteger and AtomicReference, provide a wider variety of operations atomically, specifically including increment for AtomicInteger

***********************************************************
volatile can also be used for methods!!! Need to look into this. 
