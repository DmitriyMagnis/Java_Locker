package app;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class DataHandler {

    private final Lock lock = new ReentrantLock();
    private int counter = 0;

    public int modify(int num) {
        lock.lock();
        try {
            // ++counter не атомарная операция
            num = num * ++counter;
            return num;
        } finally {
            lock.unlock();
        }
    }
}