package app;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class DataHandler {

    private final Lock lock = new ReentrantLock();

    public int modify(int num) {
        lock.lock();
        try {
            int counter = 3;
            num = num * counter;
            return num;
        } finally {
            lock.unlock();
        }
    }
}